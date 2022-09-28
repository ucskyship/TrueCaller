package africa.semicolon.trueCaller.dtos.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddContactRequest {
    private String firstName;
    private String secondName;
    private String phoneNumber;

    private String userEmail;
}
