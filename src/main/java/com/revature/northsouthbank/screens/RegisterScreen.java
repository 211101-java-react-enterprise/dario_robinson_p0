package com.revature.northsouthbank.screens;

import com.revature.northsouthbank.exceptions.InvalidRequestException;
import com.revature.northsouthbank.exceptions.ResourcePersistenceException;
import com.revature.northsouthbank.models.AppUser;
import com.revature.northsouthbank.services.UserService;
import com.revature.northsouthbank.util.ScreenRouter;

import java.io.BufferedReader;

public class RegisterScreen extends Screen {

    private final UserService userService;

    public RegisterScreen(BufferedReader consoleReader, ScreenRouter router, UserService userService) {
        super("RegisterScreen", "/register", consoleReader, router);
        this.userService = userService;
    }

    @Override
    public void render() throws Exception {
        System.out.println("You have selected Register.");
        System.out.println("Please provide us with some basic information.");
        System.out.println("First name: ");
        String firstName = consoleReader.readLine();

        System.out.println("Last name: ");
        String lastName = consoleReader.readLine();

        System.out.println("Email: ");
        String email = consoleReader.readLine();

        System.out.println("Username: ");
        String username = consoleReader.readLine();

        System.out.println("Password: ");
        String password = consoleReader.readLine();

        System.out.printf("Provided user first and last name: {\"firstName\": %s, \"lastName\": %s}\n", firstName, lastName);

        AppUser newUser = new AppUser(firstName, lastName, email, username, password);

        try {
            userService.registerNewUser(newUser);
            System.out.println("Registration successful!");
            router.navigate("/login");
        } catch (InvalidRequestException | ResourcePersistenceException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
