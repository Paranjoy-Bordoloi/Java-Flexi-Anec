public class CLIP {

    static int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);
        System.out.println(add(x, y));
    }
}


// Java excludes explicit pointers primarily to enforce memory safety and robustness, replacing direct memory manipulation with an 
// abstraction layer called References. In languages like C++, raw pointers allow for "pointer arithmetic" (e.g., ptr++), 
// which enables a programmer to navigate memory addresses directly; however, this creates significant risks like buffer overflows, 
// dangling pointers, and unauthorized memory access. By removing these, Java ensures that the Java Virtual Machine (JVM) maintains 
// total control over the lifecycle of an object. This control is essential for the Garbage Collector, which must be free to move objects 
// around in the "Heap" to optimize memory without breaking the developer's code. Consequently, while Java handles pointers internally to 
// manage object relationships, it hides the raw memory addresses from the developer to prevent manual memory management errors and to 
// ensure that a program cannot crash the entire operating system through a corrupted memory reference.
