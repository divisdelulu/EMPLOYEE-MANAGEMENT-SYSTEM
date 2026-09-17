# EMPLOYEE-MANAGEMENT-SYSTEM# Employee Management System

A simple Java-based Employee Management System that runs on the console. The project allows users to add, view, update, and remove employee records. Each employee's information is saved in a separate text file using their employee ID.

## Features

The system provides the following options:

- Add a new employee
- View employee details
- Update employee information
- Remove an employee
- Exit the program

## How the Project Works

When a new employee is added, their details are saved in a separate text file. The file name is created using the employee's ID.

The following information is stored:

- Employee ID
- Employee Name
- Father's Name
- Contact Number
- Email
- Position
- Salary

This makes it easy to find and manage individual employee records.

## Requirements

To run this project, you need:

- Java Development Kit (JDK) 8 or above

## How to Run

First, open the project folder in the terminal and compile the Java file:

```bash
javac EmployManagementSystem.java
```

After successful compilation, run the program using:

```bash
java EmployManagementSystem
```

## Main Menu

After running the program, the following menu will appear:

```text
1. Add an Employee
2. View Employee Details
3. Remove an Employee
4. Update Employee Details
5. Exit
```

Simply enter the number of the option you want to use and follow the instructions shown on the screen.

## Updating Employee Details

The update option first displays the employee's existing information. You can then enter the information you want to change along with the new value.

For example, if an employee's position is currently **Manager** and you want to change it to **Senior Manager**, you enter:

```text
Current: Manager
New: Senior Manager
```

The program then updates the employee's record accordingly.

## Notes

- Employee records are stored as normal text files, so they can also be opened or edited manually.
- Every employee must have a unique ID because the ID is used as the file name.
- This project is mainly created to practice **Java file handling and console-based input/output**. It is a learning project and is not intended to be used as a complete HR management system.

## Author

**Divyanshi Gupta**  
**25BAI10841**
