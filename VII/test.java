class test{
    public static void main(String[] args){
        test obj = new test();
        obj=null;
        System.gc();
    }
}
