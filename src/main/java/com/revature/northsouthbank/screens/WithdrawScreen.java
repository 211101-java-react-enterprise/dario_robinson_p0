package com.revature.northsouthbank.screens;

import com.revature.northsouthbank.services.UserService;
import com.revature.northsouthbank.util.ScreenRouter;

import java.io.BufferedReader;

import static com.revature.northsouthbank.screens.ViewBalanceScreen.current_balance;

public class WithdrawScreen extends Screen {

    private final UserService bankService;

    public WithdrawScreen(BufferedReader consoleReader, ScreenRouter router, UserService bankService) {

        super("WithdrawScreen", "/withdrawals", consoleReader, router);
        this.bankService = bankService;
    }

    @Override
    public void render() throws Exception {
        try {
            double withdrawAmount;
            System.out.println("Hello! Your current balance is " + "$" + current_balance + ".");
            System.out.println(" ");
            System.out.print("How much money would you like to withdraw today?\n" +
                    "Enter an amount here > ");
            withdrawAmount = Double.parseDouble(consoleReader.readLine());
            if (withdrawAmount >= 0.00 && current_balance >= withdrawAmount) {
                System.out.println("You have withdrawn " + "$" + withdrawAmount + " from your account!");
                System.out.println(" ");
                current_balance = current_balance - withdrawAmount;
                System.out.println("Your new balance is: " + "$" + current_balance);
                System.out.println(" ");
                System.out.println("Taking you back to dashboard...");
            } else if (current_balance < withdrawAmount) {
                System.out.println("Cannot withdraw; insufficient funds. Please try again.");
                System.out.println(" ");
                router.navigate("/withdrawals");
            }
        } catch (NumberFormatException n) {
            System.out.println("Invalid command. Please try again.");
            System.out.println(" ");
            router.navigate("/withdrawals");
        }
    }
}
