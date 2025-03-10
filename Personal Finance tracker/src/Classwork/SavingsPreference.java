package Classwork;

public class SavingsPreference {
    private double totalSavings;  // Total savings across all months
    private double monthlySavings; // Savings from this month alone
    private double preference;  // Percent of income to be set aside as savings

    // Default constructor
    public SavingsPreference() {
        this.totalSavings = 0.0;
        this.monthlySavings = 0.0;
        this.preference = 0.0;
    }

    // Parameterized constructor
    public SavingsPreference(double preference) {
        this.totalSavings = 0.0;
        this.monthlySavings = 0.0;
        this.preference = preference;
    }

    // Method to calculate savings based on a given income
    public void calculatePercent(double income) {
        this.monthlySavings = (income * preference) / 100; // Calculate savings for this month
        this.totalSavings += this.monthlySavings; // Add to total savings
    }

    // Method to print savings details
    public void printSavings() {
        System.out.println("Savings Preference: " + preference + "% of income");
        System.out.println("Savings this Month: $" + monthlySavings);
        System.out.println("Total Savings: $" + totalSavings);
    }

    // Getters
    public double getTotalSavings() {
        return totalSavings;
    }

    public double getMonthlySavings() {
        return monthlySavings;
    }

    public double getPreference() {
        return preference;
    }

    // Setters
    public void setPreference(double preference) {
        this.preference = preference;
    }

}
