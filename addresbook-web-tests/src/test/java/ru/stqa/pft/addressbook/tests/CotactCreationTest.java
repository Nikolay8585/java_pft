package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import ru.stqa.pft.addressbook.model.ContactData;

public class CotactCreationTest extends TestBase {

    @Test
    public void testContactCreation() {

        app.getNavigationHelper().gotoAddNew();
        app.getContactHelper().fillContactForm(new ContactData("John", "Sylver", "333", "JS@mail.ru"));
        app.getContactHelper().submitContactCreation();
        app.getNavigationHelper().gotoHome();
    }

}
