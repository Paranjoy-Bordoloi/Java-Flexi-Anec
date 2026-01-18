public class Expl {
    static float getSum(float a, float b) {
        return a + b;
    }

    public static void main(String[] args) {

        float x = 5.5f;
        float y = 4.3f;

        double result = getSum(x, y);

        System.out.println("Sum = " + result);
    }
}
