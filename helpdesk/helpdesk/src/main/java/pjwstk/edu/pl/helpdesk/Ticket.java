package pjwstk.edu.pl.helpdesk;


public class Ticket {

    private int id;
    private Status status;
    private Employee employee;
    private Client client;
    private String description;

    public Ticket(int id, Status status, Employee employee, Client client, String description) {
        this.id = id;
        this.status = status;
        this.employee = employee;
        this.client = client;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Client getClient() {
        return client;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", status=" + status +
                ", employee=" + employee +
                ", client=" + client +
                ", description='" + description + '\'' +
                '}';
    }
}
