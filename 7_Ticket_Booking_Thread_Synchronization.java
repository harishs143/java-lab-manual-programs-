public class Ticket_Booking_Thread_Synchronization {
    static class TicketCounter {
        private int availableTickets = 5;
        synchronized void bookTicket(String passenger, int numberOfTickets) {
            System.out.println(passenger + " is trying to book " + numberOfTickets + " ticket(s).");
            if (numberOfTickets <= availableTickets) {
                System.out.println("Booking successful for " + passenger);
                availableTickets -= numberOfTickets;
                System.out.println("Tickets remaining: " + availableTickets);
            } else {
                System.out.println("Booking failed for " + passenger + ": only " + availableTickets + " ticket(s) available.");
            }
            System.out.println();
        }
    }
    static class BookingThread extends Thread {
        private TicketCounter counter; private String passenger; private int tickets;
        BookingThread(TicketCounter counter, String passenger, int tickets) { this.counter=counter; this.passenger=passenger; this.tickets=tickets; }
        @Override public void run() { counter.bookTicket(passenger, tickets); }
    }
    public static void main(String[] args) {
        System.out.println("=== TICKET BOOKING USING MULTITHREADING & SYNCHRONIZATION ===");
        TicketCounter counter = new TicketCounter();
        Thread t1 = new BookingThread(counter, "Arun", 2);
        Thread t2 = new BookingThread(counter, "Priya", 2);
        Thread t3 = new BookingThread(counter, "Kumar", 2);
        t1.start(); t2.start(); t3.start();
        try { t1.join(); t2.join(); t3.join(); }
        catch (InterruptedException e) { Thread.currentThread().interrupt(); System.out.println("Main thread interrupted."); }
        System.out.println("All booking threads completed.");
    }
}