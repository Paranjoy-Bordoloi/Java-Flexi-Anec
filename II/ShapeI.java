class Shape {
    void draw() {
        System.out.println("Drawing shape");
    }
}
class Rectangle extends Shape {
    void drawRectangle() {
        System.out.println("Drawing rectangle");
    }
}
public class ShapeI {
    public static void main(String[] args) {

        Rectangle r = new Rectangle();

        r.draw();        
        r.drawRectangle(); 
    }
}
