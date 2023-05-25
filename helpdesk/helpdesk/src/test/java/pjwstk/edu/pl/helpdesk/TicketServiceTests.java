package pjwstk.edu.pl.helpdesk;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TicketServiceTests {

    private TicketStorage ticketStorage;

    private final TicketService ticketService = new TicketService(new TicketStorage());




    @Test
    void ShouldReturnTestOfId1(){
        //GIVEN
        int id = 1;

        //WHEN
        Ticket ticket = ticketService.getTicketById(id);

        //THEN
        assertThat(ticket).isEqualTo(ticketService.getTicketById(1));
    }

    @Test
    void ShouldChangeStatus(){
        //GIVEN
        int id = 1;
        Status status = Status.Closed;

        //WHEN
        ticketService.changeStatus(id, status);

        //THEN
        assertThat(ticketService.getTicketById(1).getStatus()).isEqualTo(Status.Closed);

    }

    @Test
    void ShouldChangeEmployee(){
        //GIVEN
        int id = 1;
        Employee employee = new Employee(6, "Tony", "Stark");

        //WHEN
        ticketService.changeEmployee(id, employee);

        //THEN
        assertThat(ticketService.getTicketById(1).getEmployee()).isEqualTo(employee);

    }

    @Test
    void ShouldAddNewTicket(){
        //GIVEN
        int id = 6;
        Status status = Status.WaitingToProcess;
        Employee employee = new Employee(6, "Tony", "Stark");
        Client client = new Client(7, "Steve", "Rogers");
        String description = "Problem z wojną domową";

        //WHEN
        ticketService.addNewTicket(id, status, employee, client, description);

        //THEN
        assertThat(ticketService.getTicketById(id)).isEqualTo(ticketService.getTicketById(6));

    }

    @Test
    void ShouldReturnNull(){
        //GIVEN
        int id = 999;

        //WHEN
        Ticket ticket = ticketService.getTicketById(id);

        //THEN
        assertThat(ticket).isNull();
    }



}
