package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (app.db().contacts().size() == 0) {
            app.goTo().addNewPage();
            app.contact().create(
                    new ContactData().withFirstName("Sasha").withLastName("Pushkin")
                            .withPhoneHome("333").withEMail("SP@mail.ru").withGroup("[none]"));
            app.goTo().homePage();
        }
    }

    @Test (enabled = true)
    public void testContactDeletion() {

        Contacts before = app.db().contacts();
        ContactData deletedContact = before.iterator().next();
        app.goTo().homePage();
        app.contact().delete(deletedContact);
        app.goTo().homePage();
        Contacts after = app.db().contacts();
        assertEquals(after.size(), before.size() - 1);

        assertThat(after, equalTo(before.withOut(deletedContact)));
    }


}
