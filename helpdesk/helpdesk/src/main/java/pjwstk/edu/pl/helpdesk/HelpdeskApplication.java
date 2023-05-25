package pjwstk.edu.pl.helpdesk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelpdeskApplication {

    public HelpdeskApplication(TicketService ticketService) {
        System.out.println(ticketService.getAllTickets());
        //System.out.println(ticketService.getTicketById(2));
        //ticketService.addNewTicket(5, Status.WaitingForProcess, new Employee(4, "Vin", "Lpg"), new Client(5, "Brian", "Nocorner"), "Problem z odpaleniem silnika");
        //System.out.println(ticketService.getTicketById(5));
        //ticketService.changeStatus(1, Status.Closed);
        //System.out.println(ticketService.getTicketById(1));
        //ticketService.changeEmployee(1, new Employee(5, "Marek", "Wita"));
        //System.out.println(ticketService.getTicketById(1));
    }


    public static void main(String[] args) {
        SpringApplication.run(HelpdeskApplication.class, args);
    }

}
