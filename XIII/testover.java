class parent{
    void show(){
        System.out.println("Parent class show method.");
    }
}

class child extends parent{
    @Override
    void show(){
        System.out.println("Child class show method");
    }
}

public class testover{
    public static void main(String [] args){
        parent d1= new child();
        d1.show();
    }
}