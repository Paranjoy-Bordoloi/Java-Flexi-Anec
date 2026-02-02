abstract class Animal{
    abstract void sound();
    void eat(){
        System.out.println("This animal eats food.");
    }
}

class dog extends Animal{
    void sound(){
        System.out.println("Dog barks.");
    }
}

public class ABSMEX{
    public static void main(String[] args){
        Animal animal = new dog();
        animal.sound();
        animal.eat();
    }
}