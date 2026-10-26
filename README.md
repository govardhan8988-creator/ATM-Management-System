# ATM Management System Using Java

A console-based ATM Management System developed in Java for an Object-Oriented Programming (OOP) micro project. This project demonstrates **Encapsulation** by protecting account information and providing controlled access to ATM operations.

## Project Overview

The ATM Management System simulates basic ATM operations. Users authenticate using an account number and PIN and can then check their balance, deposit money, withdraw money, change their PIN, and view a mini statement.

## Features

- Account number and PIN authentication
- Balance inquiry
- Cash deposit with amount validation
- Cash withdrawal with balance validation
- Maximum withdrawal limit of Rs. 10,000 per transaction
- PIN change with old-PIN and new-PIN validation
- Mini statement with transaction type, amount, and date/time
- Account data persistence using `account.txt`
- Transaction history persistence using `transactions.txt`
- Data retained after restarting the application

## OOP Concept Demonstrated

### Encapsulation

Encapsulation is the primary Object-Oriented Programming concept demonstrated in this project.

The `BankAccount` class protects sensitive account information using private fields:

- `accountNumber`
- `pin`
- `balance`

These fields cannot be accessed directly by other classes. Instead, controlled methods are provided:

- `validatePin()`
- `getBalance()`
- `deposit()`
- `withdraw()`
- `changePin()`

This approach protects the internal account data and ensures that validation rules are applied before account information is changed.

## Technologies Used

- **Programming Language:** Java
- **Java Version:** Java 25
- **Compiler:** `javac`
- **Development Environment:** Visual Studio Code
- **Data Storage:** Text files
- **Core Concepts:** Classes, objects, encapsulation, methods, constructors, collections, and file handling

## Project Structure

```text
ATM-Management-System/
├── Main.java
├── ATM.java
├── BankAccount.java
├── Transaction.java
├── account.txt
├── transactions.txt
├── README.md
└── .gitignore
```

## File Descriptions

| File | Description |
|---|---|
| `Main.java` | Loads the saved account and starts the ATM application. |
| `ATM.java` | Manages user interaction, login, menu options, and ATM operations. |
| `BankAccount.java` | Encapsulates account details and implements deposit, withdrawal, PIN change, and account persistence. |
| `Transaction.java` | Stores transaction type, amount, and date/time, and saves and loads transaction history. |
| `account.txt` | Stores the sample account number, PIN, and balance. |
| `transactions.txt` | Stores transaction records for the mini statement. |
| `README.md` | Documents the project, features, setup, and usage. |

## How to Run the Project

### Prerequisites

Install the Java Development Kit (JDK) and ensure that Java and the Java compiler are available in your terminal.

Check the installation:

```powershell
java -version
javac -version
```

### Step 1: Open the Project Folder

Open the terminal in the `ATM-Management-System` directory.

### Step 2: Compile the Java Files

```powershell
javac *.java
```

### Step 3: Run the Application

```powershell
java Main
```

Keep `account.txt` and `transactions.txt` in the same directory as the Java files. These files are used to load and save account information and transaction records.

## ATM Menu

After successful authentication, the application displays the following menu:

| Option | Operation |
|---|---|
| 1 | Check Balance |
| 2 | Deposit Money |
| 3 | Withdraw Money |
| 4 | Change PIN |
| 5 | Mini Statement |
| 6 | Exit |

## Validation and Error Handling

The application includes validation for:

- Incorrect account numbers
- Invalid PINs
- Negative or zero deposit amounts
- Invalid withdrawal amounts
- Withdrawals exceeding the Rs. 10,000 transaction limit
- Withdrawals exceeding the available balance
- Invalid PIN changes

The application displays suitable messages when an operation is rejected.

## Transaction History

Successful deposits and withdrawals are recorded with:

- Transaction type
- Transaction amount
- Transaction date and time

The mini statement displays the saved transaction records and the current account balance.

## Testing and Results

The project was tested using the Java compiler and console application.

| Test Case | Expected Result |
|---|---|
| Valid login | Login successful |
| Invalid account number | Access rejected |
| Incorrect PIN | Access rejected |
| Balance inquiry | Current balance displayed |
| Successful deposit | Balance increases |
| Successful withdrawal | Balance decreases |
| Withdrawal above Rs. 10,000 | Transaction rejected |
| Negative deposit | Transaction rejected |
| PIN change | PIN updated after validation |
| Mini statement | Transaction history displayed |
| Date/time recording | Transaction timestamp displayed |
| Application restart | Saved account and transaction data loaded |

## Security Note

This is an academic project and not a production banking system. The sample `account.txt` file stores the PIN in plain text. Use only dummy project data. Never store or upload real banking credentials or sensitive financial information.

## Future Enhancements

Possible future improvements include:

- Support for multiple customer accounts
- Database integration
- A graphical user interface
- Improved handling of non-numeric inputs
- Stronger credential protection
- Account lockout after repeated failed login attempts
- Transaction search and receipt generation

## Author

**Name:** Govardhan Reddy  
**University Registration Number:** 2511021060006

## Academic Project Details

- **Subject:** Java / Object-Oriented Programming
- **Project Type:** Single Subject Project
- **Project Title:** ATM Management System Using Java
- **Selected OOP Concept:** Encapsulation

---