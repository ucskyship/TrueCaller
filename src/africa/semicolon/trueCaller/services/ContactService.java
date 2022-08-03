package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.data.repositories.ContactRepository;

public class ContactService implements iContactService {

    private ContactRepository contactRepository;
    public Contact addNewContact(Contact contact) {
        return new Contact();
    }
//          assignments
//    write a test that saves contact to repository
}
