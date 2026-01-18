import java.util.Scanner;

public class DivC {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter two numbers: ");
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            if (b == 0) {
                System.out.println("Error: Cannot divide by zero");
            } else {
                System.out.println("Result = " + (double) a / b);
            }
        }
    }
}
