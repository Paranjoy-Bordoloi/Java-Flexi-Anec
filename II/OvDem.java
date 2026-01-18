public class OvDem {

    void add(int a, int b) {
        System.out.println(a + b);
    }

    void add(int a, int b, int c) {
        System.out.println(a + b + c);
    }

    public static void main(String[] args) {
        OvDem calc = new OvDem();
        
        calc.add(5, 10);
        calc.add(5, 10, 15);
    }
}