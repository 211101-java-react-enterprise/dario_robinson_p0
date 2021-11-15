package com.revature.northsouthbank.screens;

import com.revature.northsouthbank.services.BankService;
import com.revature.northsouthbank.util.ScreenRouter;

import java.io.BufferedReader;

public class ViewBalanceScreen extends Screen {

    public static double balance = 0.00;
    private final BankService bankService;

    public ViewBalanceScreen(BufferedReader consoleReader, ScreenRouter router, BankService bankService) {
        super("ViewBalanceScreen", "/balance", consoleReader, router);
        this.bankService = bankService;
    }

    @Override
    public void render() throws Exception {

    }
}
