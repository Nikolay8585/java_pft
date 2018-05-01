package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
    private int id;
    private final String firstName;
    private final String lastName;
    private final String phoneHome;
    private final String eMail;
    private String group;

    public ContactData(int id, String firstName, String lastName, String phoneHome, String eMail, String group) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneHome = phoneHome;
        this.eMail = eMail;
        this.group = group;
    }

    public ContactData(String firstName, String lastName, String phoneHome, String eMail, String group) {
        this.id = Integer.MAX_VALUE;
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

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
