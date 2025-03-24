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

	// Changed version of update income for GUI functionality ( DO NOT CHANGE THIS) - Joe M
	public void updateIncome(double addedIncome) {
	    this.monthly += addedIncome;
	}

	// Getter for monthly income
	public double getIncome() {
		return monthly;
	}
	
	// Setter for updating income ( ONLY for file restoration, don't use this for anything else) - Joe M
    public void setIncome(double monthly) {
        this.monthly = monthly;
    }
}