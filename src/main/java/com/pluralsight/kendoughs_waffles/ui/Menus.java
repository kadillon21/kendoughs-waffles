package com.pluralsight.kendoughs_waffles.ui;

import com.pluralsight.kendoughs_waffles.util.ConsoleUtilities;

public class Menus {

    public static void mainMenu() {
        String B = ConsoleUtilities.BORDER;
        String A = ConsoleUtilities.ACCENT;
        String Bo = ConsoleUtilities.BOLD;
        String U = ConsoleUtilities.UNDERLINE;
        String R = ConsoleUtilities.RESET;

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
        String B = ConsoleUtilities.BORDER;
        String A = ConsoleUtilities.ACCENT;
        String Bo = ConsoleUtilities.BOLD;
        String U = ConsoleUtilities.UNDERLINE;
        String R = ConsoleUtilities.RESET;

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

    public static void displayAboutUs() {
    }

    public static void displayStoreMenu() {
    }
}
