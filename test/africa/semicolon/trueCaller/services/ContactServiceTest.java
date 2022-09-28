package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.data.repositories.ContactRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ContactServiceTest {

    @Autowired
    ContactRepository contactRepository;
    @Test
    void addNewContact() {
        Contact contact = new Contact();

        contact.setPhoneNumber("08133856783");
        contact.setFirstName("pointless firstName");
        contact.setSecondName("pointless secondName");
        contact.setUserEmail("test@test.com");
    }
}