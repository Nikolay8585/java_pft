package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        app.getNavigationHelper().gotoHome();
        if (! app.getContactHelper().isThereAContact()) {
            app.getNavigationHelper().gotoAddNew();
            app.getContactHelper().createContact(
                    new ContactData("John", "Sylver", "333", "JS@mail.ru", "test1"));
            app.getNavigationHelper().gotoHome();
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().initContactModification();
        app.getContactHelper().modifyContact(
                new ContactData("John", "Sylver", "555", "JS@mail.ru", null));
        app.getNavigationHelper().gotoHome();
    }

}
