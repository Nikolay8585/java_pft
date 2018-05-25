package ru.stqa.pft.addressbook.model;


import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "address_in_groups")
@XStreamAlias("contactsInGroup")
public class ContactInGroupData implements Serializable {

    @Id
    @Column(name = "id")
    private int contactId = 0;

    @Id
    @Column(name = "group_id")
    private int groupId = 0;


    public int getContactId() {
        return contactId;
    }

    public int getGroupId() {
        return groupId;
    }

    public ContactInGroupData withContactId(int id) {
        this.contactId = id;
        return this;
    }

    public ContactInGroupData withGroupId(int id) {
        this.groupId = id;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactInGroupData that = (ContactInGroupData) o;
        return contactId == that.contactId &&
                groupId == that.groupId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(contactId, groupId);
    }

    @Override
    public String toString() {
        return "ContactInGroupData{" +
                "contactId=" + contactId +
                ", groupId=" + groupId +
                '}';
    }
}
