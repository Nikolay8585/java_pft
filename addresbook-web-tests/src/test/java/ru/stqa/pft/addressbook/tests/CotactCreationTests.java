package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class CotactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.getNavigationHelper().gotoAddNew();
        app.getContactHelper().fillContactForm(
                new ContactData("John", "Sylver", "333", "JS@mail.ru", "test1"),
                true);
        app.getContactHelper().submitContactCreation();
        app.getNavigationHelper().gotoHome();
    }

}
