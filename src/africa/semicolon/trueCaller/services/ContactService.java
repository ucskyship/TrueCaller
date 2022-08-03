package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.data.repositories.ContactRepository;
import africa.semicolon.trueCaller.data.repositories.ContactRepositoryImpl;

import java.util.List;

public class ContactService implements iContactService {

    private final ContactRepository contactRepository;

    public ContactService(){
        contactRepository = new ContactRepositoryImpl();
    }
    public Contact addNewContact(Contact contact) {
        return new Contact();
    }

    public List<Contact> getAllContacts(){
        return contactRepository.findAll();
    }
}
