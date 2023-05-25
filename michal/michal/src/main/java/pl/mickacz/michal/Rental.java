package pl.mickacz.michal;

public class Rental {


    private Car car;
    private User user;


    Rental(Car car, User user) {
        this.car = car;
        this.user = user;
    }

    public Car getCar() {
        return car;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "car=" + car +
                ", user=" + user +
                '}';
    }
}
