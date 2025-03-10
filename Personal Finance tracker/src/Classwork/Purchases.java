package Classwork;
import java.util.ArrayList;

public class Purchases {
    public ArrayList<Purchase> purchases;

    // Default constructor initializes the ArrayList
    public Purchases() {
        this.purchases = new ArrayList<>();
    }

    // Method to add a purchase to the list
    public void addPurchase(Purchase purchase) {
        purchases.add(purchase);
    }

    // Method to print all purchases
    public void printArray() {
        if (purchases.isEmpty()) {
            System.out.println("No purchases recorded.");
        } else {
            System.out.println("Purchase List:");
            for (Purchase p : purchases) {
                p.PrintInfo();
                System.out.println("------------------");
            }
        }
    }
}

