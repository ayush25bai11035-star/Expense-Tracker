# Expense-Tracker
# Expense & Budget Management System

## Introduction

The Expense & Budget Management System is a Java console-based project developed as a college OOP project. The main purpose of this project is to help a user keep track of their expenses and manage a monthly budget.

The application works completely through the terminal. All expenses and budget information are stored temporarily in memory using Java objects and ArrayList. No database or file storage is used.

## Features

The system provides the following features:

1. Add Expense
2. View All Expenses
3. Delete Expense
4. Set Monthly Budget
5. View Budget Status
6. Calculate Total Spending
7. Category-wise Spending
8. Monthly Summary
9. Exit

## Expense Categories

The user can select an expense category from the following options:

* Food
* Transport
* Education
* Shopping
* Entertainment
* Bills
* Other

The expense ID is generated automatically by the program, so the user does not have to enter it manually.

## Classes Used

The project contains six Java classes:

### Expense.java

This class represents an individual expense. It stores the expense ID, date, category, description and amount.

### Category.java

This class contains the available expense categories. It also displays the numbered category options and validates the selected category.

### ExpenseManager.java

This class manages all expenses using an ArrayList. It is responsible for adding, displaying and deleting expenses and calculating total and category-wise spending.

### BudgetManager.java

This class handles the monthly budget. It allows the user to set or change the budget and checks the remaining amount after expenses.

### ReportManager.java

This class generates category-wise and monthly reports. It also calculates the highest spending category for a selected month.

### Main.java

This is the main class of the project. It displays the menu, takes input from t
# Expense & Budget Management System

## Introduction

The Expense & Budget Management System is a Java console-based project developed as a college OOP project. The main purpose of this project is to help a user keep track of their expenses and manage a monthly budget.

The application works completely through the terminal. All expenses and budget information are stored temporarily in memory using Java objects and ArrayList. No database or file storage is used.

## Features

The system provides the following features:

1. Add Expense
2. View All Expenses
3. Delete Expense
4. Set Monthly Budget
5. View Budget Status
6. Calculate Total Spending
7. Category-wise Spending
8. Monthly Summary
9. Exit

## Expense Categories

The user can select an expense category from the following options:

* Food
* Transport
* Education
* Shopping
* Entertainment
* Bills
* Other

The expense ID is generated automatically by the program, so the user does not have to enter it manually.

## Classes Used

The project contains six Java classes:

### Expense.java

This class represents an individual expense. It stores the expense ID, date, category, description and amount.

### Category.java

This class contains the available expense categories. It also displays the numbered category options and validates the selected category.

### ExpenseManager.java

This class manages all expenses using an ArrayList. It is responsible for adding, displaying and deleting expenses and calculating total and category-wise spending.

### BudgetManager.java

This class handles the monthly budget. It allows the user to set or change the budget and checks the remaining amount after expenses.

### ReportManager.java

This class generates category-wise and monthly reports. It also calculates the highest spending category for a selected month.

### Main.java

This is the main class of the project. It displays the menu, takes input from t
