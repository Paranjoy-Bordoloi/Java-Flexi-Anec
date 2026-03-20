abstract class Payment{
    private String transactionid;
    private double amount;

    public Payment(String transactionid, double amount){
        this.transactionid = transactionid;
        this.amount = amount;
    }

    public String gettransactionid(){
        return transactionid;
    }

    public double getamount(){
        return amount;
    }
    public abstract double processpayment();
}

class ccpay extends Payment{
    public ccpay (String transactionid , double amount){
        super(transactionid, amount);
    }

    @Override
    public double processpayment(){
        return getamount()*1.02;
    }
}

class upipay extends Payment{
    private String upiid;
    public upipay(String upiid , String transactionid , double amount){
        super(transactionid,amount);
        this.upiid= upiid;
    }

    @Override
    public double processpayment(){
        return getamount();
    }
}

class payprocess{
    public void execute(Payment p){
        System.out.println("Processing ID : "+ p.gettransactionid());
        System.out.println("Final Bill Including fees : $" + p.processpayment());
        System.out.println("----------------------------------------");
    }
}

public class PaymentGate{
    public static void main(String[] args) {
        payprocess processor = new payprocess();
        Payment cc = new ccpay("TXN1209412", 1000);
        Payment upi = new upipay("user@okaxis", "TXN130214" , 2000);
        Payment [] paylist = {cc,upi};
        double totalbal =0 ;
        System.out.println("Gateway report : ");
        for (Payment p : paylist){
            processor.execute(p);
            totalbal+=p.processpayment();
        }
        System.out.println("Final total processed amount is  : " + totalbal);

    }
}