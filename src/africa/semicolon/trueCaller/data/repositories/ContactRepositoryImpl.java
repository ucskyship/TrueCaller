package africa.semicolon.trueCaller.data.repositories;

import africa.semicolon.trueCaller.data.models.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactRepositoryImpl implements ContactRepository {
    private int counter;
    private final List<Contact> contacts = new ArrayList<>();

    @Override
    public Contact saveContact(Contact contact) {
        Contact foundContact = findById(contact.getId());
        if (foundContact != null) {
            foundContact.setPhoneNumber(contact.getPhoneNumber());
            foundContact.setSecondName(contact.getSecondName());
            foundContact.setPhoneNumber(contact.getPhoneNumber());
            foundContact.setEmail(contact.getEmail());
        } else {
            counter++;
            contact.setId(counter);
            contacts.add(contact);
        }
        return contact;
    }

    @Override
    public void delete(Contact contact) {
        contacts.remove(contact);
        counter--;
    }

    @Override
    public void delete(int id) {
        Contact foundContact = findById(id);
        contacts.remove(foundContact);
    }

    @Override
    public Contact findById(int id) {
        for (var contact : contacts) {
            if (contact.getId() == id) {
                return contact;
            }
        }
        return null;
    }

    @Override
    public List<Contact> findAll() {
        return contacts;
    }

    @Override
    public int count() {
        return contacts.size();
    }

    @Override
    public Contact searchContact(String name) {
        Contact thisContact = null;
        for (Contact contact : contacts) {
            if (contact.getSecondName().equalsIgnoreCase(name)) {
                thisContact = contact;
            }
        }
        return thisContact;
    }
}
