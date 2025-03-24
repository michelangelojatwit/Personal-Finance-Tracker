package Classwork;

public class Purchase {
	private String pName;
	private double expenseVal;
	private String details;

	// Default constructor
	public Purchase() {
		this.pName = "Unknown";
		this.expenseVal = 0.0;
		this.details = "No details ";
	}
	//Constructor with only the name
	public Purchase(String name) {
	    this.pName = name;
	    this.expenseVal = 0.0;
	    this.details = "No details ";
	}

		
	// Parameterized constructor with all parameters 
	public Purchase(String pName, double expenseVal, String details) {
		this.pName = pName;
		this.expenseVal = expenseVal;
		this.details = details;
	}

	// Getter methods
	public String getpName() {
		return pName;
	}

	public double getExpenseVal() {
		return expenseVal;
	}

	public String getDetails() {
		return details;
	}

	// Setter methods
	public void setpName(String pName) {
		this.pName = pName;
	}

	public void setExpenseVal(double expenseVal) {
		this.expenseVal = expenseVal;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	// Prints purchase details
	public void PrintInfo() {
		System.out.println("Purchase Name: " + pName);
		System.out.println("Expense Value: $" + expenseVal);
		System.out.println("Details: " + details);
	}

}
