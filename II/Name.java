public class Name {
    public static void main(String[] args) {
        String s = "acb";
        String rev = "";
        String str = new StringBuilder(s).reverse().toString();
        System.out.println(str);    

        for (int i = s.length(); i > 0; i--) {
            rev += s.substring(i - 1, i);
        }

        System.out.println(rev);
    }
}