package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactRemoveFromGroupTest extends TestBase{

    @Test
    public void testContactRemoweFromGroup() {
        Groups groups = app.db().groups();
        GroupData group = groups.iterator().next();
        Contacts before = app.db().contacts();
        ContactData contact = before.iterator().next();
        ContactInGroupData contactInGroup = new ContactInGroupData()
                .withContactId(contact.getId())
                .withGroupId(group.getId());
        //File photo = new File("src/test/resources/smile.png");
        /*ContactData newContact = new ContactData()
                .withFirstName("Toto").withLastName("Mursikov")
                .withPhoneHome("111").withEMail("11@mail.ru").inGroup(groups.iterator().next()).withAddress("Moscow");

         */
        app.goTo().homePage();
        app.contact().addToGroup(contact, group);
        app.goTo().homePage();
        ContactsInGroups contactsInGroups = app.db().contactsInGroups();
        assertThat(true, equalTo(contactsInGroups.contains(contactInGroup)));
    }

}
