public class Exc {
    public static void main(String[] args){
        int num1 =10;
        int num2= 0;

        try {
            int result = num1/num2;
            System.out.println("Result :" + result);
        } catch (ArithmeticException e) {
            System.out.println("Error : Cannot divide by 0");
            System.out.println("Exception Message : " + e.getMessage());
        }
        System.out.println("Program continues after exception handling");
    }
}
