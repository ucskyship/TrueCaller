package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.data.repositories.ContactRepository;
import africa.semicolon.trueCaller.data.repositories.ContactRepositoryImpl;
import org.junit.jupiter.api.Test;

class ContactServiceTest {
    @Test
    void addNewContact() {
        ContactRepository contactRepository = new ContactRepositoryImpl();
        Contact contact = new Contact();

        contact.setPhoneNumber("08133856783");
        contact.setFirstName("pointless firstName");
        contact.setSecondName("pointless secondName");
        contact.setEmail("test@test.com");
    }
}