package com.revature.northsouthbank.util;

import com.revature.northsouthbank.daos.AppUserDAO;
import com.revature.northsouthbank.screens.DashboardScreen;
import com.revature.northsouthbank.screens.LoginScreen;
import com.revature.northsouthbank.screens.RegisterScreen;
import com.revature.northsouthbank.screens.WelcomeScreen;
import com.revature.northsouthbank.services.UserService;
import com.revature.northsouthbank.util.logging.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AppState {

    private final Logger logger;
    private static boolean appRunning;
    private final ScreenRouter router;

    public AppState() {

        logger = Logger.getLogger(true);
        logger.log("Initializing application...");

        appRunning = true;
        router = new ScreenRouter();
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        AppUserDAO userDAO = new AppUserDAO();
        UserService userService = new UserService(userDAO);

        router.addScreen(new WelcomeScreen(consoleReader, router));
        router.addScreen(new RegisterScreen(consoleReader, router, userService));
        router.addScreen(new LoginScreen(consoleReader, router, userService));
        router.addScreen(new DashboardScreen(consoleReader, router, userService));

    }

    public void startup() {
        try {
            while (appRunning) {
                router.navigate("/welcome");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void shutdown() {
        appRunning = false;
    }
}
