import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Scanner;

public class Main {

    private static Scanner scanner =
        new Scanner(System.in);

    private static ExpenseManager expenseManager =
        new ExpenseManager();

    private static BudgetManager budgetManager =
        new BudgetManager();

    private static ReportManager reportManager =
        new ReportManager(
            expenseManager,
            budgetManager
        );

    // Strict date formatter
    private static DateTimeFormatter dateFormatter =
        DateTimeFormatter
            .ofPattern("dd-MM-uuuu")
            .withResolverStyle(
                ResolverStyle.STRICT
            );

    public static void main(String[] args) {

        boolean running = true;

        while (running) {

            displayMenu();

            int choice =
                readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    addExpense();
                    break;

                case 2:
                    expenseManager.displayAllExpenses();
                    break;

                case 3:
                    deleteExpense();
                    break;

                case 4:
                    setBudget();
                    break;

                case 5:
                    budgetManager.displayBudgetStatus(
                        expenseManager
                            .calculateTotalSpending()
                    );
                    break;

                case 6:
                    showTotalSpending();
                    break;

                case 7:
                    reportManager
                        .showCategoryWiseSpending();
                    break;

                case 8:
                    showMonthlySummary();
                    break;

                case 9:
                    running = false;

                    System.out.println(
                        "Thank you for using "
                        + "Expense & Budget Manager!"
                    );

                    break;

                default:
                    System.out.println(
                        "Invalid menu choice. "
                        + "Please enter a number from 1 to 9."
                    );
            }

            if (running) {
                System.out.println();
            }
        }

        scanner.close();
    }

    // Display main menu
    private static void displayMenu() {

        System.out.println(
            "========================================"
        );

        System.out.println(
            "       EXPENSE & BUDGET MANAGER"
        );

        System.out.println(
            "========================================"
        );

        System.out.println("1. Add Expense");
        System.out.println("2. View All Expenses");
        System.out.println("3. Delete Expense");
        System.out.println("4. Set Monthly Budget");
        System.out.println("5. View Budget Status");
        System.out.println("6. Calculate Total Spending");
        System.out.println("7. Category-wise Spending");
        System.out.println("8. Monthly Summary");
        System.out.println("9. Exit");

        System.out.println();
    }

    // Add expense
    private static void addExpense() {

        System.out.println(
            "========== ADD EXPENSE =========="
        );

        String date;

        // Validate date
        while (true) {

            date =
                readLine(
                    "Enter date (DD-MM-YYYY): "
                );

            if (isValidDate(date)) {
                break;
            }

            System.out.println(
                "Invalid date. Please use "
                + "DD-MM-YYYY and enter a real date."
            );
        }

        int categoryChoice;

        // Select category
        while (true) {

            System.out.println();
            System.out.println(
                "Select category:"
            );

            Category.displayCategories();

            categoryChoice =
                readInt("Enter choice: ");

            if (Category.isValidChoice(
                    categoryChoice)) {

                break;
            }

            System.out.println(
                "Invalid category choice. "
                + "Please select 1 to 7."
            );
        }

        String category =
            Category.getCategoryName(
                categoryChoice
            );

        // Description
        String description;

        while (true) {

            description =
                readLine("Enter description: ");

            if (!description.isEmpty()) {
                break;
            }

            System.out.println(
                "Description cannot be empty."
            );
        }

        // Amount
        double amount;

        while (true) {

            amount =
                readDouble("Enter amount: ");

            if (amount > 0) {
                break;
            }

            System.out.println(
                "Amount must be greater than zero."
            );
        }

        // Add expense
        Expense expense =
            expenseManager.addExpense(
                date,
                category,
                description,
                amount
            );

        System.out.println();

        System.out.println(
            "Expense added successfully!"
        );

        System.out.println(
            "Expense ID: "
            + expense.getExpenseId()
        );
    }

    // Delete expense
    private static void deleteExpense() {

        System.out.println(
            "========== DELETE EXPENSE =========="
        );

        int id =
            readInt(
                "Enter Expense ID to delete: "
            );

        if (expenseManager
                .deleteExpenseById(id)) {

            System.out.println(
                "Expense deleted successfully!"
            );

        } else {

            System.out.println(
                "Expense ID not found."
            );
        }
    }

    // Set budget
    private static void setBudget() {

        System.out.println(
            "========== SET MONTHLY BUDGET =========="
        );

        double budget;

        while (true) {

            budget =
                readDouble(
                    "Enter monthly budget: "
                );

            if (budget > 0) {
                break;
            }

            System.out.println(
                "Budget must be greater than zero."
            );
        }

        budgetManager.setBudget(budget);

        System.out.println(
            "Budget set successfully!"
        );
    }

    // Show total spending
    private static void showTotalSpending() {

        double total =
            expenseManager.calculateTotalSpending();

        System.out.println(
            "========== TOTAL SPENDING =========="
        );

        if (expenseManager.getExpenseCount() == 0) {

            System.out.println(
                "No expenses available."
            );
        }

        System.out.printf(
            "Total Spending: ₹%.2f%n",
            total
        );
    }

    // Monthly summary
    private static void showMonthlySummary() {

        System.out.println(
            "========== MONTHLY SUMMARY =========="
        );

        int month;

        while (true) {

            month =
                readInt(
                    "Enter month (1-12): "
                );

            if (month >= 1 && month <= 12) {
                break;
            }

            System.out.println(
                "Invalid month. "
                + "Please enter a value from 1 to 12."
            );
        }

        int year;

        while (true) {

            year =
                readInt("Enter year: ");

            if (year > 0 && year <= 9999) {
                break;
            }

            System.out.println(
                "Invalid year. "
                + "Please enter a positive year "
                + "up to 9999."
            );
        }

        reportManager.showMonthlySummary(
            month,
            year
        );
    }

    // Validate date
    private static boolean isValidDate(
            String date) {

        try {

            LocalDate.parse(
                date,
                dateFormatter
            );

            return true;

        } catch (DateTimeParseException e) {

            return false;
        }
    }

    // Read String
    private static String readLine(
            String message) {

        System.out.print(message);

        return scanner.nextLine().trim();
    }

    // Read integer safely
    private static int readInt(
            String message) {

        while (true) {

            String input =
                readLine(message);

            try {

                return Integer.parseInt(input);

            } catch (NumberFormatException e) {

                System.out.println(
                    "Invalid input. "
                    + "Please enter a whole number."
                );
            }
        }
    }

    // Read double safely
    private static double readDouble(
            String message) {

        while (true) {

            String input =
                readLine(message);

            try {

                return Double.parseDouble(input);

            } catch (NumberFormatException e) {

                System.out.println(
                    "Invalid input. "
                    + "Please enter a number."
                );
            }
        }
    }
}
