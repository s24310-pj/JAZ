package pjwstk.edu.pl.helpdesk;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TicketServiceIntegrationTests {

    @MockBean
    private TicketStorage ticketStorage;

    @Autowired
    private TicketService ticketService;





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
    void ShouldChangeStatusMock(){

        //GIVEN
        int id = 1;
        Status status = Status.Closed;

        //WHEN
        when(ticketService.getTicketById(1)).thenReturn(new Ticket(1, status, new Employee(2, "Adam", "Nowak"), new Client(1, "Jan", "Kowalski"), "Problem z polaczeniem sie do bazy danych"));
        ticketService.changeStatus(id, status);

        //THEN
        assertThat(ticketService.getTicketById(id).getStatus()).isEqualTo(status);

    }

    @Test
    void ShouldChangeEmployeeMock(){

        //GIVEN
        int id = 1;
        Employee employee = new Employee(6, "Tony", "Stark");


        //WHEN
        when(ticketService.getTicketById(id)).thenReturn(new Ticket(1, Status.Closed, employee, new Client(1, "Jan", "Kowalski"), "Problem z polaczeniem sie do bazy danych"));
        ticketService.changeEmployee(id, employee);

        //THEN
        assertThat(ticketService.getTicketById(id).getEmployee()).isEqualTo(employee);

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