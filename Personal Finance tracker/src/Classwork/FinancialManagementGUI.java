package Classwork;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

public class FinancialManagementGUI extends Application {

	/*
	 * Here is what the code means if you didnt look at the documentation - Joe M 
	 * All dialog area's are just prompts for the user to enter information, Alert is for the pop-ups,
	 * Anything labeled stage is a window for the user to see
	 */
	
	private Income myIncome;
	private Purchases myPurchases;
	private SavingsPreference mySavings;
	private Report myReport;
	private BackupManager myBackupManager;

	// Initialize components and inject them into the report automatically, Do not try to do physical input unless this comment changes - Joe M
	public FinancialManagementGUI() {
		myIncome = new Income();
		myPurchases = new Purchases();
		mySavings = new SavingsPreference();
		myReport = new Report();

		// Inject the current objects into the report
		myReport.setIncome(myIncome);
		myReport.setPurchases(myPurchases);
		myReport.setSavingsPreference(mySavings);

		myBackupManager = new BackupManager();
	}

	@Override
	//Starts GUI and creates buttons ( If you plan to add more buttons then copy the same format I created) - Joe M
	public void start(Stage primaryStage) {
		VBox root = new VBox(10);
		root.setStyle("-fx-padding: 20;");

		Button updateIncomeButton = new Button("Update Income");
		updateIncomeButton.setOnAction(e -> updateIncome());

		Button viewEditPurchasesButton = new Button("View/Edit Purchases");
		viewEditPurchasesButton.setOnAction(e -> viewEditPurchases());

		Button updateSavingsButton = new Button("Update Savings Preference");
		updateSavingsButton.setOnAction(e -> updateSavingsPreference());

		Button viewReportButton = new Button("View Full Report");
		viewReportButton.setOnAction(e -> viewReport());

		Button saveDataButton = new Button("Save Data to File");
		saveDataButton.setOnAction(e -> saveData());

		Button importDataButton = new Button("Import Data from File");
		importDataButton.setOnAction(e -> importData());

		root.getChildren().addAll(updateIncomeButton, viewEditPurchasesButton, updateSavingsButton, viewReportButton,
				saveDataButton, importDataButton);

		Scene scene = new Scene(root, 400, 300);
		primaryStage.setTitle("Financial Management");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void updateIncome() {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Update Income");
		dialog.setHeaderText("Enter additional income for this month:");
		dialog.setContentText("Income:");

		dialog.showAndWait().ifPresent(input -> {
			try {
				double addedIncome = Double.parseDouble(input);
				myIncome.updateIncome(addedIncome);
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("Income Updated");
				alert.setHeaderText("Income Updated Successfully!");
				alert.setContentText("Current Monthly Income: $" + myIncome.getIncome());
				alert.show();
			} catch (NumberFormatException e) {
				showError("Invalid income value. Please enter a valid number.");
			}
		});
	}

	private void viewEditPurchases() {
		Stage purchaseStage = new Stage();
		purchaseStage.setTitle("Manage Purchases");

		ListView<String> purchaseList = new ListView<>();
		purchaseList.getItems().addAll(myPurchases.getAllPurchases());

		Button addPurchaseButton = new Button("Add Purchase");
		addPurchaseButton.setOnAction(e -> addPurchase(purchaseList));

		Button removePurchaseButton = new Button("Remove Purchase");
		removePurchaseButton.setOnAction(e -> removePurchase(purchaseList));

		Button editPurchaseButton = new Button("Edit Purchase");
		editPurchaseButton.setOnAction(e -> editPurchase(purchaseList));

		VBox layout = new VBox(10, purchaseList, addPurchaseButton, removePurchaseButton, editPurchaseButton);
		Scene scene = new Scene(layout, 300, 300);
		purchaseStage.setScene(scene);
		purchaseStage.show();
	}

	private void addPurchase(ListView<String> purchaseList) {
	    Dialog<Purchase> dialog = new Dialog<>();
	    dialog.setTitle("Add Purchase");

	    // Set up labels and fields for entering purchase 
	    Label nameLabel = new Label("Name:");
	    TextField nameField = new TextField();

	    Label costLabel = new Label("Cost:");
	    TextField costField = new TextField();

	    Label descLabel = new Label("Description:");
	    TextField descField = new TextField();

	    
	    //This sets up the positioning of the window, this should be fine but feel free to change if needed. - Joe M 
	    GridPane grid = new GridPane();
	    grid.setHgap(10);
	    grid.setVgap(10);
	    grid.add(nameLabel, 0, 0);
	    grid.add(nameField, 1, 0);
	    grid.add(costLabel, 0, 1);
	    grid.add(costField, 1, 1);
	    grid.add(descLabel, 0, 2);
	    grid.add(descField, 1, 2);

	    dialog.getDialogPane().setContent(grid);
	    dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
	    //Make sure if you edit this you do not mess up the arrow operators, otherwise this WILL break the home page - Joe M 
	    dialog.setResultConverter(button -> {
	        if (button == ButtonType.OK) {
	            try {
	                String name = nameField.getText();
	                double cost = Double.parseDouble(costField.getText());
	                String desc = descField.getText();

	                return new Purchase(name, cost, desc);
	            } catch (NumberFormatException e) {
	                showError("Cost must be a valid number.");
	            }
	        }
	        return null;
	    });

	    dialog.showAndWait().ifPresent(purchase -> {
	        myPurchases.addPurchase(purchase);
	        purchaseList.getItems().add(purchase.getpName());
	    });
	}


	private void removePurchase(ListView<String> purchaseList) {
		String selected = purchaseList.getSelectionModel().getSelectedItem();
		if (selected != null) {
			myPurchases.removePurchase(selected);
			purchaseList.getItems().remove(selected);
		} else {
			showError("Please select a purchase to remove.");
		}
	}

	private void editPurchase(ListView<String> purchaseList) {
		String selected = purchaseList.getSelectionModel().getSelectedItem();
		if (selected != null) {
			TextInputDialog dialog = new TextInputDialog(selected);
			dialog.setTitle("Edit Purchase");
			dialog.setHeaderText("Edit the selected purchase:");
			dialog.setContentText("New name:");

			dialog.showAndWait().ifPresent(newName -> {
				myPurchases.editPurchase(selected, newName);
				purchaseList.getItems().set(purchaseList.getItems().indexOf(selected), newName);
			});
		} else {
			showError("Please select a purchase to edit.");
		}
	}

	private void updateSavingsPreference() {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Update Savings Preference");
		dialog.setHeaderText("Enter savings percentage (0-100):");
		dialog.setContentText("Percentage:");

		dialog.showAndWait().ifPresent(input -> {
			try {
				double preference = Double.parseDouble(input);
				if (preference < 0 || preference > 100)
					throw new NumberFormatException();
				mySavings.setPreference(preference);
				mySavings.calculatePercent(myIncome.getIncome()); // Recalculate based on new income
				showInfo("Savings preference updated to " + preference + "% of income.");
			} catch (NumberFormatException e) {
				showError("Please enter a valid number between 0 and 100.");
			}
		});
	}
	// Displays the full report in a scrollable window
	private void viewReport() {
	    String reportText = myReport.generateFormattedReport();

	    Alert alert = new Alert(Alert.AlertType.INFORMATION);
	    alert.setTitle("Full Report");
	    alert.setHeaderText("Financial Report");
	    alert.setContentText(reportText);

	    // For long reports, use expandable text area
	    TextArea textArea = new TextArea(reportText);
	    textArea.setEditable(false);
	    textArea.setWrapText(true);
	    textArea.setMaxWidth(Double.MAX_VALUE);
	    textArea.setMaxHeight(Double.MAX_VALUE);

	    GridPane.setVgrow(textArea, Priority.ALWAYS);
	    GridPane.setHgrow(textArea, Priority.ALWAYS);

	    GridPane expandableContent = new GridPane();
	    expandableContent.add(textArea, 0, 0);

	    alert.getDialogPane().setExpandableContent(expandableContent);
	    alert.getDialogPane().setExpanded(true);

	    alert.showAndWait();
	}

	private void saveData() {
		BackupManager.saveToFile(myIncome, mySavings);
		showInfo("Data saved to file.");
	}

	private void importData() {
		BackupManager.loadFromFile(myIncome, mySavings);
		showInfo("Data imported from file.");
	}

	private void showInfo(String message) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Info");
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.show();
	}
	// Show an error popup just incase something went wrong
	private void showError(String message) {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText("Something went wrong");
		alert.setContentText(message);
		alert.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
