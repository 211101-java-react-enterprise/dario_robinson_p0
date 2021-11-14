package com.revature.northsouthbank.screens;

import com.revature.northsouthbank.util.ScreenRouter;

import java.io.BufferedReader;

public class ViewBalanceScreen extends Screen {

    double newUserBalance = 0.00;

    public ViewBalanceScreen(BufferedReader consoleReader, ScreenRouter router) {
        super ("ViewBalanceScreen", "/balance", consoleReader, router);
    }

    @Override
    public void render() throws Exception {


    }

}
