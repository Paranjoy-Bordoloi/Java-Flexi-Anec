class Students{
    String name;
    int age;

    Students(String a,int b){
        name = a;
        age = b;
    }

    void display(){
        System.out.println("Name " + name + ",Age " + age);
    }
}


public class Student{
    public static void main(String[] args){
        Students student1 = new Students("Alice",21);
        student1.display();
    }
}