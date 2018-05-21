package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.List;


public class ContactHelper extends HelperBase {
    public ContactHelper(WebDriver wd) {
        super(wd);
    }
    public void fillContactForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("lastname"), contactData.getLastName());
        attach(By.name("photo"), contactData.getPhoto());
        type(By.name("address"), contactData.getAddress());
        type(By.name("home"), contactData.getPhoneHome());
        type(By.name("mobile"), contactData.getPhoneMobile());
        type(By.name("work"), contactData.getPhoneWork());
        type(By.name("email"), contactData.getEMail());
        type(By.name("email2"), contactData.getEMail2());
        type(By.name("email3"), contactData.getEMail3());


        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void submitContactCreation() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void selectContactById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public void initContactModification(int id) {
        wd.findElement(By.xpath("//input[@value='" + id + "']/../..//td[8]/a/img")).click();
    }

    public void submitContactModification() {
        click(By.name("update"));
    }

    public void initContactDeletion() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }

    public void create(ContactData contact) {
        fillContactForm(contact, true);
        submitContactCreation();
    }

    public boolean isThereAContact() {
            return isElementPresent(By.name("selected[]"));
    }

    public void modify(ContactData contact) {
        selectContactById(contact.getId());
        initContactModification(contact.getId());
        fillContactForm(contact, false);
        submitContactModification();
    }

    public void delete(ContactData contact) {
        selectContactById(contact.getId());
        initContactDeletion();
        allertConfirm();
    }

    public Contacts all() {
        Contacts contacts = new Contacts();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements) {
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            String lastName = element.findElements(By.tagName("td")).get(1).getText();
            String firstName = element.findElements(By.tagName("td")).get(2).getText();
            String address = element.findElements(By.tagName("td")).get(3).getText();
            String allEMails = element.findElements(By.tagName("td")).get(4).getText();
            String allPhones = element.findElements(By.tagName("td")).get(5).getText();
            contacts.add(new ContactData().withId(id).withFirstName(firstName).withLastName(lastName).withAddress(address)
            .withallEMails(allEMails).withAllPhones(allPhones));
        }
        return contacts;
    }

    public ContactData infoFromEditForm(ContactData contact) {
        initContactModification(contact.getId());
        String firstName = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastName = wd.findElement(By.name("lastname")).getAttribute("value");
        String address = wd.findElement(By.name("address")).getAttribute("value");
        String eMail = wd.findElement(By.name("email")).getAttribute("value");
        String eMail2 = wd.findElement(By.name("email2")).getAttribute("value");
        String eMail3 = wd.findElement(By.name("email3")).getAttribute("value");
        String phoneHome = wd.findElement(By.name("home")).getAttribute("value");
        String phoneMobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String phoneWork = wd.findElement(By.name("work")).getAttribute("value");
        return new ContactData().withId(contact.getId()).withFirstName(firstName).withLastName(lastName)
                .withAddress(address).withEMail(eMail).withEMail2(eMail2).withEMail3(eMail3)
                .withPhoneHome(phoneHome).withPhoneMobile(phoneMobile).withPhoneWork(phoneWork);

    }
}
