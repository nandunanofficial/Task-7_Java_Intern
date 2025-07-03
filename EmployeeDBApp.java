package Task_7;

import java.sql.*;
import java.util.Scanner;

public class EmployeeDBApp {

    static final String DB_URL = "jdbc:mysql://localhost:3306/EmployeeDB";
    static final String DB_USER = "root";
    static final String DB_PASS = "root";

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Employee Database App ===");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = in.nextInt();
            in.nextLine(); // consume newline

            switch (choice) {
                case 1: addEmployee(in); break;
                case 2: viewEmployees(); break;
                case 3: updateEmployee(in); break;
                case 4: deleteEmployee(in); break;
                case 5:
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;
                default: System.out.println("Invalid choice.");
            }
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
    }

    public static void addEmployee(Scanner in) {
        System.out.print("Enter name: ");
        String name = in.nextLine();
        System.out.print("Enter department: ");
        String dept = in.nextLine();
        System.out.print("Enter salary: ");
        double salary = in.nextDouble();

        String sql = "INSERT INTO Employee (name, department, salary) VALUES (?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setString(2, dept);
            stmt.setDouble(3, salary);

            stmt.executeUpdate();
            System.out.println("Employee added!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void viewEmployees() {
        String sql = "SELECT * FROM Employee";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n--- Employee List ---");
            while (rs.next()) {
                System.out.printf("ID: %d, Name: %s, Dept: %s, Salary: %.2f\n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("department"),
                        rs.getDouble("salary"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateEmployee(Scanner in) {
        System.out.print("Enter Employee ID to update: ");
        int id = in.nextInt();
        in.nextLine();

        System.out.print("Enter new name: ");
        String name = in.nextLine();
        System.out.print("Enter new department: ");
        String dept = in.nextLine();
        System.out.print("Enter new salary: ");
        double salary = in.nextDouble();

        String sql = "UPDATE Employee SET name=?, department=?, salary=? WHERE id=?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setString(2, dept);
            stmt.setDouble(3, salary);
            stmt.setInt(4, id);

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Employee updated!");
            } else {
                System.out.println("Employee ID not found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteEmployee(Scanner in) {
        System.out.print("Enter Employee ID to delete: ");
        int id = in.nextInt();

        String sql = "DELETE FROM Employee WHERE id=?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Employee deleted!");
            } else {
                System.out.println("Employee ID not found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
