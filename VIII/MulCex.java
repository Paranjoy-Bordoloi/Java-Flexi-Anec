public class MulCex{
    public static void main(String[] args) {
        try {
            String str = null;
            System.out.println(str.length());
        } catch (NullPointerException e) {
            System.out.println("Error : Null pointer exception! Object is Null.");
        } catch(Exception e){
            System.out.println("Some other error ocurred.");
        }
        System.out.println("Program continues after exception handling.");
    }
}