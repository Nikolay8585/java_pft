package ru.stqa.pft.addressbook;

public class ContactData {
    private final String firstname;
    private final String lastname;
    private final String phoneHome;

    public ContactData(String firstname, String lastname, String phoneHome) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phoneHome = phoneHome;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPhoneHome() {
        return phoneHome;
    }
}
