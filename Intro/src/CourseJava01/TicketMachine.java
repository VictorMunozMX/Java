package CourseJava01;

public class TicketMachine {

    public static void main(String[] args) {

        Ticket ticket = new Ticket();
        ticket.setDestination("NY");
        ticket.setPrice(15.30);
        ticket.setReturn(true);

        System.out.println("Destination: " + ticket.getDestination());
        System.out.println("Price: " + ticket.getPrice());
        System.out.println("Return: " + ticket.getReturn());
    }
}
