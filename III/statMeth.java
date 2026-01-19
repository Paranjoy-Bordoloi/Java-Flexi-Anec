class Person {
    String name;

    void disp() {
        System.out.println("Name: " + name);
    }
}

public class statMeth {
    public static void main(String[] args) {
        Person p = new Person();
        p.name = "test";
        p.disp();
    }
}