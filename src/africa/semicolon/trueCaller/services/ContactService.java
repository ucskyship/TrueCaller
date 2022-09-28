package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.data.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService implements iContactService {

    @Autowired
    private ContactRepository contactRepository;

    public Contact addNewContact(Contact contact) {
        contactRepository.save(contact);
        return new Contact();
    }

    public List<Contact> getAllContacts(){
        return contactRepository.findAll();
    }
}
