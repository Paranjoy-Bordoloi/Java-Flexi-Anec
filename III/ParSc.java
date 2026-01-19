import java.util.Scanner;

class StudentData {
    String name;
    int rollNo;
    long prn;
    static String clgname = "ABC";

    StudentData(String n, int r, long p) {
        name = n;
        rollNo = r;
        prn = p;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNo);
        System.out.println("PRN: " + prn);
        System.out.println("College Name :"+ clgname);
    }
}

public class ParSc {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            
            System.out.print("Enter Roll No: ");
            int rollNo = sc.nextInt();
            
            System.out.print("Enter PRN: ");
            long prn = sc.nextLong();
            
            StudentData s1 = new StudentData(name, rollNo, prn);
            s1.display();
        }
    }
}