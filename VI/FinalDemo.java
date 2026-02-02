final class SecuritySystem {
    final int AUTH_CODE = 9988;

    final void displayCode() {
        System.out.println("The secure access code is: " + AUTH_CODE);
    }
}

public class FinalDemo {
    public static void main(String[] args) {
        SecuritySystem sys = new SecuritySystem();
        sys.displayCode();
    }
}