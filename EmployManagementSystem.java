import java.util.*;
import java.io.*;

// Simple console-based Employee Management System
// Stores each employee's details in a text file named after their ID

class MainMenu {
    public void show() {
        System.out.println("=======================================");
        System.out.println("        EMPLOYEE MANAGEMENT SYSTEM");
        System.out.println("=======================================");
        System.out.println("1. Add an Employee");
        System.out.println("2. View Employee Details");
        System.out.println("3. Remove an Employee");
        System.out.println("4. Update Employee Details");
        System.out.println("5. Exit");
        System.out.print("\nEnter choice: ");
    }
}

class EmployeeDetail {
    String name;
    String fatherName;
    String email;
    String position;
    String employeeId;
    String salary;
    String contact;

    public void readInfo(Scanner sc) {
        System.out.print("Enter employee's name       : ");
        name = sc.nextLine();
        System.out.print("Enter father's name         : ");
        fatherName = sc.nextLine();
        System.out.print("Enter employee ID            : ");
        employeeId = sc.nextLine();
        System.out.print("Enter email ID               : ");
        email = sc.nextLine();
        System.out.print("Enter position                : ");
        position = sc.nextLine();
        System.out.print("Enter contact number          : ");
        contact = sc.nextLine();
        System.out.print("Enter salary                   : ");
        salary = sc.nextLine();
    }
}

class EmployeeAdd {
    public void createFile(Scanner sc) {
        EmployeeDetail emp = new EmployeeDetail();
        emp.readInfo(sc);

        File file = new File("file" + emp.employeeId + ".txt");
        try {
            if (file.createNewFile()) {
                try (FileWriter writer = new FileWriter(file)) {
                    writer.write("Employee ID       : " + emp.employeeId + "\n"
                            + "Employee Name     : " + emp.name + "\n"
                            + "Father's Name     : " + emp.fatherName + "\n"
                            + "Contact Number    : " + emp.contact + "\n"
                            + "Email             : " + emp.email + "\n"
                            + "Position          : " + emp.position + "\n"
                            + "Salary            : " + emp.salary);
                }
                System.out.println("\nEmployee has been added successfully.");
            } else {
                System.out.println("\nAn employee with this ID already exists.");
            }
        } catch (IOException e) {
            System.out.println("Something went wrong while saving the file: " + e.getMessage());
        }

        System.out.print("\nPress Enter to continue...");
        sc.nextLine();
    }
}

class EmployeeShow {
    public void viewFile(String employeeId) {
        File file = new File("file" + employeeId + ".txt");

        if (!file.exists()) {
            System.out.println("\nNo employee found with ID: " + employeeId);
            return;
        }

        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not read the file: " + e.getMessage());
        }
    }
}

class EmployeeRemove {
    public void removeFile(String employeeId) {
        File file = new File("file" + employeeId + ".txt");

        if (!file.exists()) {
            System.out.println("\nEmployee does not exist.");
            return;
        }

        if (file.delete()) {
            System.out.println("\nEmployee has been removed successfully.");
        } else {
            System.out.println("\nCould not remove the employee. Please try again.");
        }
    }
}

class EmployeeUpdate {
    public void updateFile(String employeeId, String oldText, String newText) throws IOException {
        File file = new File("file" + employeeId + ".txt");
        StringBuilder content = new StringBuilder();

        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                content.append(sc.nextLine()).append("\n");
            }
        }

        // Using replace() instead of replaceAll() so special characters
        // in names/emails aren't treated as regex
        String updatedContent = content.toString().replace(oldText, newText);

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(updatedContent);
        }
    }
}

class CodeExit {
    public void exitProgram() {
        System.out.println("\n=======================================");
        System.out.println(" Thank you for using the EMS Portal :)");
        System.out.println("=======================================");
        System.exit(0);
    }
}

public class EmployManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MainMenu menu = new MainMenu();
        EmployeeShow viewer = new EmployeeShow();

        while (true) {
            menu.show();

            String input = sc.nextLine().trim();
            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("\nPlease enter a valid number between 1 and 5.\n");
                continue;
            }

            switch (choice) {
                case 1: {
                    EmployeeAdd add = new EmployeeAdd();
                    add.createFile(sc);
                    break;
                }
                case 2: {
                    System.out.print("\nEnter employee's ID: ");
                    String id = sc.nextLine();
                    viewer.viewFile(id);
                    System.out.print("\nPress Enter to continue...");
                    sc.nextLine();
                    break;
                }
                case 3: {
                    System.out.print("\nEnter employee's ID: ");
                    String id = sc.nextLine();
                    EmployeeRemove remove = new EmployeeRemove();
                    remove.removeFile(id);
                    System.out.print("\nPress Enter to continue...");
                    sc.nextLine();
                    break;
                }
                case 4: {
                    System.out.print("\nEnter employee's ID: ");
                    String id = sc.nextLine();
                    viewer.viewFile(id);

                    System.out.println("\nEnter the exact text you want to change,");
                    System.out.println("then the new text to replace it with.");
                    System.out.print("Current text : ");
                    String oldText = sc.nextLine();
                    System.out.print("New text     : ");
                    String newText = sc.nextLine();

                    EmployeeUpdate update = new EmployeeUpdate();
                    try {
                        update.updateFile(id, oldText, newText);
                        System.out.println("\nEmployee details updated successfully.");
                    } catch (IOException e) {
                        System.out.println("\nCould not update the employee: " + e.getMessage());
                    }

                    System.out.print("\nPress Enter to continue...");
                    sc.nextLine();
                    break;
                }
                case 5: {
                    CodeExit exit = new CodeExit();
                    exit.exitProgram();
                    break;
                }
                default: {
                    System.out.println("\nPlease enter a number between 1 and 5.\n");
                }
            }
        }
    }
}
