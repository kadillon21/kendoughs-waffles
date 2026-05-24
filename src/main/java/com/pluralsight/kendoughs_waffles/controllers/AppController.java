package com.pluralsight.kendoughs_waffles.controllers;

import com.pluralsight.kendoughs_waffles.models.Drink;
import com.pluralsight.kendoughs_waffles.models.Order;
import com.pluralsight.kendoughs_waffles.models.Product;
import com.pluralsight.kendoughs_waffles.models.Side;
import com.pluralsight.kendoughs_waffles.models.enums.DrinkFlavor;
import com.pluralsight.kendoughs_waffles.models.enums.DrinkSize;
import com.pluralsight.kendoughs_waffles.models.enums.SideType;
import com.pluralsight.kendoughs_waffles.ui.Menus;
import com.pluralsight.kendoughs_waffles.util.UserInput;

import java.util.ArrayList;
import java.util.List;

public class AppController {

    public void run() {
        handleMainMenu();


        Drink drink = new Drink(10, DrinkFlavor.COFFEE, DrinkSize.LARGE, 10, true);
        Side side = new Side(10, SideType.FRUIT_CUP, 10, true);

        List<Product> products = new ArrayList<>();
        products.add(drink);
        products.add(side);

        Order testOrder = new Order(1, "Kendall", "kendall@test.com", "555-1234", products);

        Menus.checkoutMenu(testOrder);
    }

    private void handleMainMenu() {
        boolean onMainMenu = true;
        while(onMainMenu) {
            Menus.mainMenu();
            switch (UserInput.promptForChar("What would you like to do? ", "1234X")) {
                case '1' -> handleOrderMenu();
                case '2' -> System.out.println("In development");
                case '3'-> Menus.displayStoreMenu();
                case '4' -> Menus.displayAboutUs();
                case 'X'-> onMainMenu = false;
            }
        }
    }

    private void handleOrderMenu() {
        boolean onOrderMenu = true;
        while(onOrderMenu) {
            Menus.orderMenu();
            Order order = new Order(1, "Kendall", "kadillon21@gmail.com", "773-383-8814", new ArrayList<>());
            switch (UserInput.promptForChar("What would you like to do? ", "123456X")) {
                case '1' -> handleWaffleMenu(order);
                case '2' -> handleDrinkMenu(order);
                case '3' -> handleSideMenu(order);
                case '4' -> handleViewCurrentOrder(order);
                case '5' -> handleRemoveItemMenu(order);
                case '6' -> handleCheckoutMenu(order);
                case 'X' -> onOrderMenu = false;
            }
        }
    }

    private void handleWaffleMenu(Order order) {
        boolean onWaffleMenu = true;
        while(onWaffleMenu) {
            Menus.waffleMenu();
            switch (UserInput.promptForChar("What would you like to do? ", "123X")) {
                case '1' -> handleCustomWaffleMenu(order);
                case '2' -> handleSignatureWaffleMenu(order);
                case '3' -> handleDailySpecial(order);
                case 'X' -> onWaffleMenu = false;
            }
        }
    }

    private void handleDailySpecial(Order order) {
        boolean onDailySpecial = true;
        while (onDailySpecial){
            Menus.dailySpecialMenu();
            switch (UserInput.promptForChar("What would you like to do? ", "123X")) {
                case '1' -> ;
                case 'X' -> onDailySpecial = false;
            }
        }
    }

    private void handleSignatureWaffleMenu(Order order) {
        boolean onSignatureWaffleMenu = true;
        while (onSignatureWaffleMenu){
            Menus.signatureWaffleMenu();
            switch (UserInput.promptForChar("What would you like to do? ", "1X")){
                case '1' -> ;
                case 'X' -> onSignatureWaffleMenu = false;
            }
        }
    }

    private void handleCustomWaffleMenu(Order order) {
        boolean onCustomWaffleMenu = true;
        while (onCustomWaffleMenu){
            Menus.customWaffleMenu();
            switch(UserInput.promptForChar("What would you like to do? ", "123456X")){
                case '1' -> ;
                case '2' -> ;
                case '3' -> ;
                case '4' -> ;
                case '5' -> ;
                case '6' -> ;
                case 'X' -> onCustomWaffleMenu = false;
            }
        }
    }

    private void handleDrinkMenu(Order order) {
        boolean onDrinkMenu = true;
        while(onDrinkMenu) {
            Menus.drinkMenu();
            switch (UserInput.promptForChar("What would you like to do? ", "123456X")) {
                case '1' -> ;
                case '2' -> ;
                case '3' -> ;
                case '4' -> ;
                case '5' -> ;
                case '6' -> ;
                case 'X' -> onDrinkMenu = false;
            }
        }
    }

    private void handleSideMenu(Order order) {
        boolean onSideMenu = true;
        while(onSideMenu) {
            Menus.sideMenu();
            switch (UserInput.promptForChar("What would you like to do? ", "1234X")) {
                case '1' -> ;
                case '2' -> ;
                case '3' -> ;
                case '4' -> ;
                case 'X' -> onSideMenu = false;
            }
        }
    }

    private void handleViewCurrentOrder(Order order) {
        boolean onViewCurrentOrder = true;
        while(onViewCurrentOrder) {
            Menus.viewCurrentOrder(order);
        }
    }

    private void handleRemoveItemMenu(Order order) {
        boolean onRemoveItemMenu = true;
        while(onRemoveItemMenu) {
            Menus.removeItemMenu(order);

        }
    }

    private void handleCheckoutMenu(Order order) {
        boolean onCheckoutMenu = true;
        while(onCheckoutMenu) {
            Menus.checkoutMenu(order);
            switch (UserInput.promptForChar("What would you like to do? ", "1X")) {
                case '1' -> printReceipt();
                case 'X' -> Menus.mainMenu();
            }
        }
    }

    private void printReceipt() {}
}
