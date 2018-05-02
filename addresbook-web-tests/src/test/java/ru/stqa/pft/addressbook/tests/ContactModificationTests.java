package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;


import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

    @Test (enabled = true)
    public void testContactModification() {
        app.goTo().gotoHome();
        if (! app.getContactHelper().isThereAContact()) {
            app.goTo().gotoAddNew();
            app.getContactHelper().createContact(
                    new ContactData("Sasha", "Pushkin", "333", "SP@mail.ru", "[none]"));
            app.goTo().gotoHome();
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size() - 1);
        app.getContactHelper().initContactModification(before.size() - 1);
        ContactData contact = new ContactData(before.get(before.size() - 1).getId(),"John", "Sylver", "555", "JS@mail.ru", null);
        app.getContactHelper().modifyContact(contact);
        app.goTo().gotoHome();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(after, before);
    }

}
