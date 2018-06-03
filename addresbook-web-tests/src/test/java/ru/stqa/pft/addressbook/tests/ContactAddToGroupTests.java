package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.*;
import java.util.Iterator;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactAddToGroupTests extends TestBase {


    @Test()
    public void testContactAddToGroup() {

        Groups groupsBefore = app.db().groups();
        if (groupsBefore.size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test4").withHeader("test4").withFooter("test4"));
            groupsBefore = app.db().groups();
        }
        GroupData group = groupsBefore.iterator().next();
        Contacts contactsBefore = app.db().contacts();
        if (contactsBefore.size() == 0) {
            app.goTo().addNewPage();
            app.contact().create(new ContactData()
                    .withFirstName("Vasia").withLastName("Pupkin")
                    .withPhoneMobile(String.valueOf(System.currentTimeMillis())));
            contactsBefore = app.db().contacts();
        }
        ContactData contact = contactsBefore.iterator().next();
        if (contact.getGroups().contains(group)) {
            app.goTo().groupPage();
            app.group().create(group.withName("test5" + System.currentTimeMillis()).withHeader("test5").withFooter("test5"));
        }
        app.goTo().homePage();
        app.contact().addToGroup(contact, group);
        app.goTo().homePage();
        Groups groupsAfter = app.db().groups();
        GroupData myGroup = null;
        Iterator<GroupData> it = groupsAfter.iterator();
        while (it.hasNext()) {
            myGroup = it.next();
            if (myGroup.getName().equals(group.getName())) {
                break;
            }
        }
        assert(myGroup != null);
        Contacts contactsAfter = app.db().contacts();
        Iterator<ContactData> contactIterator = contactsAfter.iterator();
        ContactData myContact = null;
        while (contactIterator.hasNext()) {
            myContact = contactIterator.next();
            if (myContact.getId() == contact.getId()) {
                break;
            }
        }
        assert(myContact != null);
        assertThat(myContact.getGroups(), equalTo(contact.inGroup(myGroup).getGroups()));
        /*Groups groupsAfter = app.db().groups();
        GroupData myGroup = null;
        Iterator<GroupData> it = groupsAfter.iterator();
        while (it.hasNext()) {
            myGroup = it.next();
            if (myGroup.getName().equals(group.getName())) {
                break;
            }
        }
        assert(myGroup != null);
        assertThat(true, equalTo(myGroup.getContacts().contains(contact)));*/
    }
}
