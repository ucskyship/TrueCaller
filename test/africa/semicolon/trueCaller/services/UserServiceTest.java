package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.repositories.UserRepository;
import africa.semicolon.trueCaller.dtos.request.AddContactRequest;
import africa.semicolon.trueCaller.dtos.request.RegisterRequest;
import africa.semicolon.trueCaller.exceptions.UserExistsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class  UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ContactService iContactService;


    @Test
    public void registerTest() {
        //given
        //there is a request form
        RegisterRequest request = new RegisterRequest();
        request.setEmail("ucj@ucj.go");
        request.setFirstName("juc");
        request.setLastName("jjc");
        request.setPassword("iLoveJesus222");
        //when
        userService.register(request);
        //I try to register,

        //asser that
        //repository has register one user (size is 1)
        assertEquals(1, userService.getNumberOfUsers());
    }

    @Test
    public void duplicateEmailThrowsExceptionIfAlreadyRegistered() {
        //given
        //there is a request form
        RegisterRequest request = new RegisterRequest();
        request.setEmail("ucj@ucj.go");
        request.setFirstName("juc");
        request.setLastName("jjc");
        request.setPassword("iLoveJesus222");
        userService.register(request);

        RegisterRequest request2 = new RegisterRequest();
        request2.setEmail("ucj@ucj.go");
        request2.setFirstName("First name");
        request2.setLastName("Last name");
        request2.setPassword("iLoveJesus222");
        userService.register(request2);

        assertThrows(UserExistsException.class, () -> userService.register(request2));
        assertEquals(1, userService.getNumberOfUsers());
    }

    @Test
    public void testThatContactCanBeAddedToUser(){
//        given that I have a user
//        when I add a contact
//        check that contacts size has increased

        RegisterRequest request = new RegisterRequest();
        request.setEmail("ucj@ucj.go");
        request.setFirstName("juc");
        request.setLastName("jjc");
        request.setPassword("iLoveJesus222");
        userService.register(request);

        AddContactRequest addContactRequest = new AddContactRequest();
        addContactRequest.setEmail("ucj@ucj.go");
        addContactRequest.setPhoneNumber("123456789");
        addContactRequest.setFirstName("UcJ");
        addContactRequest.setSecondName("jJc");
        addContactRequest.setUserEmail("ucj@ucj.go");
        userService.addContact(addContactRequest);

        assertEquals(1, userService.findContactThatBelongsTo("ucj@ucj.go").size());
    }
}