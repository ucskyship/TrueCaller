package africa.semicolon.trueCaller.controller;

import africa.semicolon.trueCaller.dtos.request.AddContactRequest;
import africa.semicolon.trueCaller.dtos.request.RegisterRequest;
import africa.semicolon.trueCaller.dtos.responses.AddContactResponse;
import africa.semicolon.trueCaller.dtos.responses.GetAllContactResponse;
import africa.semicolon.trueCaller.dtos.responses.RegisterUserResponse;
import africa.semicolon.trueCaller.exceptions.UserExistsException;
import africa.semicolon.trueCaller.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity <?> registerUser(@RequestBody RegisterRequest registerRequest){
        try {
            RegisterUserResponse serviceResponse = userService.register(registerRequest);
                return new ResponseEntity<>(serviceResponse, HttpStatus.CREATED);
        } catch (UserExistsException err) {
                return new ResponseEntity<>(err.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/user")
    public AddContactResponse addContact(@RequestBody AddContactRequest addContactRequest){
        return userService.addContact(addContactRequest);
    }

    @GetMapping("/user/{email}")
    public List<GetAllContactResponse> findAllContactBelongingTo(@PathVariable String email){
        return userService.findContactThatBelongsTo(email);
    }
}
