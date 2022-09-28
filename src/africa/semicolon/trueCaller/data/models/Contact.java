package africa.semicolon.trueCaller.data.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@NoArgsConstructor
@Document("Contacts")
public class Contact {

    @Id
    private String id;
    private  String firstName;
    private  String secondName;
    private  String phoneNumber;
    private  String userEmail;
}
