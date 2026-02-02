class parent{
    final void display(){
        System.out.println("final method in parent class");
    }
}

class child extends parent{

}

public class finalmethod {
    public static void main(String[] args){
        child c = new child();
        c.display();
    }
}   