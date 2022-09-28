package africa.semicolon.trueCaller.utils;

import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.data.models.User;
import africa.semicolon.trueCaller.dtos.request.AddContactRequest;
import africa.semicolon.trueCaller.dtos.request.RegisterRequest;
import africa.semicolon.trueCaller.dtos.responses.GetAllContactResponse;

public class Mapper {

    public static void map(RegisterRequest request, User user) {
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setPhoneNumber(request.getPhoneNumber());
    }

    public  static void map(GetAllContactResponse singleResponse, Contact contact){
        singleResponse.setId(contact.getId() + "");
        singleResponse.setFirstName(contact.getFirstName());
        singleResponse.setLastName(contact.getSecondName());
    }

    public static void map(AddContactRequest request, Contact contact){
        contact.setFirstName(request.getFirstName());
        contact.setSecondName(request.getSecondName());
        contact.setPhoneNumber(request.getPhoneNumber());
        contact.setUserEmail(request.getUserEmail());
    }
}
