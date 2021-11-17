package com.revature.northsouthbank.screens;

import com.revature.northsouthbank.services.UserService;
import com.revature.northsouthbank.util.ScreenRouter;

import java.io.BufferedReader;

public class ViewBalanceScreen extends Screen {

    public static double current_balance = 0;
    private final UserService userService;

    public ViewBalanceScreen(BufferedReader consoleReader, ScreenRouter router, UserService userService) {
        super("ViewBalanceScreen", "/balance", consoleReader, router);
        this.userService = userService;
    }

    @Override
    public void render() throws Exception {
        System.out.println("Hello! Your current balance is " + "$" + current_balance);
        System.out.println(" ");
        System.out.println("What would you like to do now?");

        String balanceMenu = "1) Deposit money\n" +
                "2) Withdraw money\n" +
                "3) Return to Dashboard\n" +
                "Enter choice here > ";

        System.out.print(balanceMenu);

        String balanceSelection = consoleReader.readLine();

        switch (balanceSelection) {
            case "1":
                System.out.println("Ok! Taking you to Deposit screen...");
                router.navigate("/deposits");
                break;
            case "2":
                System.out.println("Ok! Taking you to Withdrawal screen...");
                router.navigate("/withdrawals");
                break;
            case "3":
                System.out.println("Ok! Taking you to Dashboard...");
                router.navigate("/dashboard");
                break;
            default:
                System.out.println("Invalid selection. Please enter 1, 2, or 3.");
                router.navigate("/balance");
        }
    }
}
