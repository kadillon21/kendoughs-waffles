package com.pluralsight.kendoughs_waffles.controllers;

import com.pluralsight.kendoughs_waffles.models.enums.*;
import com.pluralsight.kendoughs_waffles.models.products.Topping;
import com.pluralsight.kendoughs_waffles.models.products.order.Order;
import com.pluralsight.kendoughs_waffles.models.products.waffles.*;
import com.pluralsight.kendoughs_waffles.repositories.*;
import com.pluralsight.kendoughs_waffles.services.OrderService;
import com.pluralsight.kendoughs_waffles.ui.Menus;
import com.pluralsight.kendoughs_waffles.util.ConsoleUtilities;
import com.pluralsight.kendoughs_waffles.util.ReceiptGetter;
import com.pluralsight.kendoughs_waffles.util.ReceiptWriter;
import com.pluralsight.kendoughs_waffles.util.UserInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class AppController {

    // Inject repositories
    @Autowired
    private DrinkRepository drinkRepository;

    @Autowired
    private SideRepository sideRepository;

    @Autowired
    private ToppingRepository toppingRepository;

    @Autowired
    private WaffleTypeRepository waffleTypeRepository;

    @Autowired
    private WaffleSizeRepository waffleSizeRepository;

    @Autowired
    private FillFlavorRepository fillFlavorRepository;

    @Autowired
    private OrderService orderService;

    // Run the application
    public void run() throws IOException {
        handleMainMenu();

    }

    // Method to handle the main menu
    private void handleMainMenu() throws IOException {
        ConsoleUtilities.clearScreen();
        ConsoleUtilities.clearScreen("Loading...");
        boolean onMainMenu = true;
        while (onMainMenu) {
            Menus.mainMenu();
            switch (UserInput.promptForChar("What would you like to do? ", "1234X")) {
                case '1' -> handleOrderMenu();
                case '2' -> receiptLookUp();
                case '3' -> Menus.displayStoreMenu();
                case '4' -> Menus.displayAboutUs();
                case 'X' -> {
                    ConsoleUtilities.clearScreen("Exiting...");
                    onMainMenu = false;
                }
            }
        }
    }

    // Method to look up a receipt by order number
    private void receiptLookUp() {
        int userOrder = UserInput.promptForInt("What is your four digit order number? ", 1, 9999);

        // Create a folder to store receipts if it doesn't exist'
        File folder = new File("receipts");
        File[] listOfFiles = folder.listFiles(); // Get a list of files in the folder
        String lookup = "Order-" + String.format("%04d", userOrder);
        boolean found = false;

        // Checks if the folder is empty
        if (listOfFiles != null) {
            // Loop through the files in the folder
            for (File file : listOfFiles) {
                if (file.getName().contains(lookup)) {
                    String filepath = file.getName();
                    found = true;
                    try {
                        // Print the receipt
                        Menus.receiptDisplayMenu(ReceiptGetter.getReceipt(filepath));
                        boolean viewingReceipt = true;
                        while (viewingReceipt) {
                            switch (UserInput.promptForChar("Press X to return to the main menu ")) {
                                case 'X' -> viewingReceipt = false;
                                default ->
                                        System.out.println(ConsoleUtilities.DANGER + "Invalid input. Please enter X to return to the main menu." + ConsoleUtilities.RESET);
                            }
                        }
                    } catch (IOException e) {
                        System.out.println("Error reading receipt file.");
                    }
                }
            }
        }
        if (!found) {
            System.out.println(ConsoleUtilities.DANGER + "Sorry, we couldn't find that order." + ConsoleUtilities.RESET);
        }
    }

    private void getUserInformation(Order order) {
        order.setCustomerPhone(UserInput.promptForString("What is your phone number? (XXX-XXX-XXXX)"));
        order.setCustomerEmail(UserInput.promptForString("What is your email address? "));
        order.setCustomerName(UserInput.promptForString("What is your name? "));
    }

    // Method to handle the order menu
    private void handleOrderMenu() throws IOException {
        ConsoleUtilities.clearScreen("Loading Order Menu...");
        boolean onOrderMenu = true;
        Order order = new Order(1, null, null, null, new ArrayList<>());
        // Sets the user information for the order
        getUserInformation(order);
        ConsoleUtilities.clearScreen("Saving user information...");
        while (onOrderMenu) {
            Menus.orderMenu();
            switch (UserInput.promptForChar("What would you like to do? ", "123456X")) {
                case '1' -> handleWaffleMenu(order);
                case '2' -> handleDrinkMenu(order);
                case '3' -> handleSideMenu(order);
                case '4' -> handleViewCurrentOrder(order);
                case '5' -> handleRemoveItemMenu(order);
                case '6' -> {
                    if (!handleCheckoutMenu(order)) onOrderMenu = false;
                }
                case 'X' -> {
                    ConsoleUtilities.clearScreen("Exiting order menu...");
                    onOrderMenu = false;
                }
            }
        }
    }

    // Method to handle the checkout menu
    private void handleWaffleMenu(Order order) {
        ConsoleUtilities.clearScreen("Loading Waffle Menu...");
        boolean onWaffleMenu = true;
        while (onWaffleMenu) {
            Menus.waffleMenu();
            switch (UserInput.promptForChar("What would you like to do? ", "123X")) {
                case '1' -> {
                    if (!handleCustomWaffleMenu(order)) onWaffleMenu = false;
                }
                case '2' -> {
                    if (!handleSignatureWaffleMenu(order)) onWaffleMenu = false;
                }
                case '3' -> handleDailySpecial(order);
                case 'X' -> onWaffleMenu = false;
            }
        }
    }

    // Method to handle the checkout menu
    private void handleDailySpecial(Order order) {
        ConsoleUtilities.clearScreen("Loading Daily Special Menu...");
        boolean onDailySpecial = true;
        while (onDailySpecial) {
            Menus.dailySpecialMenu();
            switch (UserInput.promptForChar("What would you like to do? ", "123X")) {
                // Adds daily special to order if available
                case '1' -> {
                    String special = Menus.getDailySpecial();
                    if (special.equals("The Classic Ken")) {
                        if (waffleTypeRepository.findByWaffleTypeAndIsAvailable(WaffleType.BUTTER_MILK, true).isPresent()) {
                            List<Topping> toppings = new ArrayList<>();
                            addToppingToList(toppings, ToppingName.MAPLE_SYRUP);
                            addToppingToList(toppings, ToppingName.BUTTER);
                            order.addProduct(new ClassicKen(toppings));
                        } else {
                            System.out.println(ConsoleUtilities.DANGER + "Sorry, that waffle type is unavailable." + ConsoleUtilities.RESET);
                        }
                    } else if (special.equals("The Nutella Dream")) {
                        if (waffleTypeRepository.findByWaffleTypeAndIsAvailable(WaffleType.BELGIAN, true).isPresent()) {
                            List<Topping> toppings = new ArrayList<>();
                            addToppingToList(toppings, ToppingName.NUTELLA);
                            addToppingToList(toppings, ToppingName.FRESH_STRAWBERRIES);
                            addToppingToList(toppings, ToppingName.WHIPPED_CREAM);
                            order.addProduct(new NutellaDream(toppings));
                        } else {
                            System.out.println(ConsoleUtilities.DANGER + "Sorry, that waffle type is unavailable." + ConsoleUtilities.RESET);
                        }
                    } else if (special.equals("The Sunrise")) {
                        if (waffleTypeRepository.findByWaffleTypeAndIsAvailable(WaffleType.CHURRO, true).isPresent()) {
                            List<Topping> toppings = new ArrayList<>();
                            addToppingToList(toppings, ToppingName.BACON_CRUMBLES);
                            addToppingToList(toppings, ToppingName.MAPLE_SYRUP);
                            addToppingToList(toppings, ToppingName.POWDERED_SUGAR);
                            order.addProduct(new Sunrise(toppings));
                        } else {
                            System.out.println(ConsoleUtilities.DANGER + "Sorry, that waffle type is unavailable." + ConsoleUtilities.RESET);
                        }
                    } else if (special.equals("The Red Royale")) {
                        if (waffleTypeRepository.findByWaffleTypeAndIsAvailable(WaffleType.RED_VELVET, true).isPresent()) {
                            List<Topping> toppings = new ArrayList<>();
                            addToppingToList(toppings, ToppingName.ICE_CREAM);
                            addToppingToList(toppings, ToppingName.FRESH_BLUEBERRIES);
                            addToppingToList(toppings, ToppingName.COOKIE_BUTTER);
                            order.addProduct(new RedRoyale(toppings));
                        } else {
                            System.out.println(ConsoleUtilities.DANGER + "Sorry, that waffle type is unavailable." + ConsoleUtilities.RESET);
                        }
                    }
                    onDailySpecial = false;
                }
                case 'X' -> onDailySpecial = false;
            }
        }
    }

    // Method to handle the checkout menu
    private boolean handleSignatureWaffleMenu(Order order) {
        ConsoleUtilities.clearScreen("Loading Signature Waffle Menu...");
        boolean onSignatureWaffleMenu = true;
        while (onSignatureWaffleMenu) {
            Menus.signatureWaffleMenu();
            switch (UserInput.promptForChar("What would you like to do? ", "1234X")) {
                // Adds signature waffle to order if available
                case '1' -> {
                    if (waffleTypeRepository.findByWaffleTypeAndIsAvailable(WaffleType.BUTTER_MILK, true).isPresent()) {
                        List<Topping> toppings = new ArrayList<>();
                        addToppingToList(toppings, ToppingName.MAPLE_SYRUP);
                        addToppingToList(toppings, ToppingName.BUTTER);
                        order.addProduct(new ClassicKen(toppings));
                        onSignatureWaffleMenu = false;
                        ConsoleUtilities.clearScreen("Adding Classic Ken waffle to order...");
                    } else {
                        ConsoleUtilities.clearScreen(ConsoleUtilities.DANGER + "Sorry, that waffle type is unavailable." + ConsoleUtilities.RESET);
                    }
                }
                case '2' -> {
                    if (waffleTypeRepository.findByWaffleTypeAndIsAvailable(WaffleType.BELGIAN, true).isPresent()) {
                        List<Topping> toppings = new ArrayList<>();
                        addToppingToList(toppings, ToppingName.NUTELLA);
                        addToppingToList(toppings, ToppingName.FRESH_STRAWBERRIES);
                        addToppingToList(toppings, ToppingName.WHIPPED_CREAM);
                        order.addProduct(new NutellaDream(toppings));
                        onSignatureWaffleMenu = false;
                        ConsoleUtilities.clearScreen("Adding Nutella Dream waffle to order...");
                    } else {
                        ConsoleUtilities.clearScreen(ConsoleUtilities.DANGER + "Sorry, that waffle type is unavailable." + ConsoleUtilities.RESET);
                    }
                }
                case '3' -> {
                    if (waffleTypeRepository.findByWaffleTypeAndIsAvailable(WaffleType.CHURRO, true).isPresent()) {
                        List<Topping> toppings = new ArrayList<>();
                        addToppingToList(toppings, ToppingName.BACON_CRUMBLES);
                        addToppingToList(toppings, ToppingName.MAPLE_SYRUP);
                        addToppingToList(toppings, ToppingName.POWDERED_SUGAR);
                        order.addProduct(new Sunrise(toppings));
                        onSignatureWaffleMenu = false;
                        ConsoleUtilities.clearScreen("Adding Sunrise waffle to order...");
                    } else {
                        ConsoleUtilities.clearScreen(ConsoleUtilities.DANGER + "Sorry, that waffle type is unavailable." + ConsoleUtilities.RESET);
                    }
                }
                case '4' -> {
                    if (waffleTypeRepository.findByWaffleTypeAndIsAvailable(WaffleType.RED_VELVET, true).isPresent()) {
                        List<Topping> toppings = new ArrayList<>();
                        addToppingToList(toppings, ToppingName.ICE_CREAM);
                        addToppingToList(toppings, ToppingName.FRESH_BLUEBERRIES);
                        addToppingToList(toppings, ToppingName.COOKIE_BUTTER);
                        order.addProduct(new RedRoyale(toppings));
                        onSignatureWaffleMenu = false;
                        ConsoleUtilities.clearScreen("Adding Red Royale waffle to order...");
                    } else {
                        ConsoleUtilities.clearScreen(ConsoleUtilities.DANGER + "Sorry, that waffle type is unavailable." + ConsoleUtilities.RESET);
                    }
                }
                case 'X' -> onSignatureWaffleMenu = false;
            }
        }
        return onSignatureWaffleMenu;
    }

    // Method to handle creating a custom waffle
    private boolean handleCustomWaffleMenu(Order order) {
        ConsoleUtilities.clearScreen("Loading Custom Waffle Menu...");
        boolean onCustomWaffleMenu = true;
        Waffle customWaffle = new Waffle("Custom Waffle", 0, WaffleType.BUTTER_MILK, WaffleSize.REGULAR, new ArrayList<>(), FillFlavor.NONE);
        while (onCustomWaffleMenu) {
            Menus.customWaffleMenu(customWaffle.getType(), customWaffle.getSize(), customWaffle.getFilling(), customWaffle.getToppings(), customWaffle.getPrice());
            switch (UserInput.promptForChar("What would you like to do? ", "12345CX")) {
                case '1' -> {
                    customWaffle.setWaffleType(handleCustomWaffleTypeMenu(order, customWaffle));
                    ConsoleUtilities.clearScreen("Adding...");
                }
                case '2' -> {
                    customWaffle.setWaffleSize(handleCustomWaffleSizeMenu(order, customWaffle));
                    ConsoleUtilities.clearScreen("Adding...");
                }
                case '3' -> {
                    customWaffle.setFillFlavor(handleCustomWaffleFillFlavorMenu(order, customWaffle));
                    ConsoleUtilities.clearScreen("Adding...");
                }
                case '4' -> {
                    customWaffle.getToppings().addAll(handleCustomWaffleToppingsMenu());
                    ConsoleUtilities.clearScreen("Adding...");
                }
                case '5' -> handleToppingRemovalMenu(customWaffle);
                case 'C' -> {
                    order.addProduct(customWaffle);
                    ConsoleUtilities.clearScreen("Adding...");
                    onCustomWaffleMenu = false;
                }
                case 'X' -> {
                    ConsoleUtilities.clearScreen("Exiting custom waffle menu...");
                    onCustomWaffleMenu = false;
                }
            }
        }
        return onCustomWaffleMenu;
    }

    // Method returns waffle type based on user input
    private WaffleType handleCustomWaffleTypeMenu(Order order, Waffle waffle) {
        ConsoleUtilities.clearScreen("Loading Custom Waffle Type Menu...");
        Menus.customWaffleTypeMenu();
        char choice = UserInput.promptForChar("What would you like to do? ", "12345X");
        if (choice == 'X') return waffle.getType();
        WaffleType selected = switch (choice) {
            case '1' -> WaffleType.BUTTER_MILK;
            case '2' -> WaffleType.BELGIAN;
            case '3' -> WaffleType.LIEGE;
            case '4' -> WaffleType.CHURRO;
            case '5' -> WaffleType.RED_VELVET;
            default -> null;
        };
        if (selected == null) return handleCustomWaffleTypeMenu(order, waffle);
        if (waffleTypeRepository.findByWaffleTypeAndIsAvailable(selected, true).isPresent()) {
            return selected;
        }
        System.out.println(ConsoleUtilities.DANGER + "Sorry, that waffle type is unavailable." + ConsoleUtilities.RESET);
        return waffle.getType();
    }

    // Method returns waffle size based on user input
    private WaffleSize handleCustomWaffleSizeMenu(Order order, Waffle waffle) {
        ConsoleUtilities.clearScreen("Loading Custom Waffle Size Menu...");
        Menus.customWaffleSizeMenu();
        char choice = UserInput.promptForChar("What would you like to do? ", "123X");
        if (choice == 'X') return waffle.getSize();
        WaffleSize selected = switch (choice) {
            case '1' -> WaffleSize.MINI;
            case '2' -> WaffleSize.REGULAR;
            case '3' -> WaffleSize.LARGE;
            default -> null;
        };
        if (selected == null) return handleCustomWaffleSizeMenu(order, waffle);
        if (waffleSizeRepository.findByWaffleSizeAndIsAvailable(selected, true).isPresent()) {
            return selected;
        }
        System.out.println(ConsoleUtilities.DANGER + "Sorry, that waffle size is unavailable." + ConsoleUtilities.RESET);
        return waffle.getSize();
    }

    // Method to handle creating a custom waffle
    private FillFlavor handleCustomWaffleFillFlavorMenu(Order order, Waffle waffle) {
        ConsoleUtilities.clearScreen("Loading Custom Waffle Fill Flavor Menu...");
        Menus.customWaffleFillingMenu();
        char choice = UserInput.promptForChar("What type of filling do you want? ", "12345X");
        FillFlavor selected = switch (choice) {
            case '1' -> FillFlavor.NONE;
            case '2' -> FillFlavor.NUTELLA;
            case '3' -> FillFlavor.CREAM_CHEESE;
            case '4' -> FillFlavor.JAM;
            case '5' -> FillFlavor.STRAWBERRY;
            case 'X' -> waffle.getFilling();
            default -> null;
        };
        if (selected == null) return handleCustomWaffleFillFlavorMenu(order, waffle);
        if (selected == FillFlavor.NONE) return selected;
        if (fillFlavorRepository.findByFillFlavorAndIsAvailable(selected, true).isPresent()) {
            return selected;
        }
        System.out.println(ConsoleUtilities.DANGER + "Sorry, that filling is unavailable." + ConsoleUtilities.RESET);
        return waffle.getFilling();
    }

    // Method allow users to select toppings to add to a custom waffle
    private List<Topping> handleCustomWaffleToppingsMenu() {
        ConsoleUtilities.clearScreen("Loading Custom Waffle Toppings Menu...");
        boolean onCustomWaffleToppingsMenu = true;
        ArrayList<Topping> toppings = new ArrayList<>();
        String[] validMenuOptions = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "D"};
        while (onCustomWaffleToppingsMenu) {
            Menus.customWaffleToppingsMenu(toppings);
            switch (UserInput.promptForString("What toppings would you like? ", validMenuOptions).toUpperCase()) {
                case "1" -> addToppingToList(toppings, ToppingName.WHIPPED_CREAM);
                case "2" -> addToppingToList(toppings, ToppingName.POWDERED_SUGAR);
                case "3" -> addToppingToList(toppings, ToppingName.MAPLE_SYRUP);
                case "4" -> addToppingToList(toppings, ToppingName.CINNAMON);
                case "5" -> addToppingToList(toppings, ToppingName.BUTTER);
                case "6" -> addToppingToList(toppings, ToppingName.CARAMEL_DRIZZLE);
                case "7" -> addToppingToList(toppings, ToppingName.NUTELLA);
                case "8" -> addToppingToList(toppings, ToppingName.FRESH_STRAWBERRIES);
                case "9" -> addToppingToList(toppings, ToppingName.BACON_CRUMBLES);
                case "10" -> addToppingToList(toppings, ToppingName.ICE_CREAM);
                case "11" -> addToppingToList(toppings, ToppingName.FRESH_BLUEBERRIES);
                case "12" -> addToppingToList(toppings, ToppingName.COOKIE_BUTTER);
                case "D" -> onCustomWaffleToppingsMenu = false;
            }
        }
        return toppings;
    }

    // Helper method to add a topping to custom waffles list of toppings
    private void addToppingToList(List<Topping> toppings, ToppingName toppingName) {
        ConsoleUtilities.clearScreen("Adding " + toppingName.getLabel() + " topping to custom waffle...");
        toppingRepository.findByNameAndIsAvailable(toppingName, true)
                .ifPresentOrElse(
                        toppings::add,
                        () -> System.out.println(ConsoleUtilities.DANGER + "Sorry, that topping is unavailable." + ConsoleUtilities.RESET)
                );
    }

    // Method to handle removing toppings from a custom waffle
    private void handleToppingRemovalMenu(Waffle waffle) {
        ConsoleUtilities.clearScreen("Loading Topping Removal Menu...");
        boolean onToppingRemovalMenu = true;
        while (onToppingRemovalMenu) {
            Menus.removeToppingMenu(waffle.getToppings());
            char chosenTopping = UserInput.promptForChar("Would you like to remove a topping? ");

            if (chosenTopping == 'X') {
                ConsoleUtilities.clearScreen("Exiting topping removal menu...");
                onToppingRemovalMenu = false;
            } else if (Character.isDigit(chosenTopping) && Character.getNumericValue(chosenTopping) <= waffle.getToppings().size()) {
                ConsoleUtilities.clearScreen("Removing " + waffle.getToppings().get(Character.getNumericValue(chosenTopping) - 1).getLabel() + " topping from custom waffle...");
                waffle.getToppings().remove(Character.getNumericValue(chosenTopping) - 1);
            } else {
                System.out.println(ConsoleUtilities.DANGER + "Invalid choice." + ConsoleUtilities.RESET);
            }
        }
    }

    // Method to select drink type based on user input
    private void handleDrinkMenu(Order order) {
        ConsoleUtilities.clearScreen("Loading Drink Menu...");
        boolean onDrinkMenu = true;
        while (onDrinkMenu) {
            Menus.drinkMenu();
            switch (UserInput.promptForChar("What would you like to do? ", "123456X")) {
                case '1' -> {
                    addDrinkToOrder(order, DrinkFlavor.COFFEE);
                    onDrinkMenu = false;
                }
                case '2' -> {
                    addDrinkToOrder(order, DrinkFlavor.OJ);
                    onDrinkMenu = false;
                }
                case '3' -> {
                    addDrinkToOrder(order, DrinkFlavor.MILK);
                    onDrinkMenu = false;
                }
                case '4' -> {
                    addDrinkToOrder(order, DrinkFlavor.LEMONADE);
                    onDrinkMenu = false;
                }
                case '5' -> {
                    addDrinkToOrder(order, DrinkFlavor.APPLE_JUICE);
                    onDrinkMenu = false;
                }
                case '6' -> {
                    addDrinkToOrder(order, DrinkFlavor.CRANBERRY_JUICE);
                    onDrinkMenu = false;
                }
                case 'X' -> onDrinkMenu = false;
            }
        }
    }

    // Method to select drink size based on user input
    private DrinkSize handleDrinkSize() {
        ConsoleUtilities.clearScreen("Loading Drink Size Menu...");
        Menus.drinkSizeMenu();
        return switch (UserInput.promptForChar("What size drink do you want? ", "123X")) {
            case '1' -> DrinkSize.SMALL;
            case '2' -> DrinkSize.MEDIUM;
            case '3' -> DrinkSize.LARGE;
            case 'X' -> null;
            default -> handleDrinkSize();
        };
    }

    // Helper method to add a drink to an order
    private void addDrinkToOrder(Order order, DrinkFlavor flavor) {
        DrinkSize size = handleDrinkSize();
        ConsoleUtilities.clearScreen("Adding " + flavor.getLabel() + " " + size.getLabel() + " drink to order...");
        drinkRepository.findByFlavorAndSizeAndIsAvailable(flavor, size, true)
                .ifPresentOrElse(
                        order::addProduct,
                        () -> System.out.println(ConsoleUtilities.DANGER + "Sorry, that size is unavailable." + ConsoleUtilities.RESET)
                );
    }

    // Helper method to add a side to an order
    private void handleSideMenu(Order order) {
        ConsoleUtilities.clearScreen("Loading Side Menu...");
        boolean onSideMenu = true;
        while (onSideMenu) {
            Menus.sideMenu();
            switch (UserInput.promptForChar("What would you like to do? ", "1234X")) {
                case '1' -> {
                    addSideToOrder(order, SideType.HASH_BROWNS);
                    onSideMenu = false;
                }
                case '2' -> {
                    addSideToOrder(order, SideType.WAFFLE_FRIES);
                    onSideMenu = false;
                }
                case '3' -> {
                    addSideToOrder(order, SideType.BACON);
                    onSideMenu = false;
                }
                case '4' -> {
                    addSideToOrder(order, SideType.FRUIT_CUP);
                    onSideMenu = false;
                }
                case 'X' -> onSideMenu = false;
            }
        }
    }

    // Helper method to add a side to an order
    private void addSideToOrder(Order order, SideType sideType) {
        ConsoleUtilities.clearScreen("Adding " + sideType.getLabel() + " side to order...");
        sideRepository.findBySideTypeAndIsAvailable(sideType, true)
                .ifPresentOrElse(
                        order::addProduct,
                        () -> System.out.println(ConsoleUtilities.DANGER + "Sorry, that size is unavailable." + ConsoleUtilities.RESET)
                );
    }

    // Method displays the current order and allows the user to remove items from the order
    private void handleViewCurrentOrder(Order order) {
        ConsoleUtilities.clearScreen("Loading View Current Order Menu...");
        boolean onViewCurrentOrder = true;
        while (onViewCurrentOrder) {
            Menus.viewCurrentOrder(order);
            switch (UserInput.promptForChar("What would you like to do? ", "RX")) {
                case 'R' -> {
                    onViewCurrentOrder = false;
                    handleRemoveItemMenu(order);
                }
                case 'X' -> {
                    ConsoleUtilities.clearScreen("Returning...");
                    onViewCurrentOrder = false;
                }
            }
        }
    }

    // Method used to remove items from the order
    private void handleRemoveItemMenu(Order order) {
        ConsoleUtilities.clearScreen("Loading Remove Item Menu...");
        boolean onRemoveItemMenu = true;
        while (onRemoveItemMenu) {
            Menus.removeItemMenu(order);
            char chosenItem = UserInput.promptForChar("Would you like to remove a topping? ");

            if (chosenItem == 'X') {
                ConsoleUtilities.clearScreen("Exiting remove item menu...");
                onRemoveItemMenu = false;
            } else if (Character.isDigit(chosenItem) && Character.getNumericValue(chosenItem) <= order.getProducts().size()) {
                ConsoleUtilities.clearScreen("Removing...");
                order.getProducts().remove(Character.getNumericValue(chosenItem) - 1);
            } else {
                System.out.println(ConsoleUtilities.DANGER + "Invalid choice." + ConsoleUtilities.RESET);
                ConsoleUtilities.clearScreen("Loading...");
            }
        }
    }

    // Method handles the checkout menu
    private boolean handleCheckoutMenu(Order order) throws IOException {
        ConsoleUtilities.clearScreen("Loading Checkout Menu...");
        boolean onCheckoutMenu = true;
        while (onCheckoutMenu) {
            Menus.checkoutMenu(order);
            switch (UserInput.promptForChar("What would you like to do? ", "CBX")) {
                case 'C' -> {
                    if (order.getProducts().isEmpty()) {
                        System.out.println(ConsoleUtilities.DANGER + "Your order is empty." + ConsoleUtilities.RESET);
                        onCheckoutMenu = false;
                    } else {
                        printReceipt(order);
                        ConsoleUtilities.clearScreen("Processing your order...");
                        onCheckoutMenu = false;
                        boolean viewingMessage = true;
                        while (viewingMessage) {

                            if (UserInput.promptForChar("Your receipt number is " + ReceiptWriter.getCurrentOrderNumber() + "... \nPress X to exit ", "X") == 'X') {
                                viewingMessage = false;
                                ConsoleUtilities.clearScreen("Returning...");
                            }
                        }
                        return false;
                    }
                }
                case 'B' -> {
                    ConsoleUtilities.clearScreen("Returning to order menu...");
                    onCheckoutMenu = false;
                }
                case 'X' -> {
                    ConsoleUtilities.clearScreen("Saving order and exiting...");
                    onCheckoutMenu = false;
                    return false;
                }
            }
        }
        return true;
    }

    // Method prints the receipt to the console and updates the stock level in the database
    private void printReceipt(Order order) throws IOException {
        ReceiptWriter.writeReceipt(order);
        orderService.updateStock(order);
    }

}
