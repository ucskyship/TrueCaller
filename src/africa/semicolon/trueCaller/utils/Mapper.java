package africa.semicolon.trueCaller.utils;

import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.data.models.User;
import africa.semicolon.trueCaller.dtos.request.RegisterRequest;
import africa.semicolon.trueCaller.dtos.responses.AllContactResponse;

public class Mapper {

    public static void map(RegisterRequest request, User userRepository) {
        userRepository.setFirstName(request.getFirstName());
        userRepository.setLastName(request.getLastName());
        userRepository.setEmail(request.getEmail());
        userRepository.setUsername(request.getUsername());
        userRepository.setPassword(request.getPassword());
        userRepository.setPhoneNumber(request.getPhoneNumber());
    }

    public  static void map(AllContactResponse singleResponse, Contact contact){
        singleResponse.setId(contact.getId() + "");
        singleResponse.setFirstName(contact.getFirstName());
        singleResponse.setLastName(contact.getSecondName());
    }
}
