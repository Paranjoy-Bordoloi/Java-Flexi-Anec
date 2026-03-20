abstract class Animal {
    public abstract void makeSound();
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof");
    }
}

class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Meow"); 
    }
}

public class Main {
    public static void main(String[] args) {
        Animal myPet = new Dog();
        myPet.makeSound();

        myPet = new Cat();
        myPet.makeSound();
    }
}