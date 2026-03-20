import java.util.ArrayList;

public class arraylist{
    public static void main(String [] args){
        ArrayList<String> mylist = new ArrayList<>();
        mylist.add("Testing");
        mylist.add("Hello World");
        System.out.println(mylist);
        for(String i : mylist){System.out.println(i);}
        for(int i = 0 ; i<mylist.size() ; i++){System.out.println(mylist.get(i));}
        mylist.forEach(System.out::println);
    }
}