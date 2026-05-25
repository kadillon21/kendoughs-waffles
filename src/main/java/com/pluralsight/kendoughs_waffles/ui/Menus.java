package com.pluralsight.kendoughs_waffles.ui;

import com.pluralsight.kendoughs_waffles.models.Order;
import com.pluralsight.kendoughs_waffles.models.enums.FillFlavor;
import com.pluralsight.kendoughs_waffles.models.enums.ToppingName;
import com.pluralsight.kendoughs_waffles.models.enums.WaffleSize;
import com.pluralsight.kendoughs_waffles.models.enums.WaffleType;
import com.pluralsight.kendoughs_waffles.models.products.Drink;
import com.pluralsight.kendoughs_waffles.models.products.Product;
import com.pluralsight.kendoughs_waffles.models.products.Side;
import com.pluralsight.kendoughs_waffles.models.products.Topping;
import com.pluralsight.kendoughs_waffles.util.ConsoleUtilities;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.List;

public class Menus {
    private static final String B = ConsoleUtilities.BORDER;
    private static final String A = ConsoleUtilities.ACCENT;
    private static final String Bo = ConsoleUtilities.BOLD;
    private static final String U = ConsoleUtilities.UNDERLINE;
    private static final String R = ConsoleUtilities.RESET;

    public static void mainMenu() {

        System.out.println();
        System.out.println(B + "╔═════════════════════════════════╗");
        System.out.println(B + "║" + Bo + U + R + "  Welcome to Ken-dough's Waffle  " + R + B + "║");
        System.out.println(B + "╠═════════════════════════════════╣");
        System.out.println(B + "║                                 ║");
        System.out.println(B + "║  " + A + "1" + R + ")  New Order                  " + B + "║");
        System.out.println(B + "║  " + A + "2" + R + ")  Previous Orders            " + B + "║");
        System.out.println(B + "║  " + A + "3" + R + ")  Menu Items                 " + B + "║");
        System.out.println(B + "║  " + A + "4" + R + ")  About Us                   " + B + "║");
        System.out.println(B + "║  " + A + "X" + R + ")  Exit                       " + B + "║");
        System.out.println(B + "║                                 ║");
        System.out.println(B + "╚═════════════════════════════════╝" + R);
    }

    public static void orderMenu() {

        System.out.println();
        System.out.println(B + "╔═════════════════════════════════╗");
        System.out.println(B + "║" + Bo + U + R + "           Your Order            " + R + B + "║");
        System.out.println(B + "╠═════════════════════════════════╣");
        System.out.println(B + "║                                 ║");
        System.out.println(B + "║  " + A + "1" + R + ")  Add Waffle                 " + B + "║");
        System.out.println(B + "║  " + A + "2" + R + ")  Add Drink                  " + B + "║");
        System.out.println(B + "║  " + A + "3" + R + ")  Add Side                   " + B + "║");
        System.out.println(B + "║  " + A + "4" + R + ")  View Current Order         " + B + "║");
        System.out.println(B + "║  " + A + "5" + R + ")  Remove Item                " + B + "║");
        System.out.println(B + "║  " + A + "6" + R + ")  Checkout                   " + B + "║");
        System.out.println(B + "║  " + A + "X" + R + ")  Cancel Order               " + B + "║");
        System.out.println(B + "║                                 ║");
        System.out.println(B + "╚═════════════════════════════════╝" + R);
    }

    public static void waffleMenu() {
        System.out.println();
        System.out.println(B + "╔═════════════════════════════════╗");
        System.out.println(B + "║" + Bo + U + R + "          Waffle Menu            " + R + B + "║");
        System.out.println(B + "╠═════════════════════════════════╣");
        System.out.println(B + "║                                 ║");
        System.out.println(B + "║  " + A + "1" + R + ")  Build your own Waffle      " + B + "║");
        System.out.println(B + "║  " + A + "2" + R + ")  Signature waffles          " + B + "║");
        System.out.println(B + "║  " + A + "3" + R + ")  Daily special              " + B + "║");
        System.out.println(B + "║  " + A + "X" + R + ")  Go back                    " + B + "║");
        System.out.println(B + "║                                 ║");
        System.out.println(B + "╚═════════════════════════════════╝" + R);
    }

    public static void customWaffleMenu(WaffleType type, WaffleSize size, FillFlavor filling, List<Topping> toppings) {

        String typeDisplay    = type != null ? type.getLabel()           : "---";
        String sizeDisplay    = size != null ? size.getLabel()           : "---";

        System.out.println();
        System.out.println(B + "╔═════════════════════════════════╗");
        System.out.println(B + "║" + Bo + U + R + "       Build Your Waffle         " + R + B + "║");
        System.out.println(B + "╠═════════════════════════════════╣");
        System.out.println(B + "║                                 ║");
        System.out.println(B + "║  " + Bo + A + "Type:    " + R + typeDisplay + R + "                    " + B + "║");
        System.out.println(B + "║  " + Bo + A + "Size:    " + R + sizeDisplay + R + "                    " + B + "║");
        System.out.println(B + "║  " + Bo + A + "Filling:    " + R + filling.label + R + "                    " + B + "║");
        System.out.println(B + "║  " + Bo + A + "Toppings:" + R + "                        " + B + "║");
        for (Topping topping : toppings){
            System.out.println(B + "║  " + R + "\t" + topping.getLabel() + "         " + topping.getPrice() + B + "          ║");
        }
        System.out.println(B + "║                                 ║");
        System.out.println(B + "╠═════════════════════════════════╣");
        System.out.println(B + "║                                 ║");
        System.out.println(B + "║  " + A + "1" + R + ")  Edit Waffle Type           " + B + "║");
        System.out.println(B + "║  " + A + "2" + R + ")  Edit Size                  " + B + "║");
        System.out.println(B + "║  " + A + "3" + R + ")  Edit Filling               " + B + "║");
        System.out.println(B + "║  " + A + "4" + R + ")  Add Toppings               " + B + "║");
        System.out.println(B + "║  " + A + "5" + R + ")  Remove Toppings            " + B + "║");
        System.out.println(B + "║  " + A + "C" + R + ")  Confirm Waffle             " + B + "║");
        System.out.println(B + "║  " + A + "X" + R + ")  Go Back                    " + B + "║");
        System.out.println(B + "║                                 ║");
        System.out.println(B + "╚═════════════════════════════════╝" + R);
    }

    public static void customWaffleTypeMenu() {
        System.out.println();
        System.out.println(B + "╔═════════════════════════════════╗");
        System.out.println(B + "║" + Bo + U + R + "        Choose Your Type         " + R + B + "║");
        System.out.println(B + "╠═════════════════════════════════╣");
        System.out.println(B + "║                                 ║");
        System.out.println(B + "║  " + A + "1" + R + ")  Butter Milk      " + A + "$4.99" + R + "       " + B + "║");
        System.out.println(B + "║  " + A + "2" + R + ")  Belgian          " + A + "$5.49" + R + "       " + B + "║");
        System.out.println(B + "║  " + A + "3" + R + ")  Liege            " + A + "$5.99" + R + "       " + B + "║");
        System.out.println(B + "║  " + A + "4" + R + ")  Churro           " + A + "$5.99" + R + "       " + B + "║");
        System.out.println(B + "║  " + A + "5" + R + ")  Red Velvet       " + A + "$6.49" + R + "       " + B + "║");
        System.out.println(B + "║                                 ║");
        System.out.println(B + "║  " + A + "X" + R + ")  Go Back                    " + B + "║");
        System.out.println(B + "║                                 ║");
        System.out.println(B + "╚═════════════════════════════════╝" + R);
    }

    public static void customWaffleSizeMenu() {
        System.out.println();
        System.out.println(B + "╔═════════════════════════════════╗");
        System.out.println(B + "║" + Bo + U + R + "        Choose Your Size         " + R + B + "║");
        System.out.println(B + "╠═════════════════════════════════╣");
        System.out.println(B + "║                                 ║");
        System.out.println(B + "║  " + A + "1" + R + ")  Mini             " + A + "+$0.00" + R + "      " + B + "║");
        System.out.println(B + "║  " + A + "2" + R + ")  Regular          " + A + "+$1.50" + R + "      " + B + "║");
        System.out.println(B + "║  " + A + "3" + R + ")  Large            " + A + "+$3.00" + R + "      " + B + "║");
        System.out.println(B + "║                                 ║");
        System.out.println(B + "║  " + A + "X" + R + ")  Go Back                    " + B + "║");
        System.out.println(B + "║                                 ║");
        System.out.println(B + "╚═════════════════════════════════╝" + R);
    }

    public static void customWaffleFillingMenu(){
        System.out.println();
        System.out.println(B + "╔═════════════════════════════════╗");
        System.out.println(B + "║" + Bo + U + R + "        Choose Your Filling      " + R + B + "║");
        System.out.println(B + "╠═════════════════════════════════╣");
        System.out.println(B + "║                                 ║");
        System.out.println(B + "║  " + A + "1" + R + ")  None             " + A + "+$0.00" + R + "    " + B + "║");
        System.out.println(B + "║  " + A + "2" + R + ")  Nutella          " + A + "+$1.00" + R + "    " + B + "║");
        System.out.println(B + "║  " + A + "3" + R + ")  Cream Cheese     " + A + "+$1.00" + R + "    " + B + "║");
        System.out.println(B + "║  " + A + "4" + R + ")  Strawberry Jam   " + A + "+$1.00" + R + "    " + B + "║");
        System.out.println(B + "║  " + A + "5" + R + ")  Strawberry       " + A + "+$1.00" + R + "    " + B + "║");
        System.out.println(B + "║                                 ║");
        System.out.println(B + "║  " + A + "X" + R + ")  Go Back                    " + B + "║");
        System.out.println(B + "║                                 ║");
        System.out.println(B + "╚═════════════════════════════════╝" + R);
    }

    public static void customWaffleToppingsMenu(List<Topping> selected) {

        System.out.println();
        System.out.println(B + "╔═════════════════════════════════╗");
        System.out.println(B + "║" + Bo + U + R + "       Choose Toppings           " + R + B + "║");
        System.out.println(B + "╠═════════════════════════════════╣");
        System.out.println(B + "║                                 ║");
        System.out.println(B + "║  " + Bo + A + "Regular" + R + "  " + A + "+$0.50 each" + R + "          " + B + "║");
        System.out.println(B + "║  " + mark(selected, ToppingName.WHIPPED_CREAM)   + A + "1"  + R + ")  Whipped Cream              " + B + "║");
        System.out.println(B + "║  " + mark(selected, ToppingName.POWDERED_SUGAR)  + A + "2"  + R + ")  Powdered Sugar             " + B + "║");
        System.out.println(B + "║  " + mark(selected, ToppingName.MAPLE_SYRUP)     + A + "3"  + R + ")  Maple Syrup                " + B + "║");
        System.out.println(B + "║  " + mark(selected, ToppingName.CINNAMON)        + A + "4"  + R + ")  Cinnamon                   " + B + "║");
        System.out.println(B + "║  " + mark(selected, ToppingName.BUTTER)          + A + "5"  + R + ")  Butter                     " + B + "║");
        System.out.println(B + "║  " + mark(selected, ToppingName.CARAMEL_DRIZZLE) + A + "6"  + R + ")  Caramel Drizzle            " + B + "║");
        System.out.println(B + "║                                 ║");
        System.out.println(B + "║  " + Bo + A + "Premium" + R + "  " + A + "+$1.00 each" + R + "          " + B + "║");
        System.out.println(B + "║  " + mark(selected, ToppingName.NUTELLA)             + A + "7"  + R + ")  Nutella                    " + B + "║");
        System.out.println(B + "║  " + mark(selected, ToppingName.FRESH_STRAWBERRIES)  + A + "8"  + R + ")  Fresh Strawberries         " + B + "║");
        System.out.println(B + "║  " + mark(selected, ToppingName.BACON_CRUMBLES)      + A + "9"  + R + ")  Bacon Crumbles             " + B + "║");
        System.out.println(B + "║  " + mark(selected, ToppingName.ICE_CREAM)           + A + "10" + R + ") Ice Cream                  " + B + "║");
        System.out.println(B + "║  " + mark(selected, ToppingName.FRESH_BLUEBERRIES)   + A + "11" + R + ") Fresh Blueberries          " + B + "║");
        System.out.println(B + "║  " + mark(selected, ToppingName.COOKIE_BUTTER)       + A + "12" + R + ") Cookie Butter              " + B + "║");
        System.out.println(B + "║                                 ║");
        System.out.println(B + "║  " + A + "D" + R + ")  Done selecting             " + B + "║");
        System.out.println(B + "║                                 ║");
        System.out.println(B + "╚═════════════════════════════════╝" + R);
    }

    private static String mark(List<Topping> selected, ToppingName name) {
        return selected.stream()
                .anyMatch(t -> t.getLabel().equals(name.getLabel()))
                ? A + "✔ " + R
                : "  ";
    }

    public static void removeToppingMenu(List<Topping> selected) {
        System.out.println();
        System.out.println(B + "╔═════════════════════════════════╗");
        System.out.println(B + "║" + Bo + U + R + "       Remove a Topping          " + R + B + "║");
        System.out.println(B + "╠═════════════════════════════════╣");
        System.out.println(B + "║                                 ║");

        if (selected.isEmpty()) {
            System.out.println(B + "║  No toppings added yet.         " + B + "║");
        } else {
            for (int i = 0; i < selected.size(); i++) {
                String label = String.valueOf(selected.get(i).getLabel());
                String line = String.format("%-29s", "  " + A + (i + 1) + R + ")  " + label);
                System.out.println(B + "║" + line + B + "║");
            }
        }

        System.out.println(B + "║                                 ║");
        System.out.println(B + "║  " + A + "X" + R + ")  Go Back                    " + B + "║");
        System.out.println(B + "║                                 ║");
        System.out.println(B + "╚═════════════════════════════════╝" + R);
    }

    public static void drinkMenu() {
        System.out.println();
        System.out.println(B + "╔═════════════════════════════════╗");
        System.out.println(B + "║" + Bo + U + R + "           Drink Menu            " + R + B + "║");
        System.out.println(B + "╠═════════════════════════════════╣");
        System.out.println(B + "║                                 ║");
        System.out.println(B + "║  " + A + "1" + R + ")  Coffee           " + A + "$2.99" + R + "       " + B + "║");
        System.out.println(B + "║  " + A + "2" + R + ")  Orange Juice     " + A + "$2.99" + R + "       " + B + "║");
        System.out.println(B + "║  " + A + "3" + R + ")  Milk             " + A + "$1.99" + R + "       " + B + "║");
        System.out.println(B + "║  " + A + "4" + R + ")  Lemonade         " + A + "$2.49" + R + "       " + B + "║");
        System.out.println(B + "║  " + A + "5" + R + ")  Apple Juice      " + A + "$2.49" + R + "       " + B + "║");
        System.out.println(B + "║  " + A + "6" + R + ")  Cranberry Juice  " + A + "$2.49" + R + "       " + B + "║");
        System.out.println(B + "║  " + A + "X" + R + ")  Go Back                    " + B + "║");
        System.out.println(B + "║                                 ║");
        System.out.println(B + "╚═════════════════════════════════╝" + R);
    }

    public static void drinkSizeMenu() {
        System.out.println();
        System.out.println(B + "╔═════════════════════════════════╗");
        System.out.println(B + "║" + Bo + U + R + "        Choose Your Size         " + R + B + "║");
        System.out.println(B + "╠═════════════════════════════════╣");
        System.out.println(B + "║                                 ║");
        System.out.println(B + "║  " + A + "1" + R + ")  Small            " + A + "$2.00" + R + "      " + B + "║");
        System.out.println(B + "║  " + A + "2" + R + ")  Medium           " + A + "$2.50" + R + "      " + B + "║");
        System.out.println(B + "║  " + A + "3" + R + ")  Large            " + A + "$3.00" + R + "      " + B + "║");
        System.out.println(B + "║                                 ║");
        System.out.println(B + "║  " + A + "X" + R + ")  Go Back                    " + B + "║");
        System.out.println(B + "║                                 ║");
        System.out.println(B + "╚═════════════════════════════════╝" + R);
    }

    public static void sideMenu() {
        System.out.println();
        System.out.println(B + "╔═════════════════════════════════╗");
        System.out.println(B + "║" + Bo + U + R + "            Side Menu            " + R + B + "║");
        System.out.println(B + "╠═════════════════════════════════╣");
        System.out.println(B + "║                                 ║");
        System.out.println(B + "║  " + A + "1" + R + ")  Hash Browns      " + A + "$2.99" + R + "       " + B + "║");
        System.out.println(B + "║  " + A + "2" + R + ")  Waffle Fries     " + A + "$3.49" + R + "       " + B + "║");
        System.out.println(B + "║  " + A + "3" + R + ")  Bacon            " + A + "$2.49" + R + "       " + B + "║");
        System.out.println(B + "║  " + A + "4" + R + ")  Fruit Cup        " + A + "$2.99" + R + "       " + B + "║");
        System.out.println(B + "║  " + A + "X" + R + ")  Go Back                    " + B + "║");
        System.out.println(B + "║                                 ║");
        System.out.println(B + "╚═════════════════════════════════╝" + R);
    }

    public static void checkoutMenu(Order order) {
        List<Product> products = order.getProducts();
        System.out.println();
        System.out.println(B + "╔═══════════════════════════════════════════╗");
        System.out.println(B + "║" + Bo + U + R + "              Order Summary                " + R + B + "║");
        System.out.println(B + "╠═══════════════════════════════════════════╣");
        System.out.println(B + "║                                           ║");

        for (Product product : products){
            System.out.println(B + "║  " + R + product.getName() + " - $" + product.getPrice() + B + "          ║");
        }
        System.out.println(B + "║                                           ║");
        System.out.println(B + "║  " + A + "1" + R + ")  Confirm Order                        " + B + "║");
        System.out.println(B + "║  " + A + "X" + R + ")  Cancel Order                         " + B + "║");
        System.out.println(B + "║                                           ║");
        System.out.println(B + "╚═══════════════════════════════════════════╝" + R);
    }

    public static void displayAboutUs() {
        System.out.println(
                """
                About Us
                At Ken-dough's Waffles, we keep it simple — great waffles, good vibes, and no reason to be anywhere else. 
                Every waffle we make is crispy on the outside, fluffy on the inside, and loaded with the toppings you actually want.
                We started Ken-dough's because we believed the world needed a waffle spot that felt like home — warm, no-fuss, and always worth the trip. 
                Whether you're grabbing a quick bite or staying a while, we're just happy you're here.
                Come hungry. Leave happy. That's the Ken-dough's way.
                """
        );
    }

    public static void displayStoreMenu() {
        System.out.println();
        System.out.println(B + "╔══════════════════════════════════════════════╗");
        System.out.println(B + "║" + Bo + "             Ken-dough's Waffles              " + R + B + "║");
        System.out.println(B + "╠══════════════════════════════════════════════╣");

        // Waffle Types
        System.out.println(B + "║  " + Bo + U + A + "WAFFLE TYPES" + R + B + "                                ║");
        System.out.println(B + "╠══════════════════════════════════════════════╣");
        System.out.println(B + "║  " + R + "Classic                       " + A + "$4.99" + R + "         " + B + "║");
        System.out.println(B + "║  " + R + "Belgian                       " + A + "$5.49" + R + "         " + B + "║");
        System.out.println(B + "║  " + R + "Liege                         " + A + "$5.99" + R + "         " + B + "║");
        System.out.println(B + "║  " + R + "Churro                        " + A + "$5.99" + R + "         " + B + "║");
        System.out.println(B + "║  " + R + "Red Velvet                    " + A + "$6.49" + R + "         " + B + "║");

        // Sizes
        System.out.println(B + "╠══════════════════════════════════════════════╣");
        System.out.println(B + "║  " + Bo + U + A + "SIZES" + R + B + "                                       ║");
        System.out.println(B + "╠══════════════════════════════════════════════╣");
        System.out.println(B + "║  " + R + "Mini                         " + A + "+$0.00" + R + "         " + B + "║");
        System.out.println(B + "║  " + R + "Regular                      " + A + "+$1.00" + R + "         " + B + "║");
        System.out.println(B + "║  " + R + "Large                        " + A + "+$2.00" + R + "         " + B + "║");

        // Regular Toppings
        System.out.println(B + "╠══════════════════════════════════════════════╣");
        System.out.println(B + "║  " + Bo + U + A + "REGULAR TOPPINGS" + R + "  " + A + "+$0.50 each" + R + B + "               ║");
        System.out.println(B + "╠══════════════════════════════════════════════╣");
        System.out.println(B + "║  " + R + "Whipped Cream  · Powdered Sugar  · Butter   " + B + "║");
        System.out.println(B + "║  " + R + "Maple Syrup    · Cinnamon  · Caramel Drizzle" + B + "║");

        // Premium Toppings
        System.out.println(B + "╠══════════════════════════════════════════════╣");
        System.out.println(B + "║  " + Bo + U + A + "PREMIUM TOPPINGS" + R + "  " + A + "+$1.00 each" + R + B + "               ║");
        System.out.println(B + "╠══════════════════════════════════════════════╣");
        System.out.println(B + "║  " + R + "Nutella          · Fresh Strawberries       " + B + "║");
        System.out.println(B + "║  " + R + "Bacon Crumbles   · Ice Cream                " + B + "║");
        System.out.println(B + "║  " + R + "Fresh Blueberries · Cookie Butter           " + B + "║");

        // Special Option
        System.out.println(B + "╠══════════════════════════════════════════════╣");
        System.out.println(B + "║  " + Bo + U + A + "SPECIAL OPTION" + R + B + "                              ║");
        System.out.println(B + "╠══════════════════════════════════════════════╣");
        System.out.println(B + "║  " + R + "Stuffed Waffle (choose your fill)  " + A + "+$1.50" + R + "   " + B + "║");

        // Drinks
        System.out.println(B + "╠══════════════════════════════════════════════╣");
        System.out.println(B + "║  " + Bo + U + A + "DRINKS" + R + B + "                                      ║");
        System.out.println(B + "╠══════════════════════════════════════════════╣");
        System.out.println(B + "║  " + R + "Coffee                        " + A + "$2.99" + R + "         " + B + "║");
        System.out.println(B + "║  " + R + "Orange Juice                  " + A + "$2.99" + R + "         " + B + "║");
        System.out.println(B + "║  " + R + "Milk                          " + A + "$1.99" + R + "         " + B + "║");
        System.out.println(B + "║  " + R + "Lemonade                      " + A + "$2.49" + R + "         " + B + "║");
        System.out.println(B + "║  " + R + "Apple Juice                   " + A + "$2.49" + R + "         " + B + "║");
        System.out.println(B + "║  " + R + "Cranberry Juice               " + A + "$2.49" + R + "         " + B + "║");

        // Sides
        System.out.println(B + "╠══════════════════════════════════════════════╣");
        System.out.println(B + "║  " + Bo + U + A + "SIDES" + R + B + "                                       ║");
        System.out.println(B + "╠══════════════════════════════════════════════╣");
        System.out.println(B + "║  " + R + "Hash Browns                   " + A + "$2.99" + R + "         " + B + "║");
        System.out.println(B + "║  " + R + "Waffle Fries                  " + A + "$3.49" + R + "         " + B + "║");
        System.out.println(B + "║  " + R + "Bacon                         " + A + "$2.49" + R + "         " + B + "║");
        System.out.println(B + "║  " + R + "Fruit Cup                     " + A + "$2.99" + R + "         " + B + "║");

        System.out.println(B + "╚══════════════════════════════════════════════╝" + R);
    }

    public static void removeItemMenu(Order order) {
        List<Product> products = order.getProducts();
        System.out.println();
        System.out.println(B + "╔═════════════════════════════════╗");
        System.out.println(B + "║" + Bo + U + R + "          Remove Item            " + R + B + "║");
        System.out.println(B + "╠═════════════════════════════════╣");
        System.out.println(B + "║                                 ║");
        System.out.println(B + "║  Enter the number of the item   " + B + "║");
        System.out.println(B + "║  you'd like to remove.          " + B + "║");
        for (Product product : products){
            System.out.println(B + "║  " + A + "1" + R + ") " + product.getName() + " - $" + product.getPrice() + B + "          ║");
        }
        System.out.println(B + "║                                 ║");
        System.out.println(B + "║  " + A + "X" + R + ")  Go Back                    " + B + "║");
        System.out.println(B + "║                                 ║");
        System.out.println(B + "╚═════════════════════════════════╝" + R);
    }

    public static void viewCurrentOrder(Order order) {
        List<Product> products = order.getProducts();
        System.out.println();
        System.out.println(B + "╔═════════════════════════════════╗");
        System.out.println(B + "║" + Bo + U + R + "         Current Order           " + R + B + "║");
        System.out.println(B + "╠═════════════════════════════════╣");
        System.out.println(B + "║                                 ║");
        for (Product product : products){
            System.out.println(B + "║  " + R + product.getName() + " - $" + product.getPrice() + B + "          ║");
        }
        System.out.println(B + "║                                 ║");
        System.out.println(B + "║  " + A + "R" + R + ")  Remove Item                " + B + "║");
        System.out.println(B + "║  " + A + "X" + R + ")  Go Back                    " + B + "║");
        System.out.println(B + "║                                 ║");
        System.out.println(B + "╚═════════════════════════════════╝" + R);
    }

    public static String getDailySpecial() {
        return switch (LocalDate.now().getDayOfWeek()) {
            case MONDAY, FRIDAY -> "The Classic Ken";
            case TUESDAY, SATURDAY -> "The Nutella Dream";
            case WEDNESDAY -> "The Sunrise";
            case THURSDAY, SUNDAY -> "The Red Royale";
        };
    }

    public static void dailySpecialMenu() {
        String special = getDailySpecial();
        System.out.println();
        System.out.println(B + "╔═════════════════════════════════╗");
        System.out.println(B + "║" + Bo + U + R + "          Daily Special          " + R + B + "║");
        System.out.println(B + "╠═════════════════════════════════╣");
        System.out.println(B + "║                                 ║");
        System.out.println(B + "║  " + R + "Today's special:               " + B + "║");
        System.out.println(B + "║  " + A + special + R + "             " + B + "║");
        System.out.println(B + "║                                 ║");
        System.out.println(B + "║  " + A + "1" + R + ")  Add to Order               " + B + "║");
        System.out.println(B + "║  " + A + "X" + R + ")  Go Back                    " + B + "║");
        System.out.println(B + "║                                 ║");
        System.out.println(B + "╚═════════════════════════════════╝" + R);
    }

    public static void signatureWaffleMenu() {
        System.out.println();
        System.out.println(B + "╔══════════════════════════════════════════════════════╗");
        System.out.println(B + "║" + Bo + U + R + "              Signature Waffles                       " + R + B + "║");
        System.out.println(B + "╠══════════════════════════════════════════════════════╣");
        System.out.println(B + "║                                                      ║");
        System.out.println(B + "║  " + A + "1" + R + ")  " + Bo + "The Classic Ken" + R + "                                 " + B + "║");
        System.out.println(B + "║     Type:     Buttermilk                             " + B + "║");
        System.out.println(B + "║     Toppings: Butter, Maple Syrup                    " + B + "║");
        System.out.println(B + "║     Special:  None                                   " + B + "║");
        System.out.println(B + "║                                                      ║");
        System.out.println(B + "║  " + A + "2" + R + ")  " + Bo + "The Nutella Dream" + R + "                               " + B + "║");
        System.out.println(B + "║     Type:     Belgian                                " + B + "║");
        System.out.println(B + "║     Toppings: Nutella, Fresh Strawberries,           " + B + "║");
        System.out.println(B + "║               Whipped Cream                          " + B + "║");
        System.out.println(B + "║     Special:  " + A + "Stuffed (Nutella)" + R + "                      " + B + "║");
        System.out.println(B + "║                                                      ║");
        System.out.println(B + "║  " + A + "3" + R + ")  " + Bo + "The Sunrise" + R + "                                     " + B + "║");
        System.out.println(B + "║     Type:     Churro                                 " + B + "║");
        System.out.println(B + "║     Toppings: Bacon Crumbles, Maple Syrup,           " + B + "║");
        System.out.println(B + "║               Powdered Sugar                         " + B + "║");
        System.out.println(B + "║     Special:  None                                   " + B + "║");
        System.out.println(B + "║                                                      ║");
        System.out.println(B + "║  " + A + "4" + R + ")  " + Bo + "The Red Royale" + R + "                                  " + B + "║");
        System.out.println(B + "║     Type:     Red Velvet                             " + B + "║");
        System.out.println(B + "║     Toppings: Ice Cream, Fresh Blueberries,          " + B + "║");
        System.out.println(B + "║               Cookie Butter                          " + B + "║");
        System.out.println(B + "║     Special:  " + A + "Stuffed (Cream Cheese)" + R + "                 " + B + "║");
        System.out.println(B + "║                                                      ║");
        System.out.println(B + "║  " + A + "X" + R + ")  Go Back                                         " + B + "║");
        System.out.println(B + "║                                                      ║");
        System.out.println(B + "╚══════════════════════════════════════════════════════╝" + R);
    }
}