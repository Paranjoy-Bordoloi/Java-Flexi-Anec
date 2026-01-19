import java.util.Scanner;

class Calculator {
    double num1;
    double num2;

    Calculator(double n1, double n2) {
        num1 = n1;
        num2 = n2;
    }

    void calculate(int choice) {
        switch (choice) {
            case 1 -> System.out.println("Result: " + (num1 + num2));
            case 2 -> System.out.println("Result: " + (num1 - num2));
            case 3 -> System.out.println("Result: " + (num1 * num2));
            case 4 -> {
                if (num2 != 0) {
                    System.out.println("Result: " + (num1 / num2));
                } else {
                    System.out.println("Error: Division by zero");
                }
            }
            default -> System.out.println("Invalid choice");
        }
    }
}

public class SwCalcSc {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter first number: ");
            double a = sc.nextDouble();
            System.out.print("Enter second number: ");
            double b = sc.nextDouble();
            
            Calculator calc = new Calculator(a, b);
            
            System.out.println("1. Add\n2. Sub\n3. Mult\n4. Div");
            System.out.print("Select operation: ");
            int choice = sc.nextInt();
            
            calc.calculate(choice);
        }
    }
}