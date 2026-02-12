import java.util.ArrayList;
import java.util.List;

class Employee {
    private String employeeId;
    private String name;
    private String role;
    private double baseSalary;
    private double deductions = 0;

    public Employee(String employeeId, String name, String role, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.role = role;
        this.baseSalary = baseSalary;
    }

    public double calculateSalary() {
        double salary;
        switch (role.toLowerCase()) {
            case "manager":
                salary = baseSalary + (baseSalary * 0.20);
                break;
            case "developer":
                salary = baseSalary + (baseSalary * 0.10);
                break;
            case "designer":
                salary = baseSalary + (baseSalary * 0.05);
                break;
            case "intern":
                salary = 1000.00;
                break;
            default:
                salary = baseSalary;
        }
        return salary - deductions;
    }

    public void applyDeduction(double amount) {
        this.deductions += amount;
    }

    public void displayEmployeeDetails() {
        System.out.printf("ID: %-5s | Name: %-10s | Role: %-10s | Final Salary: $%.2f%n", 
                          employeeId, name, role, calculateSalary());
    }

    public String getEmployeeId() {
        return employeeId;
    }
}

class Payroll {
    private List<Employee> employees;

    public Payroll() {
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void calculateAllSalaries() {
        System.out.println("\n--- Monthly Payroll Report ---");
        for (Employee emp : employees) {
            emp.displayEmployeeDetails();
        }
    }

    public Employee findEmployeeById(String employeeId) {
        for (Employee emp : employees) {
            if (emp.getEmployeeId().equals(employeeId)) {
                return emp;
            }
        }
        return null;
    }
}

public class PayrollSystem {
    public static void main(String[] args) {
        Payroll payroll = new Payroll();

        Employee emp1 = new Employee("E001", "A_1", "Manager", 5000);
        Employee emp2 = new Employee("E002", "A_2", "Developer", 4000);
        Employee emp3 = new Employee("E003", "A_3", "Intern", 0);
        
        payroll.addEmployee(emp1);
        payroll.addEmployee(emp2);
        payroll.addEmployee(emp3);

        // Applying a deduction to the Developer
        emp2.applyDeduction(150.00);

        payroll.calculateAllSalaries();

        // Testing Search
        System.out.println("\nSearching for Employee E001...");
        Employee found = payroll.findEmployeeById("E001");
        if (found != null) {
            found.displayEmployeeDetails();
        }
    }
}