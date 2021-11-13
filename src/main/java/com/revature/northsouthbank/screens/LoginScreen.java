package com.revature.northsouthbank.screens;

import com.revature.northsouthbank.exceptions.AuthenticationException;
import com.revature.northsouthbank.exceptions.InvalidRequestException;
import com.revature.northsouthbank.services.UserService;
import com.revature.northsouthbank.util.ScreenRouter;

import java.io.BufferedReader;

public class LoginScreen extends Screen{

    private final UserService userService;

    public LoginScreen(BufferedReader consoleReader, ScreenRouter router, UserService userService) {
        super("LoginScreen", "/login", consoleReader, router);
        this.userService = userService;
    }

    @Override
    public void render() throws Exception {

        System.out.println("\nPlease provide your username and password to log into your account.");
        System.out.print("Username > ");
        String username = consoleReader.readLine();
        System.out.print("Password > ");
        String password = consoleReader.readLine();

        try {
            userService.authenticateUser(username, password);
            router.navigate("/dashboard");
        } catch (InvalidRequestException | AuthenticationException e) {
            System.out.println(e.getMessage());
        }
    }
}
