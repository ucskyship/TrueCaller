package africa.semicolon.trueCaller.data.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class User {

    private int id;
    private  String firstName;
    private  String lastName;
    private String phoneNumber;
    private String username;
    private String password;
    private String email;
    private List<Contact> contacts = new ArrayList<>();
}
