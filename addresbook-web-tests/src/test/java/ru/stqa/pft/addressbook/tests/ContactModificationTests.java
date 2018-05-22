package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (app.db().contacts().size() == 0) {
            app.goTo().addNewPage();
            app.contact().create(
                    new ContactData().withFirstName("Sasha").withLastName("Pushkin")
                            .withPhoneHome("333").withEMail("SP@mail.ru"));
            app.goTo().homePage();
        }
    }

    @Test (enabled = true)
    public void testContactModification() {

        Contacts before = app.db().contacts();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstName("John").withLastName("Sylver")
                .withPhoneHome("555").withEMail("JS@mail.ru");
        app.goTo().homePage();
        app.contact().modify(contact);
        app.goTo().homePage();
        Contacts after = app.db().contacts();
        assertEquals(after.size(), before.size());
        assertThat(after, equalTo(before.withOut(modifiedContact).withAdded(contact)));

        verifyContactListInUI();
    }

}
