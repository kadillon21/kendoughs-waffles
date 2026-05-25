package com.pluralsight.kendoughs_waffles.controllers;

import com.pluralsight.kendoughs_waffles.models.enums.*;
import com.pluralsight.kendoughs_waffles.models.products.*;
import com.pluralsight.kendoughs_waffles.models.Order;
import com.pluralsight.kendoughs_waffles.models.products.waffles.*;
import com.pluralsight.kendoughs_waffles.ui.Menus;
import com.pluralsight.kendoughs_waffles.util.ReceiptWriter;
import com.pluralsight.kendoughs_waffles.util.UserInput;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class AppController {

    public void run() throws IOException {
        handleMainMenu();
    }

    private void handleMainMenu() throws IOException {
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

    private void handleOrderMenu() throws IOException {
        boolean onOrderMenu = true;
        Order order = new Order(1, "Kendall", "kadillon21@gmail.com", "773-383-8814", new ArrayList<>());
        while(onOrderMenu) {
            Menus.orderMenu();
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
                case '1' -> order.addProduct(new ClassicKen());
                case 'X' -> onDailySpecial = false;
            }
        }
    }

    private void handleSignatureWaffleMenu(Order order) {
        boolean onSignatureWaffleMenu = true;
        while (onSignatureWaffleMenu){
            Menus.signatureWaffleMenu();
            switch (UserInput.promptForChar("What would you like to do? ", "1234X")){
                case '1' -> order.addProduct(new ClassicKen());
                case '2' -> order.addProduct(new NutellaDream());
                case '3' -> order.addProduct(new Sunrise());
                case '4' -> order.addProduct(new RedRoyale());
                case 'X' -> onSignatureWaffleMenu = false;
            }
        }
    }

    private void handleCustomWaffleMenu(Order order) {
        boolean onCustomWaffleMenu = true;
        Waffle customWaffle = new Waffle("Custom Waffle", 0, null, null, new ArrayList<>(), FillFlavor.NONE);
        while (onCustomWaffleMenu){
            Menus.customWaffleMenu(customWaffle.getType(), customWaffle.getSize(), customWaffle.getFilling(), customWaffle.getToppings());
            switch(UserInput.promptForChar("What would you like to do? ", "12345CX")){
                case '1' -> customWaffle.setWaffleType(handleCustomWaffleTypeMenu(order));
                case '2' -> customWaffle.setWaffleSize(handleCustomWaffleSizeMenu(order));
                case '3' -> customWaffle.setFillFlavor(handleCustomWaffleFillFlavorMenu(order));
                case '4' -> customWaffle.getToppings().addAll(handleCustomWaffleToppingsMenu());
                case '5' -> handleToppingRemovalMenu(order);
                case 'C' -> order.addProduct(customWaffle) ;
                case 'X' -> onCustomWaffleMenu = false;
            }
        }
    }

    private WaffleType handleCustomWaffleTypeMenu(Order order) {
        Menus.customWaffleTypeMenu();
        return switch (UserInput.promptForChar("What would you like to do? ", "12345X")) {
            case '1' -> WaffleType.BUTTER_MILK;
            case '2' -> WaffleType.BELGIAN;
            case '3' -> WaffleType.LIEGE;
            case '4' -> WaffleType.CHURRO;
            case '5' -> WaffleType.RED_VELVET;
            case 'X' -> null;
            default -> handleCustomWaffleTypeMenu(order);
        };
    }
    private WaffleSize handleCustomWaffleSizeMenu(Order order) {
        Menus.customWaffleSizeMenu();
        return switch (UserInput.promptForChar("What would you like to do? ", "123456X")) {
            case '1' -> WaffleSize.MINI;
            case '2' -> WaffleSize.REGULAR;
            case '3' -> WaffleSize.LARGE;
            case 'X' -> null;
            default -> handleCustomWaffleSizeMenu(order);
        };
    }

    private FillFlavor handleCustomWaffleFillFlavorMenu(Order order) {
        Menus.customWaffleFillingMenu();
        return switch (UserInput.promptForChar("What type of filling do you want? ", "12345X")) {
            case '1' -> FillFlavor.NONE;
            case '2' -> FillFlavor.NUTELLA;
            case '3' -> FillFlavor.CREAM_CHEESE;
            case '4' -> FillFlavor.JAM;
            case '5' -> FillFlavor.STRAWBERRY;
            case 'X' -> null;
            default -> handleCustomWaffleFillFlavorMenu(order);
        };
    }

    private List<Topping> handleCustomWaffleToppingsMenu() {
        boolean onCustomWaffleToppingsMenu = true;
        ArrayList<Topping> toppings = new ArrayList<>();
        Menus.customWaffleToppingsMenu(toppings);
        String[] validMenuOptions = {"1", "2","3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "D"};
        while(onCustomWaffleToppingsMenu) {
            switch (UserInput.promptForString("What toppings would you like?", validMenuOptions)){
                case "1" -> toppings.add(new RegularTopping(ToppingName.WHIPPED_CREAM, 100, true));
                case "2" -> toppings.add(new RegularTopping(ToppingName.POWDERED_SUGAR, 100, true));
                case "3" -> toppings.add(new RegularTopping(ToppingName.MAPLE_SYRUP, 100, true));
                case "4" -> toppings.add(new RegularTopping(ToppingName.CINNAMON, 100, true));
                case "5" -> toppings.add(new RegularTopping(ToppingName.BUTTER, 100, true));
                case "6" -> toppings.add(new RegularTopping(ToppingName.CARAMEL_DRIZZLE, 100, true));
                case "7" -> toppings.add(new PremiumTopping(ToppingName.NUTELLA, 100, true));
                case "8" -> toppings.add(new PremiumTopping(ToppingName.FRESH_STRAWBERRIES, 100, true));
                case "9" -> toppings.add(new PremiumTopping(ToppingName.BACON_CRUMBLES, 100, true));
                case "10" -> toppings.add(new PremiumTopping(ToppingName.ICE_CREAM, 100, true));
                case "11" -> toppings.add(new PremiumTopping(ToppingName.FRESH_BLUEBERRIES, 100, true));
                case "12" -> toppings.add(new PremiumTopping(ToppingName.COOKIE_BUTTER, 100, true));
                case "D" -> onCustomWaffleToppingsMenu = false;
            }
        }
        return toppings;
    }

    private void handleToppingRemovalMenu(Order order) {

    }

    private void handleDrinkMenu(Order order) {
        boolean onDrinkMenu = true;
        while(onDrinkMenu) {
            Menus.drinkMenu();
            switch (UserInput.promptForChar("What would you like to do? ", "123456X")) {
                case '1' -> order.addProduct(new Drink(2.99, DrinkFlavor.COFFEE, handleDrinkSize(), 10, true));
                case '2' -> order.addProduct(new Drink(2.99, DrinkFlavor.OJ, handleDrinkSize(), 10, true));
                case '3' -> order.addProduct(new Drink(1.99, DrinkFlavor.MILK, handleDrinkSize(), 10, true));
                case '4' -> order.addProduct(new Drink(2.49, DrinkFlavor.LEMONADE, handleDrinkSize(), 10, true));
                case '5' -> order.addProduct(new Drink(2.49, DrinkFlavor.APPLE_JUICE, handleDrinkSize(), 10, true));
                case '6' -> order.addProduct(new Drink(2.49, DrinkFlavor.CRANBERRY_JUICE, handleDrinkSize(), 10, true));
                case 'X' -> onDrinkMenu = false;
            }
        }
    }

    private DrinkSize handleDrinkSize() {
        Menus.drinkSizeMenu();
        return switch (UserInput.promptForChar("What size drink do you want? ", "123X")) {
            case '1' -> DrinkSize.SMALL;
            case '2' -> DrinkSize.MEDIUM;
            case '3' -> DrinkSize.LARGE;
            case 'X' -> null;
            default -> handleDrinkSize();
        };
    }

    private void handleSideMenu(Order order) {
        boolean onSideMenu = true;
        while(onSideMenu) {
            Menus.sideMenu();
            switch (UserInput.promptForChar("What would you like to do? ", "1234X")) {
                case '1' -> order.addProduct(new Side(2.99, SideType.HASH_BROWNS, 10, true));
                case '2' -> order.addProduct(new Side(3.49, SideType.WAFFLE_FRIES, 10, true));
                case '3' -> order.addProduct(new Side(2.49, SideType.BACON, 10, true));
                case '4' -> order.addProduct(new Side(2.99, SideType.FRUIT_CUP, 10, true));
                case 'X' -> onSideMenu = false;
            }
        }
    }

    private void handleViewCurrentOrder(Order order) {
        boolean onViewCurrentOrder = true;
        while(onViewCurrentOrder) {
            Menus.viewCurrentOrder(order);
            switch (UserInput.promptForChar("What would you like to do? ", "RX")) {
                case '1' -> handleRemoveItemMenu(order);
                case 'X' -> onViewCurrentOrder = false;
            }
        }
    }

    private void handleRemoveItemMenu(Order order) {
        boolean onRemoveItemMenu = true;
        while(onRemoveItemMenu) {
            Menus.removeItemMenu(order);

        }
    }

    private void handleCheckoutMenu(Order order) throws IOException {
        boolean onCheckoutMenu = true;
        while(onCheckoutMenu) {
            Menus.checkoutMenu(order);
            switch (UserInput.promptForChar("What would you like to do? ", "1X")) {
                case '1' -> printReceipt(order);
                case 'X' -> onCheckoutMenu = false;
            }
        }
    }

    private void printReceipt(Order order) throws IOException {
        ReceiptWriter.writeReceipt(order);
    }
}
