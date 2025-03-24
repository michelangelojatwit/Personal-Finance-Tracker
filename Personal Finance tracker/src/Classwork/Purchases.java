package Classwork;
import java.util.ArrayList;

public class Purchases {
    public ArrayList<Purchase> purchases;

    public Purchases() {
        this.purchases = new ArrayList<>();
    }

    public void addPurchase(Purchase purchase) {
        purchases.add(purchase);
    }

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

    // Needed for GUI ( Before changing this at all, make sure you read up on the JavaFX guide in the group chat) - Joe M
    public ArrayList<String> getAllPurchases() {
        ArrayList<String> names = new ArrayList<>();
        for (Purchase p : purchases) {
            names.add(p.getpName());
        }
        return names;
    }

    public void removePurchase(String name) {
        purchases.removeIf(p -> p.getpName().equalsIgnoreCase(name));
    }

    public void editPurchase(String oldName, String newName) {
        for (Purchase p : purchases) {
            if (p.getpName().equalsIgnoreCase(oldName)) {
                p.setpName(newName);
                break;
            }
        }
    }
    public String getPurchaseReport() {
        if (purchases.isEmpty()) return "No purchases recorded.\n";

        StringBuilder sb = new StringBuilder();
        for (Purchase p : purchases) {
            sb.append("• ").append(p.getpName()).append("\n");
        }
        return sb.toString();
    }
}
