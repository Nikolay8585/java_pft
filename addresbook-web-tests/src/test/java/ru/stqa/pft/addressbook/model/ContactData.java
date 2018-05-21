package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.Objects;

@Entity
@Table(name = "addressbook")
@XStreamAlias("contact")
public class ContactData {
    @XStreamOmitField
    @Id
    @Column(name = "id")
    private int id = Integer.MAX_VALUE;

    @Expose
    @Column(name = "firstname")
    private String firstName;

    @Expose
    @Column(name = "lastname")
    private String lastName;

    @Expose
    @Column(name = "address")
    @Type(type = "text")
    private String address;

    @Expose
    @Column(name = "email")
    @Type(type = "text")
    private String eMail;

    @Expose
    @Column(name = "email2")
    @Type(type = "text")
    private String eMail2;

    @Expose
    @Column(name = "email3")
    @Type(type = "text")
    private String eMail3;

    @Expose
    @Transient
    private String allEMails;

    @Expose
    @Transient
    private String group;

    @Expose
    @Column(name = "home")
    @Type(type = "text")
    private String phoneHome;

    @Expose
    @Column(name = "mobile")
    @Type(type = "text")
    private String phoneMobile;

    @Expose
    @Column(name = "work")
    @Type(type = "text")
    private String phoneWork;

    @Transient
    private String allPhones;

    @Column(name = "photo")
    @Type(type = "text")
    private String photo;


    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public ContactData withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ContactData withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }

    public ContactData withPhoneHome(String phoneHome) {
        this.phoneHome = phoneHome;
        return this;
    }

    public ContactData withPhoneMobile(String phoneMobile) {
        this.phoneMobile = phoneMobile;
        return this;
    }

    public ContactData withPhoneWork(String phoneWork) {
        this.phoneWork = phoneWork;
        return this;
    }

    public ContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public ContactData withEMail(String eMail) {
        this.eMail = eMail;
        return this;
    }

    public ContactData withEMail2(String eMail2) {
        this.eMail2 = eMail2;
        return this;
    }

    public ContactData withEMail3(String eMail3) {
        this.eMail3 = eMail3;
        return this;
    }

    public ContactData withallEMails(String allEMails) {
        this.allEMails = allEMails;
        return this;
    }


    public ContactData withGroup(String group) {
        this.group = group;
        return this;
    }

    public ContactData withPhoto(File photo) {
        this.photo = photo.getPath();
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneHome() {
        return phoneHome;
    }

    public String getPhoneMobile() {
        return phoneMobile;
    }

    public String getAllPhones() {
        return allPhones;
    }

    public String getPhoneWork() {
        return phoneWork;
    }

    public String getEMail() { return eMail;}

    public String getEMail2() { return eMail2;}

    public String getEMail3() { return eMail3;}

    public String getAllEMails() { return allEMails;}

    public String getGroup() {
        return group;
    }

    public int getId() {
        return id;
    }

    public File getPhoto() {
        return new File(photo);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return id == that.id &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, firstName, lastName);
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", eMail='" + eMail + '\'' +
                ", eMail2='" + eMail2 + '\'' +
                ", eMail3='" + eMail3 + '\'' +
                ", allEMails='" + allEMails + '\'' +
                ", phoneHome='" + phoneHome + '\'' +
                ", phoneMobile='" + phoneMobile + '\'' +
                ", phoneWork='" + phoneWork + '\'' +
                ", allPhones='" + allPhones + '\'' +
                '}';
    }

}
