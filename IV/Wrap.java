public class Wrap {
    public static void main(String[] args) {
        int a = 10;
        double b = 20.5;
        Integer intObj = a;
        Double doubleObj = b;
        System.out.println("Integer object: " + intObj);
        System.out.println("Double object: " + doubleObj);
        int x = intObj;
        double y = doubleObj;
        System.out.println("Primitive int: " + x);
        System.out.println("Primitive double: " + y);
        int max = Integer.max(a, 50);
        boolean parse = Boolean.parseBoolean("true");
        System.out.println("Max: " + max);
        System.out.println("Parsed boolean: " + parse);
        String str1 ="123";
        String str2="123";
        System.out.println("Answer is: "+(str1+str2));
        int s1= Integer.parseInt(str1);
        int s2= Integer.parseInt(str2);
        System.out.println("Answer is: "+(s1+s2));
    }
}
