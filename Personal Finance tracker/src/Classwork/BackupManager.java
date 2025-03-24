package Classwork;

import java.io.*;
import java.util.Scanner;

public class BackupManager {
	private static final String FILE_NAME = "backup.txt";

	// Save income, savings preference, and total savings to a file
	public static void saveToFile(Income income, SavingsPreference savingsPreference) {
		try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
			writer.println("Income: " + income.getIncome());
			writer.println("SavingsPreference: " + savingsPreference.getPreference());
			writer.println("TotalSavings: " + savingsPreference.getTotalSavings());
			System.out.println("Backup saved successfully!");
		} catch (IOException e) {
			System.out.println("Error saving backup: " + e.getMessage());
		}
	}

	// Load income, savings preference, and total savings from a file
	public static void loadFromFile(Income income, SavingsPreference savingsPreference) {
		try (Scanner scanner = new Scanner(new File(FILE_NAME))) {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] parts = line.split(": ");
				if (parts.length == 2) {
					switch (parts[0]) {
						case "Income":
							income.setIncome(Double.parseDouble(parts[1]));
							break;
						case "SavingsPreference":
							savingsPreference.setPreference(Double.parseDouble(parts[1]));
							break;
						case "TotalSavings":
							savingsPreference.setTotalSavings(Double.parseDouble(parts[1]));
							break;
					}
				}
			}
			System.out.println("Backup loaded successfully!");
		} catch (FileNotFoundException e) {
			System.out.println("No backup file found. Starting with default values.");
		} catch (Exception e) {
			System.out.println("Error loading backup: " + e.getMessage());
		}
	}
}
