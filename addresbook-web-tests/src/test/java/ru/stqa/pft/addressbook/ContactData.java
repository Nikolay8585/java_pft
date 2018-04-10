package ru.stqa.pft.addressbook;

public class ContactData {
    private final String firstName;
    private final String lastName;
    private final String phoneHome;

    public ContactData(String firstName, String lastName, String phoneHome) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneHome = phoneHome;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneHome() {
        return phoneHome;
    }
}
