package ru.stqa.pft.addressbook.model;

public class ContactData {
    private final String firstName;
    private final String lastName;
    private final String phoneHome;
    private final String eMail;
    private final String group;

    public ContactData(String firstName, String lastName, String phoneHome, String eMail, String group) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneHome = phoneHome;
        this.eMail = eMail;
        this.group = group;
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

    public String getEMail() { return eMail;}

    public String getGroup() {
        return group;
    }
}
