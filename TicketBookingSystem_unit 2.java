package Unit2;

class TicketBooking {
    private int availableSeats = 5;

    public synchronized void bookTickets(String name, int numSeats) {
        if (numSeats <= availableSeats) {
            System.out.println(name + " booked " + numSeats + " seat(s).");
            availableSeats -= numSeats;
        } else {
            System.out.println(name + " tried to book " + numSeats + " seat(s), but only " + availableSeats + " are available.");
        }
    }
}

class BookingThread extends Thread {
    TicketBooking bookingSystem;
    String name;
    int seats;

    BookingThread(TicketBooking b, String name, int seats, int priority) {
        this.bookingSystem = b;
        this.name = name;
        this.seats = seats;
        this.setPriority(priority);
    }

    public void run() {
        bookingSystem.bookTickets(name, seats);
    }
}

public class TicketBookingSystem {
    public static void main(String[] args) {
        TicketBooking booking = new TicketBooking();

        BookingThread user1 = new BookingThread(booking, "User1", 2, Thread.NORM_PRIORITY);
        BookingThread vip1 = new BookingThread(booking, "VIP1", 3, Thread.MAX_PRIORITY);

        vip1.start();
        user1.start();
    }
}
