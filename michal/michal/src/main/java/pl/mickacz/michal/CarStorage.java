package pl.mickacz.michal;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarStorage {

    Car ford = new Car("Ford", "Mondeo", "aaa", CarType.PREMIUM);
    Car audi = new Car("Audi", "S8", "bbb", CarType.PREMIUM);
    Car opel = new Car("Opel", "Astra", "ccc", CarType.STANDARD);


    List<Car> carList = new ArrayList<>();

    public List<Car> getCarList() {
        return carList;
    }


    public CarStorage() {
        carList.add(ford);
        carList.add(audi);
        carList.add(opel);
        carList.add(new Car("Skoda", "Octavia", "ddd", CarType.STANDARD));
    }

    List<Car> getCars() {
        return carList;
    }

    public String findVin(String vin) {
        for (Car car : carList) {
            if (car.getVin().equals(vin)) {
                return car.getVin();
            }
        }
        return null;
    }

    public Car findCar(String vin) {
        for (Car car : carList) {
            if (car.getVin().equals(vin)) {
                return carList.get(carList.indexOf(car));
            }
        }
        return null;
    }


}
