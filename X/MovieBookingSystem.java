class SeatNotAvailableException extends Exception {
    public SeatNotAvailableException(String message) {
        super(message);
    }
}

public class MovieBookingSystem {
    private static boolean[] seats = new boolean[10];

    public static void bookSeat(int seatNumber) throws SeatNotAvailableException {
        if (seatNumber < 0 || seatNumber >= seats.length) {
            throw new IllegalArgumentException("Invalid seat number!");
        }

        if (seats[seatNumber]) {
            throw new SeatNotAvailableException("Seat " + seatNumber + " is already taken.");
        }

        seats[seatNumber] = true;
        System.out.println("Successfully booked seat: " + seatNumber);
    }

    public static void main(String[] args) {
        try {
            bookSeat(4);
            bookSeat(4);
        } catch (SeatNotAvailableException e) {
            System.out.println("Booking Failed: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Input Error: " + e.getMessage());
        }
    }
}