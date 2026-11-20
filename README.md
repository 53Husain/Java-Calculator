# Java Calculator

A menu-driven command-line calculator built with Core Java. The project demonstrates object-oriented design, precise decimal arithmetic with `BigDecimal`, input validation, and exception handling.

## Features

- Addition, subtraction, multiplication, and division
- Modulus, power, square root, and percentage calculations
- Decimal-safe arithmetic using `BigDecimal`
- Division-by-zero and invalid-input handling
- Simple interactive console menu
- Unit tests with JUnit 5

## Tech Stack

- Java 17
- Maven
- JUnit 5

## Project Structure

```
Java-Calculator/
├── src/
│   ├── main/java/com/husain/calculator/
│   │   ├── Calculator.java
│   │   └── CalculatorApp.java
│   └── test/java/com/husain/calculator/
│       └── CalculatorTest.java
├── .gitignore
├── pom.xml
└── README.md
```

## Requirements

- JDK 17 or later
- Apache Maven 3.8+

## Run the Application

Clone the repository:

```bash
git clone https://github.com/53Husain/Java-Calculator.git
cd Java-Calculator
```

Compile and run:

```bash
mvn clean package
java -cp target/classes com.husain.calculator.CalculatorApp
```

Alternatively, run the application from your IDE by executing `CalculatorApp.java`.

## Run Tests

```bash
mvn test
```

## Example

```
=================================
         JAVA CALCULATOR
=================================
1. Addition
2. Subtraction
3. Multiplication
4. Division
5. Modulus
6. Power
7. Square Root
8. Percentage
9. Exit

Choose an option: 1
Enter first number: 25.5
Enter second number: 14.5
Result: 40.0
```

## Concepts Demonstrated

- Classes and methods
- Encapsulation
- Separation of application and calculation logic
- BigDecimal for accurate decimal calculations
- Exception handling and input validation
- Unit testing

---

Made with Java.
