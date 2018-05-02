package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;


import java.util.Comparator;
import java.util.List;

public class CotactCreationTests extends TestBase {

    @Test (enabled = true)
    public void testContactCreation() {
        app.goTo().gotoHome();
        List<ContactData> before = app.getContactHelper().getContactList();
        app.goTo().gotoAddNew();
        ContactData contact = new ContactData("Sasha", "Pushkin", "333", "JS@mail.ru", "[none]");
        app.getContactHelper().createContact(contact);
        app.goTo().gotoHome();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);

        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(after, before);

    }

}
