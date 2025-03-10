package Classwork;

import java.util.Scanner;

public class Report {
	private Purchases purchases;
	private SavingsPreference savingsPreference;
	private Income income; // Reference to the Income class

	// Constructor initializes the Purchases, SavingsPreference, and Income objects
	public Report(Purchases purchases, SavingsPreference savingsPreference, Income income) {
		this.purchases = purchases;
		this.savingsPreference = savingsPreference;
		this.income = income;
	}

	// Method to generate and print the full report
	public void returnReport() {
		System.out.println("===== INCOME REPORT =====");
		income.printVal(); // Uses the Income class's method to print the income
		System.out.println("===== END OF INCOME REPORT =====");

		System.out.println("\n===== PURCHASE REPORT =====");
		purchases.printArray(); // Calls the printArray() method from Purchases class
		System.out.println("===== END OF PURCHASE REPORT =====");

		System.out.println("\n===== SAVINGS REPORT =====");
		savingsPreference.printSavings(); // Calls the printSavings() from SavingsPreference class
		System.out.println("===== END OF SAVINGS REPORT =====");
	}

	// Method to update income based on user input

}
