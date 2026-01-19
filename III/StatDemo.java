class counter{
    static int count = 0;
    counter(){
        count++;
        System.out.println("Object Created Count: "+count);
    }
}
public class StatDemo{
    public static void main(String [] args){
        counter obj1= new counter();
        counter obj2= new counter();
        counter obj3= new counter();

        System.out.println("");
    }
}