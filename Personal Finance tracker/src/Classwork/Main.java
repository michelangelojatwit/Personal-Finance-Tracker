package Classwork;

public class Main {
	// Main method for testing ( Use this for anything needing testing, revert it back when finished) -Joe M
    public static void main(String[] args) {
        // Creating purchases object and adding purchases (Change however you would like on these values below) - Joe M
        Purchases myPurchases = new Purchases();
        myPurchases.addPurchase(new Purchase("Laptop", 1200.50, "Work-related purchase"));
        myPurchases.addPurchase(new Purchase("Headphones", 199.99, "Wireless noise-canceling"));

        // Creating savings preference object and calculating savings
        SavingsPreference savings = new SavingsPreference(20); // 20% savings preference
        double initialIncome = 5000; // Example initial income
        Income myIncome = new Income(initialIncome); // Create Income object and set income
        savings.calculatePercent(initialIncome);

        // Create the report and display the initial data
        Report report = new Report(myPurchases, savings, myIncome);
        report.returnReport();

      
        // Display the updated report
        System.out.println("\n===== UPDATED REPORT =====");
        report.returnReport(); // Print the updated report
    }
}
