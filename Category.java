public class Category {

    private static final String[] CATEGORIES = {
        "Food",
        "Transport",
        "Education",
        "Shopping",
        "Entertainment",
        "Bills",
        "Other"
    };

    // Display numbered categories
    public static void displayCategories() {
        for (int i = 0; i < CATEGORIES.length; i++) {
            System.out.println((i + 1) + ". " + CATEGORIES[i]);
        }
    }

    // Check whether category number is valid
    public static boolean isValidChoice(int choice) {
        return choice >= 1 && choice <= CATEGORIES.length;
    }

    // Convert number to category name
    public static String getCategoryName(int choice) {
        if (!isValidChoice(choice)) {
            return null;
        }

        return CATEGORIES[choice - 1];
    }

    // Return all categories
    public static String[] getCategories() {
        return CATEGORIES.clone();
    }
}
