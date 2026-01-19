class University {
    String studentName;              
    static String college = "MIT";   

    void show() {
        System.out.println(studentName + " : " + college);
    }

    static void changeCollege() {
        college = "Stanford";
    }
}

public class inststatdemo {
    public static void main(String[] args) {
        University.changeCollege();

        University s1 = new University();
        s1.studentName = "Alice";

        University s2 = new University();
        s2.studentName = "Bob";

        s1.show();
        s2.show();
    }
}