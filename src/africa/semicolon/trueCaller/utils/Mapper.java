package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.models.User;
import africa.semicolon.trueCaller.dtos.request.RegisterRequest;

public class Mapper {

    public static void map(RegisterRequest request, User userRepository) {
        userRepository.setFirstName(request.getFirstName());
        userRepository.setLastName(request.getLastName());
        userRepository.setEmail(request.getEmail());
        userRepository.setUsername(request.getUsername());
        userRepository.setPassword(request.getPassword());
        userRepository.setPhoneNumber(request.getPhoneNumber());
    }
}
