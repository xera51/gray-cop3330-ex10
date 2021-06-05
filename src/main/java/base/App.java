/*
 *  UCF COP3330 Summer 2021 Exercise 10 Solution
 *  Copyright 2021 Christopher Gray
 */
package base;

import java.util.Scanner;

public class App {

    static Scanner in = new Scanner(System.in);
    static final int NUM_ITEMS = 3;
    static final double TAX_RATE = 0.055;

    public static void main(String[] args) {
        App myApp = new App();

        double[] itemPrices = new double[NUM_ITEMS];
        double[] itemQuantities = new double[NUM_ITEMS];

        for(int i = 0; i < NUM_ITEMS; i++) {
            itemPrices[i] = myApp.readItemPrice(i+1);
            itemQuantities[i] = myApp.readItemQuantity(i+1);
        }

        double subtotal = myApp.calculateSubtotal(itemPrices, itemQuantities);
        double tax = myApp.calculateTax(subtotal);
        double total = myApp.calculateTotal(subtotal, tax);

        String output = myApp.generateOutputString(subtotal, tax, total);
        myApp.displayOutput(output);
    }

    private double readItemPrice(int itemNumber) {
        System.out.printf("Enter the price of item %d: ", itemNumber);
        return Double.parseDouble(in.nextLine());
    }

    private double readItemQuantity(int itemNumber) {
        System.out.printf("Enter the quantity of item %d: ", itemNumber);
        return Double.parseDouble(in.nextLine());
    }

    // itemPrices and itemQuantities should be the same length
    private double calculateSubtotal(double[] itemPrices, double[] itemQuantities) {
        double subtotal = 0;

        for(int i = 0; i < itemPrices.length; i++) {
            subtotal += itemPrices[i] * itemQuantities[i];
        }

        return subtotal;
    }

    private double calculateTax(double subtotal) { return subtotal * TAX_RATE; }

    private double calculateTotal(double subtotal, double tax) {
        return subtotal + tax;
    }

    public String generateOutputString(double subtotal, double tax, double total) {
        return String.format("Subtotal: $%.2f%nTax: $%.2f%nTotal: $%.2f",
                subtotal, tax, total);
    }

    public void displayOutput(String output) { System.out.println(output); }

}
