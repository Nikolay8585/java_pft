package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;


import java.util.List;

public class ContactDeletionTests extends TestBase {

    @Test (enabled = false)
    public void testContactDeletion() {
        app.goTo().gotoHome();
        if (! app.getContactHelper().isThereAContact()) {
            app.goTo().gotoAddNew();
            app.getContactHelper().createContact(
                    new ContactData("John", "Sylver", "333", "JS@mail.ru", "[none]"));
            app.goTo().gotoHome();
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size() - 1);
        app.getContactHelper().initContactDeletion();
        app.getContactHelper().allertConfirm();
        app.goTo().gotoHome();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);
    }

}
