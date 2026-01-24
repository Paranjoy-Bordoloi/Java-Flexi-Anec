class Test{
    void mod(int x){
        x=x+10;
    }
    public static void main(String [] args){
        int a = 5;
        Test obj = new Test();
        obj.mod(a);
        System.out.println(a);
    }
}

