package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.Iterator;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@Test
public class ContactDeleteFromGroupTests extends TestBase {
    public void testContactDeleteFromGroup() {
        ContactData contact = new ContactData();
        Contacts contactsBefore = app.db().contacts();
        //GroupData group = new GroupData();
        Groups groupsBefore = app.db().groups();
        if (groupsBefore.size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test" + String.valueOf(System.currentTimeMillis())).withHeader("test4").withFooter("test4"));
            groupsBefore = app.db().groups();
        }
        GroupData group = groupsBefore.iterator().next();
        if (contactsBefore.size() == 0) {
            app.goTo().addNewPage();
            app.contact().create(new ContactData()
                    .withFirstName("Vasia").withLastName("Pupkin")
                    .withPhoneMobile(String.valueOf(System.currentTimeMillis())).inGroup(group));
            contactsBefore = app.db().contacts();
        }

        Iterator<ContactData> contactIterator = contactsBefore.iterator();
        while (contactIterator.hasNext()) {
            contact = contactIterator.next();
            if (contact.getGroups().size() != 0) {
                group = contact.getGroups().iterator().next();
                break;
            }
        }
        if (contact.getGroups().size() == 0) {
            app.goTo().homePage();
            app.contact().addToGroup(contact, group);
        }
        app.goTo().homePage();
        app.contact().removeFromGroup(contact, group);
        Contacts contactsAfter = app.db().contacts();
        contactIterator = contactsAfter.iterator();
        ContactData myContact = null;
        while (contactIterator.hasNext()) {
            myContact = contactIterator.next();
            if (myContact.getId() == contact.getId()) {
                break;
            }
        }
        assert(myContact != null);
        assertThat(false, equalTo(myContact.getGroups().contains(group)));
    }
}
