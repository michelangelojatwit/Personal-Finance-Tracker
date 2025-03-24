package Classwork;

import java.io.*;
import java.util.Scanner;

public class BackupManager {
    private static final String FILE_NAME = "backup.txt";

    // Save income and savings preference to a file
    public static void saveToFile(Income income, SavingsPreference savingsPreference) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            // Save income and savings preference
            writer.println("Income: " + income.getIncome());
            writer.println("SavingsPreference: " + savingsPreference.getPreference());

            System.out.println("Backup saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving backup: " + e.getMessage());
        }
    }

    // Load income and savings preference from a file
    public static void loadFromFile(Income income, SavingsPreference savingsPreference) {
        try (Scanner scanner = new Scanner(new File(FILE_NAME))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(": ");
                
                if (parts.length == 2) {
                    if (parts[0].equals("Income")) {
                        double incomeValue = Double.parseDouble(parts[1]);
                        income.setIncome(incomeValue); 
                    } else if (parts[0].equals("SavingsPreference")) {
                        double preferenceValue = Double.parseDouble(parts[1]);
                        savingsPreference.setPreference(preferenceValue);  
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
