package Classwork;

import java.util.Scanner;

public class Income {
	private double monthly = 0;

	// Default constructor
	public Income() {
	}

	// Constructor with initial income
	public Income(double monthly) {
		this.monthly = monthly;
	}

	// Prints current monthly income
	public void printVal() {
		System.out.println("Current Monthly Income: $" + monthly);
	}

	// Updates income with user input
	public void updateIncome() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter additional income for this month: ");
		double addedIncome = scanner.nextDouble();
		monthly += addedIncome;
		System.out.println("Income updated successfully!");
	}

	// Getter for monthly income
	public double getIncome() {
		return monthly;
	}
}