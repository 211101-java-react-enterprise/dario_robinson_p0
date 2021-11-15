package com.revature.northsouthbank.screens;

import com.revature.northsouthbank.services.BankService;
import com.revature.northsouthbank.util.ScreenRouter;

import java.io.BufferedReader;

public class DepositScreen extends Screen {

    private final BankService bankService;

    public DepositScreen(BufferedReader consoleReader, ScreenRouter router, BankService bankService) {
        super("DepositScreen", "/deposits", consoleReader, router);
        this.bankService = bankService;
    }

    @Override
    public void render() throws Exception {
        double depositAmount;
        System.out.print("Hello! How much money would you like to deposit today?\n" +
                            "Enter an amount here > ");
        depositAmount = Double.parseDouble(consoleReader.readLine());
        System.out.println("You have deposited " + "$" + depositAmount + " into your account!");
        System.out.println("Taking you back to dashboard...");

        // must add a way to get balance from somewhere and add deposit amount from it
        // to create a new balance (balance after adding deposit)
    }
}
