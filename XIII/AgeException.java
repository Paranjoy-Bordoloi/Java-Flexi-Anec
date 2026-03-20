class InvalidAgeExceptions extends Exception {
    public InvalidAgeExceptions(String m) {
        super(m);
    }
}

public class AgeException {
    
    public static void validate(int m) throws InvalidAgeExceptions {
        if (m < 18) {
            throw new InvalidAgeExceptions("Age must be over 18.");
        }
        System.out.println("Valid age: " + m);
    }
    
    public static void main(String[] args) {
        try {
            validate(12);
        } catch (InvalidAgeExceptions e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }
    }
}