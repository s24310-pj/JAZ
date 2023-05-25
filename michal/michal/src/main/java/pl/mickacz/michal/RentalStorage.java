package pl.mickacz.michal;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RentalStorage {

    CarStorage carStorage = new CarStorage();

    Rental tomorrow = new Rental(new Car("Bentley", "Continental", "fff", CarType.PREMIUM), new User("11111"));
    Rental two = new Rental( carStorage.ford, new User("12345"));


    List<Rental> rentalList = new ArrayList<>();

    public List<Rental> getRentalList() {
        return rentalList;
    }


    RentalStorage()
    {
        rentalList.add(tomorrow);
        rentalList.add(two);
    }


}
