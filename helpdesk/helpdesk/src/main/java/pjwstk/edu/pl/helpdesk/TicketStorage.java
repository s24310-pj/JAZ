package pjwstk.edu.pl.helpdesk;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TicketStorage {

    Ticket ticket1 = new Ticket(1, Status.WaitingToProcess, new Employee(2, "Adam", "Nowak"), new Client(1, "Jan", "Kowalski"), "Problem z polaczeniem sie do bazy danych");
    Ticket ticket2 = new Ticket(2, Status.Processing, new Employee(2, "Adam", "Nowak"), new Client(2, "Marian", "Kozak"), "Nie dzialajaca usluga dekodowania TV");
    Ticket ticket3 = new Ticket(3, Status.WaitingForResponse, new Employee(1, "Krzystof", "Koks"), new Client(3, "Jacek", "Marchlewski"), "Reklamacja dotyczaca predkosci polaczenia");
    Ticket ticket4 = new Ticket(4, Status.Closed, new Employee(3, "Masny", "Ben"), new Client(4, "Karol", "Wisniewski"), "Problem z prawami autorskimi teledysku");


    List<Ticket> ticketList = new ArrayList<>();

    public List<Ticket> getTicketList() {
        return ticketList;
    }


    public TicketStorage() {
        ticketList.add(ticket1);
        ticketList.add(ticket2);
        ticketList.add(ticket3);
        ticketList.add(ticket4);
    }

    public Ticket findTicket(int id) {
        for (Ticket ticket : ticketList) {
            if (ticket.getId() == (id)) {
                return ticketList.get(ticketList.indexOf(ticket));
            }
        }
        System.out.println("nie ma zgloszenia o takim id");
        return null;
    }

    public void changeStatus(int id, Status status) {
        for (Ticket ticket : ticketList) {
            if (ticket.getId() == (id)) {
                ticket.setStatus(status);
            }
        }
    }

    public void changeEmployee(int id, Employee employee) {
        for (Ticket ticket : ticketList) {
            if (ticket.getId() == (id)) {
                ticket.setEmployee(employee);
            }
        }
    }


}
