class Employee {
    String role = "Staff";

    void work() {
        System.out.println("Employee is performing general tasks.");
    }
}

class Developer extends Employee {
    String role = "Developer";

    void work() {
        super.work(); 
        System.out.println("Developer is writing code.");
    }

    void identify(String role) {
        System.out.println("Local parameter: " + role);
        System.out.println("Current class field (this): " + this.role);
        System.out.println("Parent class field (super): " + super.role);
    }
}

public class SupThis {
    public static void main(String[] args) {
        Developer dev = new Developer();
        dev.work();
        dev.identify("Intern");
    }
}