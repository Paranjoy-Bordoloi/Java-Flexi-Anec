import java.util.ArrayList;
import java.util.List;

class Student {
    private String name;
    private List<Double> grades;

    public Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    public void addGrade(double grade) {
        grades.add(grade);
    }

    public double calculateAverage() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }

    public void displayStudentDetails() {
        System.out.println("Student: " + name);
        System.out.println("Grades: " + grades);
        System.out.printf("Average: %.2f%n", calculateAverage());
        System.out.println("---------------------------");
    }

    public String getName() {
        return name;
    }
}

class GradeManager {
    private List<Student> students;

    public GradeManager() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Student findStudentByName(String name) {
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                return student;
            }
        }
        return null;
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        for (Student student : students) {
            student.displayStudentDetails();
        }
    }
}

public class GradeSystem {
    public static void main(String[] args) {
        GradeManager manager = new GradeManager();

        Student s1 = new Student("Aks");
        s1.addGrade(85.5);
        s1.addGrade(90.0);
        s1.addGrade(78.0);

        Student s2 = new Student("B2");
        s2.addGrade(70.0);
        s2.addGrade(65.5);

        manager.addStudent(s1);
        manager.addStudent(s2);

        System.out.println("All Student Records:");
        manager.displayAllStudents();

        String searchName = "Aks";
        Student found = manager.findStudentByName(searchName);
        if (found != null) {
            System.out.println("Found Record for " + searchName + ":");
            found.displayStudentDetails();
        }
    }
}