package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.data.models.User;
import africa.semicolon.trueCaller.data.repositories.UserRepository;
import africa.semicolon.trueCaller.dtos.request.AddContactRequest;
import africa.semicolon.trueCaller.dtos.request.RegisterRequest;
import africa.semicolon.trueCaller.dtos.responses.AddContactResponse;
import africa.semicolon.trueCaller.dtos.responses.RegisterUserResponse;
import africa.semicolon.trueCaller.exceptions.UserExistsException;

import java.util.List;

public class UserService implements iUserService {
    private final UserRepository userRepository;
    private final iContactService iContactService;

    public UserService(UserRepository userRepository, ContactService iContactService) {
        this.userRepository = userRepository;
        this.iContactService = iContactService;
    }

    @Override
    public RegisterUserResponse register(RegisterRequest request) {
        //create a new user
        //copy fields from request fields to new user
        //save new user into repository
        validate(request.getEmail());
        User user = new User();
        Mapper.map(request, user);
        userRepository.saveUser(user);
        return null;
    }

    private void validate(String email) {
        User savedUser = userRepository.findByEmail(email);
        if (savedUser != null) throw new UserExistsException(email + " already exists");
    }

    @Override
    public int getNumberOfUsers() {
        return userRepository.count();
    }

    @Override
    public AddContactResponse addContact(AddContactRequest request) {
//         1 -> create a new contact
//        2 -> save the contact  to repository
//        3 -> find the user by email
//        4 -> add contact to user contact lists
//        5 -> save the user
//        step 1
        Contact contact = new Contact();
        contact.setFirstName(request.getFirstName());
        contact.setSecondName(request.getSecondName());
        contact.setPhoneNumber(request.getPhoneNumber());
//       step 2
        Contact savedContact = iContactService.addNewContact(contact);
//        step 3
        User user = userRepository.findByEmail(request.getEmail());
//       step 4
        user.getContacts().add(savedContact);
//        step 5
        userRepository.saveUser(user);
        return null;
    }

    @Override
    public List<Contact> findContactThatBelongsTo(String email) {
        User user = userRepository.findByEmail(email);
        return user.getContacts();
    }
}
