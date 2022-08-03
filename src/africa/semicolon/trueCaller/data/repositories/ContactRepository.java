package africa.semicolon.trueCaller.data.repositoriess;

import africa.semicolon.trueCaller.data.models.Contact;

import java.util.List;

public interface ContactRepository {
    Contact saveContact(Contact contact);
    void delete(Contact contact);
    void delete(int id);
    Contact findById(int id);
//    List<Contact> findByFirstName(String firstName);
//    List<Contact> findByLastName(String lastName);
    List<Contact> findAll();
    int count();
    Contact searchContact(String name);
}
