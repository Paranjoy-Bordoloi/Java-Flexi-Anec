package XIV;
import java.util.ArrayList;
import java.util.List;

abstract class Transport {
    String trackingId;
    String destination;

    public Transport(String trackingId, String destination) {
        this.trackingId = trackingId;
        this.destination = destination;
    }

    public String getTrackingId() { return trackingId; }
    public String getDestination() { return destination; }

    public abstract void dispatch();
}

interface GPS {
    void getCoordinates();
}

interface Autonomous {
    void selfNavigate();
}

class DeliveryDrone extends Transport implements GPS, Autonomous {
    String coords;

    public DeliveryDrone(String trackingId, String destination, String coords) {
        super(trackingId, destination);
        this.coords = coords;
    }

    @Override
    public void dispatch() {
        System.out.println("Drone " + getTrackingId() + " taking off for " + getDestination());
    }

    @Override
    public void getCoordinates() {
        System.out.println("Drone GPS: " + coords);
    }

    @Override
    public void selfNavigate() {
        System.out.println("Drone " + getTrackingId() + " navigating autonomously.");
    }
}

class Truck extends Transport implements GPS {
    String coords;

    public Truck(String trackingId, String destination, String coords) {
        super(trackingId, destination);
        this.coords = coords;
    }

    @Override
    public void dispatch() {
        System.out.println("Truck " + getTrackingId() + " driving to " + getDestination());
    }

    @Override
    public void getCoordinates() {
        System.out.println("Truck GPS: " + coords);
    }
}

public class SmartD {
    public static void main(String[] args) {

        Transport t = new DeliveryDrone("D101", "NYC", "40.7128° N");
        t.dispatch();

        GPS g = new DeliveryDrone("D102", "LA", "34.0522° N");
        g.getCoordinates();


        List<Transport> fleet = new ArrayList<>();
        fleet.add(t);
        fleet.add(new Truck("T500", "London", "51.5074° N"));

        System.out.println("\n--- Processing Fleet ---");
        for (Transport vehicle : fleet) {
            vehicle.dispatch();
            
            if (vehicle instanceof GPS gps) {
                gps.getCoordinates();
            }
            
            if (vehicle instanceof Autonomous autonomous) {
                autonomous.selfNavigate();
            }
        }
    }
}