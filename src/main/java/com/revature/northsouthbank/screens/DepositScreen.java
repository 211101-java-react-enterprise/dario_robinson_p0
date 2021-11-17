package com.revature.northsouthbank.screens;

import com.revature.northsouthbank.services.UserService;
import com.revature.northsouthbank.util.ScreenRouter;

import java.io.BufferedReader;

import static com.revature.northsouthbank.screens.ViewBalanceScreen.current_balance;

public class DepositScreen extends Screen {

    private final UserService bankService;

    public DepositScreen(BufferedReader consoleReader, ScreenRouter router, UserService bankService) {
        super("DepositScreen", "/deposits", consoleReader, router);
        this.bankService = bankService;
    }

    @Override
    public void render() throws Exception {
        try {
            double depositAmount;
        System.out.println("Hello! Your current balance is " + "$" + current_balance + ".");
        System.out.println(" ");
        System.out.print("How much money would you like to deposit today?\n" +
                            "Enter an amount here > ");
        depositAmount = Double.parseDouble(consoleReader.readLine());
        System.out.println("You have deposited " + "$" + depositAmount + " into your account!");
        System.out.println(" ");
        current_balance = current_balance + depositAmount;
        System.out.println("Your new balance is: " + "$" + current_balance);
        System.out.println(" ");
        System.out.println("Taking you back to dashboard...");
        } catch (NumberFormatException n) {
            System.out.println("Invalid command. Please try again.");
            System.out.println(" ");
            router.navigate("/deposits");
        }

        // must add a way to get balance from somewhere and add deposit amount from it
        // to create a new balance (balance after adding deposit)
    }
}
