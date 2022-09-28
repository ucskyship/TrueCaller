package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.data.models.User;
import africa.semicolon.trueCaller.data.repositories.UserRepository;
import africa.semicolon.trueCaller.dtos.request.AddContactRequest;
import africa.semicolon.trueCaller.dtos.request.RegisterRequest;
import africa.semicolon.trueCaller.dtos.responses.AddContactResponse;
import africa.semicolon.trueCaller.dtos.responses.GetAllContactResponse;
import africa.semicolon.trueCaller.dtos.responses.RegisterUserResponse;
import africa.semicolon.trueCaller.exceptions.UserExistsException;
import africa.semicolon.trueCaller.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements iUserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private  iContactService contactService;

    public UserService(UserRepository userRepository, iContactService contactService) {
        this.userRepository = userRepository;
        this.contactService = contactService;
    }

    @Override
    public RegisterUserResponse register(RegisterRequest request) {
        //create a new user
        //copy fields from request fields to new user
        //save new user into repository
        validate(request.getEmail());
        User user = new User();
        Mapper.map(request, user);
        userRepository.save(user);

        RegisterUserResponse response = new RegisterUserResponse();
        response.setMessage("registered successful");
        return response;
    }

    private void validate(String email) {
        User savedUser = userRepository.findUserByEmail(email);
        if (savedUser != null) throw new UserExistsException(email + " already exists");
    }

    @Override
    public int getNumberOfUsers() {
        return (int) userRepository.count();
    }

    @Override
    public AddContactResponse addContact(AddContactRequest request) {
        Contact contact = new Contact();
        Mapper.map(request, contact);
        Contact savedContact = contactService.addNewContact(contact);
        User user = userRepository.findUserByEmail(contact.getUserEmail());
        user.getContacts().add(savedContact);
        userRepository.save(user);

        AddContactResponse res = new AddContactResponse();
        res.setMessage(String.format("%s %s has been added successfully", contact.getFirstName(), contact.getSecondName()));
        return res;
    }

    @Override
    public List<GetAllContactResponse> findContactThatBelongsTo(String userEmail) {
        User user = userRepository.findUserByEmail(userEmail);
        List<Contact> allUserContacts = user.getContacts();
        List<GetAllContactResponse> response = new ArrayList<>();
        allUserContacts.forEach(contact -> {
            GetAllContactResponse singleResponse = new GetAllContactResponse();
            Mapper.map(singleResponse, contact);
            response.add(singleResponse);
        });
        return response;
    }
}
