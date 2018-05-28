package ru.stqa.pft.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class ContactsInGroups extends ForwardingSet<ContactInGroupData> {

    private Set<ContactInGroupData> delegate;

    public ContactsInGroups(ContactsInGroups contactsInGroups) {
        this.delegate = new HashSet<ContactInGroupData>(contactsInGroups.delegate);
    }

    public ContactsInGroups() {
        this.delegate = new HashSet<ContactInGroupData>();
    }

    public ContactsInGroups(Collection<ContactInGroupData> contactsInGroups) {
        this.delegate = new HashSet<ContactInGroupData>(contactsInGroups);
    }

    @Override
    protected Set<ContactInGroupData> delegate() {
        return delegate;
    }

}
