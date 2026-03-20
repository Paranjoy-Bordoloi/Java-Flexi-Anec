
abstract class shape{
    abstract void draw();
}

class square extends shape{
    @Override
    void draw(){
        System.out.println("Im a square.");
    }
}

class circle extends shape{
    @Override
    void draw(){
        System.out.println("Im a circle.");
    }
}

public class ABS{
    public static void main(String [] args){
        shape S1 = new square();
        S1.draw();
        shape S2 = new circle();
        S2.draw();
    }
}