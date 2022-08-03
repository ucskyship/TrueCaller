package africa.semicolon.trueCaller;

import africa.semicolon.trueCaller.controller.UserController;
import africa.semicolon.trueCaller.dtos.request.AddContactRequest;
import africa.semicolon.trueCaller.dtos.request.RegisterRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;


@SpringBootApplication
public class Main {
    private static final Scanner keypadInput = new Scanner(System.in);
    private static final UserController userController = new UserController();
    public static void main(String[] args) {

        SpringApplication.run(Main.class, args);

        displayMainMenu();
    }

    private static void displayMainMenu() {
        // prompt user with menu
        //if user selects a, b, c direct them
        String mainMenuPrompt =  """
                Welcome To TrueCaller
                1 -> Create an Account
                2 -> Add contact to user
                3 -> Find contact belonging to user
                """;
        String userInput = input(mainMenuPrompt);
        switch (userInput.charAt(0)) {
            case '1' -> createAccount();
            case '2' -> addContactToUser();
            case '3' -> findAllContactBelongingTo();
        }
    }

    private static void findAllContactBelongingTo() {
        var contacts = userController.findAllContactBelongingTo(input("Enter your email"));
        for (var contact : contacts) {
            display(contact.toString());
        }
    }

    private static void addContactToUser() {
        AddContactRequest contactRequest = new AddContactRequest();
        contactRequest.setFirstName(input("Enter contact's First name"));
        contactRequest.setSecondName(input("Enter contact's second name"));
        contactRequest.setPhoneNumber(input("Enter contact's phone number"));
        contactRequest.setEmail(input("Enter contact email"));
        contactRequest.setUserEmail(input("Enter user email"));

        userController.addContact(contactRequest);
        displayMainMenu();
    }

    private static void createAccount() {
        RegisterRequest request = new RegisterRequest();
        request.setFirstName(input("Enter First name"));
        request.setLastName(input("Enter second name"));
        request.setPhoneNumber(input("Enter phone number"));
        request.setEmail(input("Enter email"));
        request.setPassword(input("Enter password"));
        
        userController.registerUser(request);
        display("done");
        displayMainMenu();
    }

    private static void display(String message) {
        System.out.println(message);
    }

    public static String input(String prompt) {
        System.out.println(prompt);
        return keypadInput.nextLine();
    }
}
