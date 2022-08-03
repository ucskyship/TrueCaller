package africa.semicolon.trueCaller.data.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Contact {
    private int id;
    private  String firstName;
    private  String secondName;
    private  String phoneNumber;
    private  String email;
}
