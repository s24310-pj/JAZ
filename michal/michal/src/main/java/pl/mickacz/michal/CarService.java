package pl.mickacz.michal;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

@Component
public class CarService {

    private final CarStorage carStorage;
    private final RentalStorage rentalStorage;


    public CarService(CarStorage carStorage, RentalStorage rentalStorage) {
        this.carStorage = carStorage;
        this.rentalStorage = rentalStorage;
    }

    public List<Car> getAllCars() {
        return carStorage.getCarList();
    }

    public List<Rental> getAllRentals() {
        return rentalStorage.getRentalList();
    }


    private double calculation(long days, CarType carType) {

        double price = 100;
        double multiplier = 0;

        if (carType.equals(CarType.STANDARD)) {
            multiplier = 1;
        } else if (carType.equals(CarType.PREMIUM)) {
            multiplier = 1.5;
        }

        return price * days * multiplier;
    }

    public RentalInfo rentCar(User user, String vin, LocalDate startDate, LocalDate endDate) {
        Car car = carStorage.findCar(vin);
        long days = ChronoUnit.DAYS.between(startDate, endDate);
        double price = 0;
        boolean reserved = false;

        if(car == null)
        {
            System.out.println("taki vin nie istnieje");
            return null;
        }

        if (days <= 0) {
            System.out.println("Data poczatkowa jest pozniej niz data koncowa");
            return null;
        } else {
            if (vin.equals(carStorage.findVin(vin))) {
                for (int i = 0; i < rentalStorage.getRentalList().size(); i++) {
                    if (carStorage.findVin(vin).equals(rentalStorage.getRentalList().get(i).getCar().getVin())) {
                        System.out.println("Ten samochod jest juz zarezerwowany");
                        reserved = true;
                        return null;
                    }
                }
                if (!reserved) {
                    price = calculation(days, car.getCarType());
                    rentalStorage.getRentalList().add(new Rental(car, user));
                    System.out.println("Uzytkownik: " + user.getAccId() + " wynajal samochod o nr vin: " + vin + "(" + car.getMake() + ")");
                    System.out.println("Ilosc dni: " + days);
                    System.out.println("Cena: " + price);
                }
            } else {
                System.out.println("Nie ma takiego samochodu");
                return null;
            }
            return new RentalInfo(price, startDate, endDate);
        }
    }


}
