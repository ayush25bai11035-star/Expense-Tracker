public class BudgetManager {

    private double monthlyBudget;
    private boolean budgetSet;

    // Constructor
    public BudgetManager() {
        monthlyBudget = 0;
        budgetSet = false;
    }

    // Set or change budget
    public void setBudget(double amount) {
        monthlyBudget = amount;
        budgetSet = true;
    }

    // Get budget
    public double getBudget() {
        return monthlyBudget;
    }

    // Check whether budget has been set
    public boolean isBudgetSet() {
        return budgetSet;
    }

    // Calculate remaining budget
    public double getRemainingBudget(double totalSpent) {
        return monthlyBudget - totalSpent;
    }

    // Display budget status
    public void displayBudgetStatus(double totalSpent) {

        if (!budgetSet) {
            System.out.println("No monthly budget has been set.");
            return;
        }

        double remaining = getRemainingBudget(totalSpent);

        System.out.println("========== BUDGET STATUS ==========");

        System.out.printf(
            "Monthly Budget : ₹%.2f%n",
            monthlyBudget
        );

        System.out.printf(
            "Total Spent    : ₹%.2f%n",
            totalSpent
        );

        System.out.printf(
            "Remaining      : ₹%.2f%n",
            remaining
        );

        if (remaining < 0) {
            System.out.println(
                "Warning: You have exceeded your budget."
            );
        } else {
            System.out.println(
                "You are within your budget."
            );
        }
    }
}
