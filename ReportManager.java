import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

public class ReportManager {

    private ExpenseManager expenseManager;
    private BudgetManager budgetManager;
    private DateTimeFormatter formatter;

    // Constructor
    public ReportManager(ExpenseManager expenseManager,
                         BudgetManager budgetManager) {

        this.expenseManager = expenseManager;
        this.budgetManager = budgetManager;

        formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    }

    // Category-wise spending report
    public void showCategoryWiseSpending() {

        System.out.println(
            "======= CATEGORY-WISE SPENDING ======="
        );

        String[] categories = Category.getCategories();

        double total = 0;

        for (String category : categories) {

            double amount =
                expenseManager.getCategoryTotal(category);

            total += amount;

            System.out.printf(
                "%-18s ₹%.2f%n",
                category,
                amount
            );
        }

        System.out.println(
            "---------------------------------------"
        );

        System.out.printf(
            "%-18s ₹%.2f%n",
            "Total",
            total
        );
    }

    // Monthly summary
    public void showMonthlySummary(int month, int year) {

        List<Expense> expenses =
            expenseManager.getExpenses();

        String[] categories =
            Category.getCategories();

        double total = 0;
        int count = 0;

        double[] categoryTotals =
            new double[categories.length];

        // Check each expense
        for (Expense expense : expenses) {

            try {

                LocalDate date =
                    LocalDate.parse(
                        expense.getDate(),
                        formatter
                    );

                if (date.getMonthValue() == month
                        && date.getYear() == year) {

                    total += expense.getAmount();
                    count++;

                    // Add amount to correct category
                    for (int i = 0;
                         i < categories.length;
                         i++) {

                        if (expense.getCategory()
                                .equals(categories[i])) {

                            categoryTotals[i] +=
                                expense.getAmount();

                            break;
                        }
                    }
                }

            } catch (DateTimeParseException e) {
                // Dates are already validated when added.
            }
        }

        String monthName =
            Month.of(month).toString();

        System.out.println(
            "========== " + monthName
            + " " + year + " SUMMARY =========="
        );

        System.out.printf(
            "Number of Expenses : %d%n",
            count
        );

        System.out.printf(
            "Total Spent        : ₹%.2f%n",
            total
        );

        // Display budget information
        if (budgetManager.isBudgetSet()) {

            double remaining =
                budgetManager.getRemainingBudget(total);

            System.out.printf(
                "Monthly Budget     : ₹%.2f%n",
                budgetManager.getBudget()
            );

            System.out.printf(
                "Remaining Budget   : ₹%.2f%n",
                remaining
            );

            if (remaining < 0) {
                System.out.println(
                    "Warning: Monthly spending has exceeded the budget."
                );
            }

        } else {

            System.out.println(
                "Monthly Budget     : Not set"
            );

            System.out.println(
                "Remaining Budget   : Not available"
            );
        }

        System.out.println();
        System.out.println("Category Breakdown:");

        String highestCategory = "N/A";
        double highestAmount = 0;

        for (int i = 0;
             i < categories.length;
             i++) {

            System.out.printf(
                "%-18s ₹%.2f%n",
                categories[i],
                categoryTotals[i]
            );

            if (categoryTotals[i] > highestAmount) {

                highestAmount =
                    categoryTotals[i];

                highestCategory =
                    categories[i];
            }
        }

        if (count == 0) {
            highestCategory = "N/A";
        }

        System.out.println();
        System.out.println(
            "Highest Spending Category: "
            + highestCategory
        );

        System.out.println(
            "=============================================="
        );
    }
}
