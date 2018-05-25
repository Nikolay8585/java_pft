package ru.stqa.pft.addressbook.tests;


import org.hibernate.AssertionFailure;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.*;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactAddToGroupTests extends TestBase {


    @Test(enabled = false)
    public void testContactAddToGroup() {

        Groups groups = app.db().groups();
        if (groups.size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test4").withHeader("test4").withFooter("test4"));
            groups = app.db().groups();
        }
        GroupData group = groups.iterator().next();
        Contacts before = app.db().contacts();
        ContactData contact = before.iterator().next();
        ContactInGroupData contactInGroup = new ContactInGroupData()
                .withContactId(contact.getId())
                .withGroupId(group.getId());
        ContactsInGroups beforeContactsInGroups = app.db().contactsInGroups();
        if (beforeContactsInGroups.contains(contactInGroup)) {
            app.goTo().groupPage();
            app.group().create(group.withName("test5").withHeader("test5").withFooter("test5"));
            groups = app.db().groups();
        }
        GroupData myGroup = null;
        while (groups.iterator().hasNext()) {
            myGroup = groups.iterator().next();
            if (myGroup.getName().equals(group.getName())) {
                break;
            };
        }
        assert(myGroup != null);
        contactInGroup.withGroupId(myGroup.getId());
        app.goTo().homePage();
        app.contact().addToGroup(contact, myGroup);
        app.goTo().homePage();
        ContactsInGroups afterContactsInGroups = app.db().contactsInGroups();
        assertThat(true, equalTo(afterContactsInGroups.contains(contactInGroup)));

    }


    @Test(enabled = false)
    public void testContactAddToGroup2() {

        Groups groupsBefore = app.db().groups();
        if (groupsBefore.size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test4").withHeader("test4").withFooter("test4"));
            groupsBefore = app.db().groups();
        }
        GroupData group = groupsBefore.iterator().next();
        Contacts contactsBefore = app.db().contacts();
        ContactData contact = contactsBefore.iterator().next();
        if (contact.getGroups().contains(group)) {
            app.goTo().groupPage();
            app.group().create(group.withName("test5").withHeader("test5").withFooter("test5"));
        }
        app.goTo().homePage();
        app.contact().addToGroup(contact, group);
        app.goTo().homePage();
        //Groups groupsAfter = app.db().groups();
        Contacts contactsAfter = app.db().contacts();
        ContactData myContact = null;
        while (contactsAfter.iterator().hasNext()) {
            myContact = contactsAfter.iterator().next();
            if (myContact.equals(contact)) {
                break;
            }
        }
        assert(myContact != null);
        assertThat(true, equalTo(myContact.getGroups().contains(group)));
    }
}
