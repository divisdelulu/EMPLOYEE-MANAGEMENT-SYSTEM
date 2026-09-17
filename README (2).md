# Employee Management System

A simple console-based Employee Management System written in Java. Each employee's
details are stored in a plain text file named after their employee ID.

## Features

- Add a new employee's details
- View an existing employee's details
- Update an employee's details
- Remove an employee
- Exit the program

## How It Works

Every employee is saved as a separate text file called `file<EmployeeID>.txt` in the
same directory the program is run from, containing:

- Employee ID
- Employee Name
- Father's Name
- Contact Number
- Email
- Position
- Salary

## Requirements

- Java Development Kit (JDK) 8 or higher

## How to Run

1. Compile the program:
   ```bash
   javac EmployManagementSystem.java
   ```
2. Run it:
   ```bash
   java EmployManagementSystem
   ```

## Using the Menu

When you run the program, you'll see:

```
1. Add an Employee
2. View Employee Details
3. Remove an Employee
4. Update Employee Details
5. Exit
```

Enter the number corresponding to the action you want, then follow the prompts.

### Updating an Employee

Option 4 shows you the employee's current details first. Enter the exact text you
want to change, then the new text to replace it with. For example, to change an
employee's position from `Manager` to `Senior Manager`, you'd type `Manager` as the
current text and `Senior Manager` as the new text.

## Notes

- Employee records are plain text files, so anyone with access to the program's
  directory can read or edit them directly.
- IDs are used as file names, so each employee ID must be unique.
- This project is meant as a learning exercise in Java file handling and console
  I/O, not as a production-ready HR system.

## Author

Shrikant Nimbhorkar
25BAI10434

