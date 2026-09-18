import java.util.ArrayList;
import java.util.List;

public class ExpenseManager {

    private ArrayList<Expense> expenses;
    private int nextExpenseId;

    // Constructor
    public ExpenseManager() {
        expenses = new ArrayList<>();
        nextExpenseId = 1;
    }

    // Add a new expense
    // ID is generated automatically
    public Expense addExpense(String date, String category,
                              String description, double amount) {

        Expense expense = new Expense(
            nextExpenseId,
            date,
            category,
            description,
            amount
        );

        expenses.add(expense);
        nextExpenseId++;

        return expense;
    }

    // Display all expenses
    public void displayAllExpenses() {

        if (expenses.isEmpty()) {
            System.out.println("No expenses available.");
            return;
        }

        System.out.println(
            "================ ALL EXPENSES ================"
        );

        System.out.printf(
            "%-5s %-12s %-16s %-25s %-12s%n",
            "ID", "Date", "Category", "Description", "Amount"
        );

        System.out.println(
            "---------------------------------------------------------------"
        );

        for (Expense expense : expenses) {
            expense.displayExpense();
        }

        System.out.println(
            "---------------------------------------------------------------"
        );
    }

    // Delete expense using ID
    public boolean deleteExpenseById(int id) {

        for (int i = 0; i < expenses.size(); i++) {

            if (expenses.get(i).getExpenseId() == id) {
                expenses.remove(i);
                return true;
            }
        }

        return false;
    }

    // Calculate total spending
    public double calculateTotalSpending() {

        double total = 0;

        for (Expense expense : expenses) {
            total += expense.getAmount();
        }

        return total;
    }

    // Calculate spending for a particular category
    public double getCategoryTotal(String category) {

        double total = 0;

        for (Expense expense : expenses) {

            if (expense.getCategory().equalsIgnoreCase(category)) {
                total += expense.getAmount();
            }
        }

        return total;
    }

    // Return expense list for reports
    public List<Expense> getExpenses() {
        return expenses;
    }

    // Return number of expenses
    public int getExpenseCount() {
        return expenses.size();
    }
}
