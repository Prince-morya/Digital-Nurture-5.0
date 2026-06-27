<<<<<<< HEAD
# Data Structures & Algorithms — Week 1.2

This folder contains two exercises. Keep each exercise's files together in their own subfolder, as shown below.

## Folder structure

```
Week 1.2 Data Structure and Algorithm/
│
├── E-commerce Platform Search Function/
│   ├── Product.java
│   └── ProductSearch.java
│
└── Financial Forecasting/
    ├── GrowthCalculator.java
    └── FinancialForecast.java
```

If your files aren't arranged like this yet, move them into matching folders before running anything.

## Exercise 1 — E-commerce Platform Search Function

**Files:** `Product.java`, `ProductSearch.java`

**Run from terminal:**
```powershell
cd "E-commerce Platform Search Function"
javac Product.java ProductSearch.java
java ProductSearch
```

**Expected output:** prints the product found by linear search and binary search, along with the time taken (in nanoseconds) for each.

## Exercise 2 — Financial Forecasting

**Files:** `GrowthCalculator.java`, `FinancialForecast.java`

**Run from terminal:**
```powershell
cd "Financial Forecasting"
javac GrowthCalculator.java FinancialForecast.java
java FinancialForecast
```

**Expected output:** prints the average historical growth rate and the projected revenue 5 years ahead, calculated two ways (naive recursion and fast recursion).

## Running from VS Code instead

1. Open the exercise folder in VS Code (`File > Open Folder`).
2. Make sure the **Extension Pack for Java** is installed (VS Code usually prompts for this automatically).
3. Open the file with the `main` method (`ProductSearch.java` or `FinancialForecast.java`).
4. Click the **Run** link that appears just above `public static void main(String[] args)`.
5. Output appears in the **Terminal** panel at the bottom.

VS Code automatically compiles every `.java` file in the folder, so `Product.java` and `GrowthCalculator.java` don't need any extra steps.

## Common PowerShell issues

**Folder or file names with spaces:** always wrap the full name in double quotes.
```powershell
cd "Financial Forecasting"
```
Without quotes, PowerShell treats each word as a separate argument and the command fails.

**Not sure which folder you're in or what's inside it:**
```powershell
dir
```
This lists everything in your current folder. If the `.java` files you're trying to compile aren't listed here, `javac` won't find them — `cd` into the right folder first.

**Can't find a file at all:** search your whole user folder for it.
```powershell
Get-ChildItem -Recurse -Filter Product.java -Path C:\Users\princ
```
This prints the file's actual full path on disk. Copy that path (without the filename) and `cd` into it.
=======
# Week 1.1 Design Patterns

Java implementations of two Gang-of-Four creational design patterns, built as part of the System Design lab — **Factory Method** (Exercise 2) and **Singleton** (Exercise 1).

## Project Structure

```
Week 1.1 Design Pattern/
│
├── Payment Factory/                     # Exercise 2 - Factory Method Pattern
│   ├── PaymentProcessor.java            # Product interface
│   ├── CardPayment.java                 # Concrete product
│   ├── UpiPayment.java                  # Concrete product
│   ├── NetBankingPayment.java           # Concrete product
│   ├── PaymentProcessorFactory.java     # Abstract creator
│   ├── CardProcessorFactory.java        # Concrete creator
│   ├── UpiProcessorFactory.java         # Concrete creator
│   ├── NetBankingProcessorFactory.java  # Concrete creator
│   ├── PaymentDemo.java                 # Client / entry point
│   ├── Output.png                       # Sample run screenshot
│   └── README.md
│
├── Singleton Pattern/                   # Exercise 1 - Singleton Pattern
│   ├── TransactionLogger.java           # Singleton class
│   ├── LoggerDemo.java                  # Client / entry point
│   └── ThreadSafetyTest.java            # Concurrency proof
│
└── UML Diagram/
    ├── singleton_class_diagram.png
    └── factory_method_product_hierarchy.png
```

## Exercise 1: Singleton Pattern

`TransactionLogger` ensures a single shared instance exists across the application, used to log payment activity from a central place instead of each component keeping its own log.

**Key implementation details:**
- Private constructor — prevents external instantiation
- Lazy initialization — instance is created only on first call to `getInstance()`
- Double-checked locking with a `volatile` instance field — makes `getInstance()` thread-safe without locking on every call

**To run:**
```
cd "Singleton Pattern"
javac *.java
java LoggerDemo
```

`ThreadSafetyTest` spins up three threads calling `getInstance()` simultaneously and prints each thread's hashcode for the returned object — all three should match, proving only one instance was ever created.
```
java ThreadSafetyTest
```

## Exercise 2: Factory Method Pattern

A payment processing system where the choice of payment method (UPI / Card / NetBanking) is delegated to subclasses of an abstract factory, rather than being decided with a single switch statement.

**Key implementation details:**
- `PaymentProcessor` — interface declaring `pay(double amount)`
- `PaymentProcessorFactory` — abstract creator declaring the factory method `createProcessor()`, plus the public `initiatePayment(double amount)` template method that calls it
- Three concrete factory/product pairs (`UpiProcessorFactory`/`UpiPayment`, etc.) — each factory overrides `createProcessor()` to return its own concrete product
- `PaymentDemo` — client that only ever talks to `PaymentProcessorFactory` and `PaymentProcessor`, never to a concrete class directly

**To run:**
```
cd "Payment Factory"
javac *.java
java PaymentDemo
```
Enter `1`, `2`, or `3` to choose a payment method, then enter an amount.

## Design Rationale

| | Without the pattern | With the pattern |
|---|---|---|
| Singleton | Multiple logger objects could be created across the app, fragmenting the log | Exactly one logger instance guaranteed, even under concurrent access |
| Factory Method | Adding a new payment method means editing an existing if-else/switch block | Adding a new payment method means adding two new classes — existing code untouched (Open/Closed Principle) |

UML diagrams for both patterns are included under `UML Diagram/`.

## Requirements

- JDK 8 or higher
- No external dependencies
>>>>>>> 3e7eeee2d629e522d6ccaf0fe923d002ad09d04a
