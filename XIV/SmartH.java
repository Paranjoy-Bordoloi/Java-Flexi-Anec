package XIV;
abstract class device{
    String brand;
    public device(String brand){
        this.brand=brand;
    }
    abstract void turnon();
}

interface remotecontrollable{
    void connecttowifi();
}

interface powersaving{
    int powerrating();
}

class smarttv extends device implements remotecontrollable,powersaving{
    public smarttv(String m){
        super(m);
    }

    @Override
    public void turnon(){
        System.out.println("The tv turns on. . . ");
    }
    @Override
    public void connecttowifi(){
        System.out.println("The tv connects to wifi . . .");
    }
    @Override
    public int powerrating(){
        return 5;
    }
}

class electrickettle extends device{
    public electrickettle(String m){
        super(m);
    }

    @Override
    public void turnon(){
        System.out.println("The electric kettle starts heating up . . . ");
    }
}

public class SmartH{
    public static void main(String[] args) {
        System.out.println("Device 1 (Smart Tv reference) :");
        device d = new smarttv("LG");
        device d2 = new electrickettle("Havells");

        d.turnon();

        System.out.println("Interface rerference (Remote Controllable) :");
        remotecontrollable r = new smarttv("Sony");
        r.connecttowifi();
        // r.turnon();
        System.out.println("r.turnon(); failed to compile as the interface remote controllable has no relation to the method turnon");
        System.out.println("Interface reference (Power saving)");
        powersaving s = new smarttv("Sony");
        System.out.println("The power rating of the TV is "+s.powerrating() + " stars " );

        d2.turnon();
    }
}