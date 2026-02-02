abstract class Calculator {
    abstract double calculate(double a, double b);
}

class Addition extends Calculator {
    @Override
    double calculate(double a, double b) {
        return a + b;
    }
}

class Subtraction extends Calculator {
    @Override
    double calculate(double a, double b) {
        return a - b;
    }
}

class Multiplication extends Calculator {
    @Override
    double calculate(double a, double b) {
        return a * b;
    }
}

class Division extends Calculator {
    @Override
    double calculate(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Division by zero");
            return 0;
        }
        return a / b;
    }
}

public class CalcApp {
    public static void main(String[] args) {
        Calculator add = new Addition();
        Calculator sub = new Subtraction();
        Calculator mult = new Multiplication();
        Calculator div = new Division();

        System.out.println("Addition: " + add.calculate(20, 10));
        System.out.println("Subtraction: " + sub.calculate(20, 10));
        System.out.println("Multiplication: " + mult.calculate(20, 10));
        System.out.println("Division: " + div.calculate(20, 10));
    }
}