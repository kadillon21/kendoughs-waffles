package com.pluralsight.kendoughs_waffles.controllers;

import com.pluralsight.kendoughs_waffles.models.enums.*;
import com.pluralsight.kendoughs_waffles.models.products.*;
import com.pluralsight.kendoughs_waffles.models.Order;
import com.pluralsight.kendoughs_waffles.models.products.waffles.*;
import com.pluralsight.kendoughs_waffles.repositories.DrinkRepository;
import com.pluralsight.kendoughs_waffles.repositories.SideRepository;
import com.pluralsight.kendoughs_waffles.repositories.ToppingRepository;
import com.pluralsight.kendoughs_waffles.ui.Menus;
import com.pluralsight.kendoughs_waffles.util.ConsoleUtilities;
import com.pluralsight.kendoughs_waffles.util.ReceiptWriter;
import com.pluralsight.kendoughs_waffles.util.UserInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class AppController {

    @Autowired
    private DrinkRepository drinkRepository;

    @Autowired
    private SideRepository sideRepository;

    @Autowired
    private ToppingRepository toppingRepository;

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
                case '1' -> {
                    order.addProduct(new ClassicKen());
                    onSignatureWaffleMenu = false;
                }
                case '2' -> {
                    order.addProduct(new NutellaDream());
                    onSignatureWaffleMenu = false;
                }
                case '3' -> {
                    order.addProduct(new Sunrise());
                    onSignatureWaffleMenu = false;
                }
                case '4' -> {
                    order.addProduct(new RedRoyale());
                    onSignatureWaffleMenu = false;
                }
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
                case 'C' -> {
                    order.addProduct(customWaffle);
                    onCustomWaffleMenu = false;
                }
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
        String[] validMenuOptions = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "D"};
        while(onCustomWaffleToppingsMenu) {
            Menus.customWaffleToppingsMenu(toppings);
            switch (UserInput.promptForString("What toppings would you like?", validMenuOptions)){
                case "1"  -> addToppingToList(toppings, ToppingName.WHIPPED_CREAM);
                case "2"  -> addToppingToList(toppings, ToppingName.POWDERED_SUGAR);
                case "3"  -> addToppingToList(toppings, ToppingName.MAPLE_SYRUP);
                case "4"  -> addToppingToList(toppings, ToppingName.CINNAMON);
                case "5"  -> addToppingToList(toppings, ToppingName.BUTTER);
                case "6"  -> addToppingToList(toppings, ToppingName.CARAMEL_DRIZZLE);
                case "7"  -> addToppingToList(toppings, ToppingName.NUTELLA);
                case "8"  -> addToppingToList(toppings, ToppingName.FRESH_STRAWBERRIES);
                case "9"  -> addToppingToList(toppings, ToppingName.BACON_CRUMBLES);
                case "10" -> addToppingToList(toppings, ToppingName.ICE_CREAM);
                case "11" -> addToppingToList(toppings, ToppingName.FRESH_BLUEBERRIES);
                case "12" -> addToppingToList(toppings, ToppingName.COOKIE_BUTTER);
                case "D" -> onCustomWaffleToppingsMenu = false;
            }
        }
        return toppings;
    }

    private void addToppingToList(List<Topping> toppings, ToppingName toppingName) {
        toppingRepository.findByNameAndIsAvailable(toppingName, true)
                .ifPresentOrElse(
                        toppings::add,
                        () -> System.out.println(ConsoleUtilities.DANGER + "Sorry, that topping is unavailable." + ConsoleUtilities.RESET)
                );
    }

    private void handleToppingRemovalMenu(Order order) {

    }

    private void handleDrinkMenu(Order order) {
        boolean onDrinkMenu = true;
        while (onDrinkMenu) {
            Menus.drinkMenu();
            switch (UserInput.promptForChar("What would you like to do? ", "123456X")) {
                case '1' -> addDrinkToOrder(order, DrinkFlavor.COFFEE);
                case '2' -> addDrinkToOrder(order, DrinkFlavor.OJ);
                case '3' -> addDrinkToOrder(order, DrinkFlavor.MILK);
                case '4' -> addDrinkToOrder(order, DrinkFlavor.LEMONADE);
                case '5' -> addDrinkToOrder(order, DrinkFlavor.APPLE_JUICE);
                case '6' -> addDrinkToOrder(order, DrinkFlavor.CRANBERRY_JUICE);
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

    private void addDrinkToOrder(Order order, DrinkFlavor flavor) {
        DrinkSize size = handleDrinkSize();
        drinkRepository.findByFlavorAndSizeAndIsAvailable(flavor, size, true)
                .ifPresentOrElse(
                        order::addProduct,
                        () -> System.out.println(ConsoleUtilities.DANGER + "Sorry, that size is unavailable." + ConsoleUtilities.RESET)
                );
    }

    private boolean isDrinkAvailable(DrinkFlavor flavor) {
        return !drinkRepository.findByFlavorAndIsAvailable(flavor, true).isEmpty();
    }

    private void handleSideMenu(Order order) {
        boolean onSideMenu = true;
        while(onSideMenu) {
            Menus.sideMenu();
            switch (UserInput.promptForChar("What would you like to do? ", "1234X")) {
                case '1' -> addSideToOrder(order, SideType.HASH_BROWNS);
                case '2' -> addSideToOrder(order, SideType.WAFFLE_FRIES);
                case '3' -> addSideToOrder(order, SideType.BACON);
                case '4' -> addSideToOrder(order, SideType.FRUIT_CUP);
                case 'X' -> onSideMenu = false;
            }
        }
    }

    private void addSideToOrder(Order order, SideType sideType) {
        sideRepository.findBySideTypeAndIsAvailable(sideType, true)
                .ifPresentOrElse(
                        order::addProduct,
                        () -> System.out.println(ConsoleUtilities.DANGER + "Sorry, that size is unavailable." + ConsoleUtilities.RESET)
                );
    }

    private void handleViewCurrentOrder(Order order) {
        boolean onViewCurrentOrder = true;
        while(onViewCurrentOrder) {
            Menus.viewCurrentOrder(order);
            switch (UserInput.promptForChar("What would you like to do? ", "RX")) {
                case 'R' -> {
                    onViewCurrentOrder = false;
                    handleRemoveItemMenu(order);
                }
                case 'X' -> onViewCurrentOrder = false;
            }
        }
    }

    private void handleRemoveItemMenu(Order order) {
//        boolean onRemoveItemMenu = true;
//        while(onRemoveItemMenu) {
//            Menus.removeItemMenu(order);
//
//
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
        updateStock(order);
    }

    private void updateStock(Order order) {
        for (Product product : order.getProducts()) {
            if (product instanceof Drink drink) {
                drink.setStockCount(drink.getStockCount() - 1);
                if (drink.getStockCount() <= 0) drink.setAvailable(false);
                drinkRepository.save(drink);
            } else if (product instanceof Side side) {
                side.setStockCount(side.getStockCount() - 1);
                if (side.getStockCount() <= 0) side.setAvailable(false);
                sideRepository.save(side);
            }
        }
    }
}
