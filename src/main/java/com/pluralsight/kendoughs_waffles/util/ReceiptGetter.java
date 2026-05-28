package com.pluralsight.kendoughs_waffles.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReceiptGetter {

    public static List<String> getReceipt(String path) throws FileNotFoundException {
        ArrayList<String> receipt = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader("receipts/" + path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                receipt.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading receipt file.");
        }

        return receipt;
    }
}
