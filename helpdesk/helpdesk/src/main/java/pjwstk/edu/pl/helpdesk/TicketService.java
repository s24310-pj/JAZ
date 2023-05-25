package pjwstk.edu.pl.helpdesk;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TicketService {

    private final TicketStorage ticketStorage;


    public TicketService(TicketStorage ticketStorage) {
        this.ticketStorage = ticketStorage;
    }

    public List<Ticket> getAllTickets() {
        return ticketStorage.getTicketList();
    }

    public Ticket getTicketById(int id) {
        return ticketStorage.findTicket(id);
    }

    public void addNewTicket(int id, Status status, Employee employee, Client client, String description) {
        ticketStorage.getTicketList().add(new Ticket(id, status, employee, client, description));
        System.out.println("Zgłoszenie zostało dodane");
    }

    public void changeStatus(int id, Status status) {
        ticketStorage.changeStatus(id, status);
        System.out.println("Status zgloszenia o id: " + id + " zostal zmieniony na: " + status);
    }

    public void changeEmployee(int id, Employee employee){
        ticketStorage.changeEmployee(id, employee);
        System.out.println("Pracownik zajmujacy sie zgloszeniem o id: " + id + " zostal zmieniony na pracownika o imieniu: " + employee.getName() );
    }


}
