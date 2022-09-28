package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.dtos.request.AddContactRequest;
import africa.semicolon.trueCaller.dtos.request.RegisterRequest;
import africa.semicolon.trueCaller.dtos.responses.AddContactResponse;
import africa.semicolon.trueCaller.dtos.responses.GetAllContactResponse;
import africa.semicolon.trueCaller.dtos.responses.RegisterUserResponse;

import java.util.List;

public interface iUserService {

    RegisterUserResponse register(RegisterRequest request);

    int getNumberOfUsers();

    AddContactResponse addContact(AddContactRequest request);

    List<GetAllContactResponse> findContactThatBelongsTo(String email);
}

