public class Expense {
    private int expenseId;
    private String date;
    private String category;
    private String description;
    private double amount;

    // Constructor
    public Expense(int expenseId, String date, String category,
                   String description, double amount) {
        this.expenseId = expenseId;
        this.date = date;
        this.category = category;
        this.description = description;
        this.amount = amount;
    }

    // Getters
    public int getExpenseId() {
        return expenseId;
    }

    public String getDate() {
        return date;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    // Setters
    public void setDate(String date) {
        this.date = date;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    // Display one expense
    public void displayExpense() {
        System.out.printf(
            "%-5d %-12s %-16s %-25s ₹%10.2f%n",
            expenseId, date, category, description, amount
        );
    }

    @Override
    public String toString() {
        return expenseId + " " + date + " " + category
                + " " + description + " " + amount;
    }
}
