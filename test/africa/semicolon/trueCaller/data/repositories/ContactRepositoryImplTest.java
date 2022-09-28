//package africa.semicolon.trueCaller.data.repositories;
//
//import africa.semicolon.trueCaller.data.models.Contact;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNull;
//
//public class ContactRepositoryImplTest {
//
//
//    @Test
//    public void saveTest(){
//        ContactRepository contactRepository = new ContactRepositoryImpl();
//        Contact contact = new Contact();
//        contact.setPhoneNumber("08133856783");
//        contact.setFirstName("Ojo");
//        contact.setSecondName("oJo");
//        contact.setUserEmail("ojo@gmail.com");
//
//       contactRepository.save(contact);
//       assertEquals(1, contactRepository.count());
//    }
//
//    @Test
//    public void saveTest_findById(){
//        ContactRepository contactRepository = new ContactRepositoryImpl();
//        Contact contact = new Contact();
//        contact.setPhoneNumber("08133856783");
//        contact.setFirstName("Ojo");
//        contact.setSecondName("oJo");
//        contact.setUserEmail("ojo@gmail.com");
//
//       contactRepository.save(contact);
//       assertEquals(1, contactRepository.count());
//       Contact savedContact = contactRepository.findById(1);
//       assertEquals("Ojo", savedContact.getFirstName());
//    }
//
//    @Test
//    @DisplayName("Given that i have a saved contact and i want to delete it from contactRepository by contact id")
//    public void delete_byIdTest(){
//        ContactRepository contactRepository = new ContactRepositoryImpl();
//        Contact contact = new Contact();
//        contact.setPhoneNumber("08133856783");
//        contact.setFirstName("Ojo");
//        contact.setSecondName("oJo");
//        contact.setUserEmail("ojo@gmail.com");
//
//        contactRepository.save(contact);
//        assertEquals(1, contactRepository.count());
//        Contact savedContact = contactRepository.findById(1);
//        assertEquals("Ojo", savedContact.getFirstName());
//
//        contactRepository.deleteById(1);
//        assertEquals(0, contactRepository.count());
//    }
//
//    @Test
//    @DisplayName("Given that i have a saved contact and i want to delete it from contactRepository")
//    public void delete_byContactTest(){
//        ContactRepository contactRepository = new ContactRepositoryImpl();
//        Contact contact = new Contact();
//        contact.setPhoneNumber("08133856783");
//        contact.setFirstName("Ojo");
//        contact.setSecondName("oJo");
//        contact.setUserEmail("ojo@gmail.com");
//
//        contactRepository.save(contact);
//        assertEquals(1, contactRepository.count());
//        Contact savedContact = contactRepository.findById(1);
//        assertEquals("Ojo", savedContact.getFirstName());
//
//        contactRepository.delete(contact);
//        assertEquals(0, contactRepository.count());
//
//        savedContact = contactRepository.findById(1);
//        assertNull(savedContact);
//    }
//
//    @Test
//    public void updateTest_ifContactAlreadyExistsUpdateDetails(){
//        ContactRepository contactRepository = new ContactRepositoryImpl();
//        Contact contact = new Contact();
//        contact.setPhoneNumber("08133856783");
//        contact.setFirstName("Ojo");
//        contact.setSecondName("oJo");
//        contact.setUserEmail("ojo@gmail.com");
//        contactRepository.save(contact);
//        Contact savedContact = contactRepository.findById(1);
//        assertEquals("Ojo", savedContact.getFirstName());
//
//        contact.setPhoneNumber("08133856783");
//        contact.setFirstName("John");
//        contact.setSecondName("oJo");
//        contact.setUserEmail("ojo@gmail.com");
//
//        contactRepository.save(contact);
//        assertEquals(1, contactRepository.count());
//        savedContact = contactRepository.findById(1);
//        assertEquals("John", savedContact.getFirstName());
//    }
//
//    @Test
//    public void returnAllContactTest(){
//        ContactRepository contactRepository = new ContactRepositoryImpl();
//        Contact contact = new Contact();
//        contact.setPhoneNumber("08133856783");
//        contact.setFirstName("Ojo");
//        contact.setSecondName("oJo");
//        contact.setUserEmail("ojo@gmail.com");
//        contactRepository.save(contact);
//        Contact savedContact = contactRepository.findById(1);
//        assertEquals("Ojo", savedContact.getFirstName());
//
//        Contact contact1 = new Contact();
//        contact1.setPhoneNumber("08133856783");
//        contact1.setFirstName("James");
//        contact1.setSecondName("Ana");
//        contact1.setUserEmail("analjames@gmail.com");
//        contactRepository.save(contact1);
//        savedContact = contactRepository.findById(2);
//        assertEquals("James", savedContact.getFirstName());
//
//        Contact contact2 = new Contact();
//        contact2.setPhoneNumber("08133856783");
//        contact2.setFirstName("Mercy");
//        contact2.setSecondName("Merit");
//        contact2.setUserEmail("meirtt@gmail.com");
//        contactRepository.save(contact2);
//        savedContact = contactRepository.findById(3);
//        assertEquals("Mercy", savedContact.getFirstName());
//        assertEquals(3, contactRepository.count());
//
//        assertEquals(3, contactRepository.findAll().size());
//    }
//
//    @Test
//    public void searchContactTest(){
//        ContactRepository contactRepository = new ContactRepositoryImpl();
//        Contact contact = new Contact();
//        contact.setPhoneNumber("08133856783");
//        contact.setFirstName("Ojo");
//        contact.setSecondName("oJo");
//        contact.setUserEmail("ojo@gmail.com");
//        contactRepository.save(contact);
//        Contact savedContact = contactRepository.findById(1);
//        assertEquals("Ojo", savedContact.getFirstName());
//
//        Contact contact1 = new Contact();
//        contact1.setPhoneNumber("08133856783");
//        contact1.setFirstName("James");
//        contact1.setSecondName("Ana");
//        contact1.setUserEmail("analjames@gmail.com");
//        contactRepository.save(contact1);
//        savedContact = contactRepository.findById(2);
//        assertEquals("James", savedContact.getFirstName());
//
//        Contact contact2 = new Contact();
//        contact2.setPhoneNumber("08133856783");
//        contact2.setFirstName("Mercy");
//        contact2.setSecondName("Merit");
//        contact2.setUserEmail("meirtt@gmail.com");
//        contactRepository.save(contact2);
//        savedContact = contactRepository.findById(3);
//        assertEquals("Mercy", savedContact.getFirstName());
//        assertEquals(3, contactRepository.count());
//
//        assertEquals(3, contactRepository.findAll().size());
//
//        Contact foundContact = contactRepository.searchContact("Merit");
//        assertEquals("Merit", foundContact.getSecondName());
//
////        var foundContact = contactRepository.findByFirstName("Mercy");
////        assertEquals("Mercy", foundContact.getFirstName());
//    }
//}