package africa.semicolon.trueCaller.controller;

import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.data.repositories.UserRepositoryImpl;
import africa.semicolon.trueCaller.dtos.request.AddContactRequest;
import africa.semicolon.trueCaller.dtos.request.RegisterRequest;
import africa.semicolon.trueCaller.dtos.responses.AddContactResponse;
import africa.semicolon.trueCaller.dtos.responses.RegisterUserResponse;
import africa.semicolon.trueCaller.services.ContactService;
import africa.semicolon.trueCaller.services.UserService;

import java.util.List;

public class UserController {
    private final UserService userService = new UserService(new UserRepositoryImpl(), new ContactService());

    public RegisterUserResponse registerUser(RegisterRequest registerRequest){
        return userService.register(registerRequest);
    }

    public AddContactResponse addContact(AddContactRequest addContactRequest){
        return userService.addContact(addContactRequest);
    }

    public List<Contact> findAllContactBelongingTo(String email){
        return userService.findContactThatBelongsTo(email);
    }
}
