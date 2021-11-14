package com.revature.northsouthbank.screens;

import com.revature.northsouthbank.services.BankService;
import com.revature.northsouthbank.util.ScreenRouter;

import java.io.BufferedReader;

public class WithdrawScreen extends Screen {

    private final BankService bankService;

    public WithdrawScreen(BufferedReader consoleReader, ScreenRouter router, BankService bankService) {

        super("WithdrawScreen", "/withdrawls", consoleReader, router);
        this.bankService = bankService;
    }

    @Override
    public void render() throws Exception {
        double withdrawAmount;
        System.out.println("Hello! How much money would you like to withdraw today?\n" +
                            "Enter an amount here > ");
        withdrawAmount = Double.parseDouble(consoleReader.readLine());
        System.out.println("You have withdrawn " + "$" + withdrawAmount + " into your account!");
    }

}
