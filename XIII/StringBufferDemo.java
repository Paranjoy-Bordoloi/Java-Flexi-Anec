public class StringBufferDemo {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("Hello");
        
        sb.append(" World");
        System.out.println(sb);
        
        sb.insert(5, " Beautiful");
        System.out.println(sb);
        
        sb.delete(5, 15);
        System.out.println(sb);
        
        sb.reverse();
        System.out.println(sb);
    }
}