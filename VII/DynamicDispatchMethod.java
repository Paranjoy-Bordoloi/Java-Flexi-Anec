class parent{
    void show(){
        System.out.println("Parents show method");
    }
}

class child extends parent{
    @Override
    void show(){
        System.out.println("Child Show method");
    }
}
public class DynamicDispatchMethod {
    public static void main(String[] args) {
        parent obj = new child();
        obj.show();
    }
}
