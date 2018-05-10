package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;


import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        app.goTo().homePage();
        if (app.contact().all().size() == 0) {
            app.goTo().addNewPage();
            app.contact().create(
                    new ContactData().withFirstName("Sasha").withLastName("Pushkin")
                            .withPhoneHome("333").withPhoneWork("+7(812)55-55").withEMail("SP@mail.ru").withGroup("[none]"));
            app.goTo().homePage();
        }
    }

    @Test
    public void testContactPhones() {
        app.goTo().homePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
        assertThat(contact.getAllEMails(), equalTo(mergeEMails(contactInfoFromEditForm)));
        assertThat(contact.getAddress(), equalTo(contactInfoFromEditForm.getAddress()));
    }

    private String mergeEMails(ContactData contact) {
        return Arrays.asList(contact.getEMail(), contact.getEMail2(), contact.getEMail3())
                .stream().filter((s) -> ! s.equals(""))
                .map(ContactPhoneTests::cleanedEMail)
                .collect(Collectors.joining("\n"));
    }

    private String mergePhones(ContactData contact) {
        return Arrays.asList(contact.getPhoneHome(), contact.getPhoneMobile(), contact.getPhoneWork())
                .stream().filter((s) -> ! s.equals(""))
                .map(ContactPhoneTests::cleanedPhone)
                .collect(Collectors.joining("\n"));

    }

    public static String cleanedPhone (String phone) {
        return phone.replaceAll("\\s","").replaceAll("00", "+").replaceAll("[-()]", "");
    }

    public static String cleanedEMail (String eMail) {
        return eMail.replaceAll("\\s+"," ");
    }



}
