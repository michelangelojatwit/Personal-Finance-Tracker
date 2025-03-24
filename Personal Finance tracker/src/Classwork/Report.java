package Classwork;

public class Report {
    private Purchases purchases;
    private SavingsPreference savingsPreference;
    private Income income;

    // No-arg constructor
    public Report() {
        this.purchases = null;
        this.savingsPreference = null;
        this.income = null;
    }

    // Only use this for testing outside of the GUI - Joe M 
    public Report(Purchases purchases, SavingsPreference savingsPreference, Income income) {
        this.purchases = purchases;
        this.savingsPreference = savingsPreference;
        this.income = income;
    }

    // Setters for injecting values from the GUI
    public void setPurchases(Purchases purchases) {
        this.purchases = purchases;
    }

    public void setSavingsPreference(SavingsPreference savingsPreference) {
        this.savingsPreference = savingsPreference;
    }

    public void setIncome(Income income) {
        this.income = income;
    }
    // DO NOT TOUCH FORMATTING ON THIS WITHOUT READING THE GUIDE I PROVIDED - Joe M
    public String generateFormattedReport() {
        StringBuilder report = new StringBuilder();

        // INCOME
        report.append("===== INCOME REPORT =====\n");
        report.append("Current Monthly Income: $").append(income.getIncome()).append("\n");
        report.append("===== END OF INCOME REPORT =====\n\n");

        // PURCHASES
        report.append("===== PURCHASE REPORT =====\n");
        report.append("Purchase List:\n");
        if (purchases.purchases.isEmpty()) {
            report.append("No purchases recorded.\n");
        } else {
            for (Purchase p : purchases.purchases) {
                report.append("Purchase Name: ").append(p.getpName()).append("\n");
                report.append("Expense Value: $").append(p.getExpenseVal()).append("\n");
                report.append("Details: ").append(p.getDetails()).append("\n");
                report.append("------------------\n");
            }
        }
        report.append("===== END OF PURCHASE REPORT =====\n\n");

        // SAVINGS
        report.append("===== SAVINGS REPORT =====\n");
        report.append("Savings Preference: ").append(savingsPreference.getPreference()).append("% of income\n");
        report.append("Savings this Month: $").append(savingsPreference.getMonthlySavings()).append("\n");
        report.append("Total Savings: $").append(savingsPreference.getTotalSavings()).append("\n");
        report.append("===== END OF SAVINGS REPORT =====");

        return report.toString();
    }
    public void returnReport() {
        System.out.println("===== INCOME REPORT =====");
        income.printVal();
        System.out.println("===== END OF INCOME REPORT =====");

        System.out.println("\n===== PURCHASE REPORT =====");
        purchases.printArray();
        System.out.println("===== END OF PURCHASE REPORT =====");

        System.out.println("\n===== SAVINGS REPORT =====");
        savingsPreference.printSavings();
        System.out.println("===== END OF SAVINGS REPORT =====");
    }
}
