class Counter {
    static int sharedCount = 0; // Shared
    int instanceCount = 0;      // Unique

    void increment() {
        this.instanceCount++; // Correct for instance
        Counter.sharedCount++; // Recommended for static
    }
}