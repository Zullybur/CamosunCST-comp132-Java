package comp132lab02;

import java.util.Scanner;
/**
 * @author MattCasiro
 * @created Jan 20 2016
 * @purpose Calculate change due given user inputs of 
 *          product cost and payment amount
 */
public class CashRegister {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double purchasePrice;
        double paymentValue;
        double changeDue;
        int changeRemaining;
        int hundreds, fifties, twenties, tens, fives;
        int toonies, loonies, quarters;
        
        // Get purchase price under $1000 from user
        System.out.println("Please enter a product price under $1000:");
        Scanner sc1 = new Scanner(System.in);
        purchasePrice = sc1.nextDouble();
        
        // Get payment amount from user
        System.out.println("\nPlease enter your payment amount up to $1000:");
        Scanner sc2 = new Scanner(System.in);
        paymentValue = sc2.nextDouble();

        // Calculate change amount
        changeDue = paymentValue - purchasePrice;
        changeRemaining = (int)(Math.round(changeDue * 100));
        hundreds = changeRemaining / 10000;
        changeRemaining = changeRemaining % 10000;
        fifties = changeRemaining / 5000;
        changeRemaining = changeRemaining % 5000;
        twenties = changeRemaining / 2000;
        changeRemaining = changeRemaining % 2000;
        tens = changeRemaining / 1000;
        changeRemaining = changeRemaining % 1000;
        fives = changeRemaining / 500;
        changeRemaining = changeRemaining % 500;
        toonies = changeRemaining / 200;
        changeRemaining = changeRemaining % 200;
        loonies = changeRemaining / 100;
        changeRemaining = changeRemaining % 100;
        quarters = changeRemaining / 25;
        changeRemaining = changeRemaining % 25;
        
        // Output change amount
        System.out.println("\nChange Due: $" +  Math.round(changeDue) +"\n\n"
                + "\t$100: " + hundreds + "\n"
                + "\t$50: " + fifties + "\n"
                + "\t$20: " + twenties + "\n"
                + "\t$10: " + tens + "\n"
                + "\t$5: " + fives + "\n"
                + "\t$2: " + toonies + "\n"
                + "\t$1: " + loonies + "\n"
                + "\t$.25: " + quarters);
    }
}
