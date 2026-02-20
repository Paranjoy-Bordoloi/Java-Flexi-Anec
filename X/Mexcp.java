
class Mexcp {
    public static void main(String[] args) {
        String s = "";

        try {
            System.out.println(getLength(s));
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException caught");
        }

        s = null;

        try {
            System.out.println(getLength(s));
        } catch (IllegalArgumentException e) {
            System.out.println("Fatal Error: " + e.getMessage());
            System.out.println("Exiting..");
            System.exit(1); 
        }

        s = "test";
        
        try {
            System.out.println(getLength(s));
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException caught");
        }
    }

    

    public static int getLength(String s) {
        if (s == null) {
            throw new IllegalArgumentException("The argument cannot be null");
        }

        return s.length();
    }
}