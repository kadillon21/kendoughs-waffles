package com.pluralsight.kendoughs_waffles.controllers;

import com.pluralsight.kendoughs_waffles.ui.Menus;
import com.pluralsight.kendoughs_waffles.util.UserInput;

public class AppController {

    public void run() {
        handleMainMenu();
    }

    private void handleMainMenu() {
        boolean onMainMenu = true;
        while(onMainMenu) {
            Menus.mainMenu();
            switch (UserInput.promptForChar("What would you like to do? ", "1234X")) {
                case '1':
                    handleOrderMenu();
                    break;
                case '2':
                    break;
                case '3':
                    Menus.displayStoreMenu();
                    break;
                case '4':
                    Menus.displayAboutUs();
                    break;
                case 'X':
                    onMainMenu = false;
            }
        }
    }

    private void handleOrderMenu() {
    }
}
