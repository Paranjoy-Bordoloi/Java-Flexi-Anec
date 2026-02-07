import java.lang.reflect.Array;
import java.util.ArrayList;

public class ArrayListExample{
    public static void main(String[] args) {
        ArrayList<String> fruits = new ArrayList<>();

        fruits.add("Apple");
        fruits.add("banana");
        fruits.add("cherry");

        System.out.println("Fruits :"+fruits);
        fruits.remove("banana");
        System.out.println("After removing banana :" + fruits);
        System.out.println("Size  "+fruits.size());
        System.out.println("Contains Apple? "+fruits.contains("Apple"));
    }
}