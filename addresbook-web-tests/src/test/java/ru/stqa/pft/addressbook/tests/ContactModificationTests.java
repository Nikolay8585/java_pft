package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        app.getNavigationHelper().gotoHome();
        app.getContactHelper().selectContact();
        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactForm(new ContactData("John", "Sylver", "333", "JS@mail.ru"));
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().gotoHome();
    }

}
