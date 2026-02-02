class finalvar{
    final int MAX=100;

    void display(){
        System.out.println("MAX Value is :"+MAX);
    }

    public static void main(String[] args){
        finalvar obj= new finalvar();
        obj.display();
    }
}