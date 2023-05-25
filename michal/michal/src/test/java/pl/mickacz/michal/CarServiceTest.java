package pl.mickacz.michal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarServiceTest {

    private CarStorage carstorage;
    private RentalStorage rentalstorage;

    private final CarService carService = new CarService(new CarStorage(), new RentalStorage());


    @Test
    void shouldReturnPriceStandard() {

        //GIVEN
        User user = new User("1");
        String vin = "ccc";
        LocalDate startDate = LocalDate.of(2022, 12, 1);
        LocalDate endDate = LocalDate.of(2022, 12, 11);

        //WHEN
        RentalInfo rentalInfo = carService.rentCar(user, vin, startDate, endDate);

        //THEN
        assertThat(rentalInfo.getPrice()).isEqualTo(1000);
    }

    @Test
    void shouldReturnPricePremium() {
        //GIVEN
        User user = new User("1");
        String vin = "bbb";
        LocalDate startDate = LocalDate.of(2022, 12, 1);
        LocalDate endDate = LocalDate.of(2022, 12, 11);

        //WHEN
        RentalInfo rentalInfo = carService.rentCar(user, vin, startDate, endDate);

        //THEN
        assertThat(rentalInfo.getPrice()).isEqualTo(1500);
    }

    @Test
    void endDateLaterThanStartDate() {
        //GIVEN
        User user = new User("1");
        String vin = "bbb";
        LocalDate startDate = LocalDate.of(2022, 12, 22);
        LocalDate endDate = LocalDate.of(2022, 12, 11);

        //WHEN
        RentalInfo rentalInfo = carService.rentCar(user, vin, startDate, endDate);

        //THEN
        assertThat(rentalInfo).isNull();
    }

    @Test
    void carAlreadyReserved() {
        //GIVEN
        User user = new User("1");
        String vin = "aaa";
        LocalDate startDate = LocalDate.of(2022, 12, 1);
        LocalDate endDate = LocalDate.of(2022, 12, 11);

        //WHEN
        RentalInfo rentalInfo = carService.rentCar(user, vin, startDate, endDate);

        //THEN
        assertThat(rentalInfo).isNull();
    }

    @Test
    void vinIsNull() {
        //GIVEN
        User user = new User("1");
        String vin = null;
        LocalDate startDate = LocalDate.of(2022, 12, 1);
        LocalDate endDate = LocalDate.of(2022, 12, 11);

        //WHEN
        RentalInfo rentalInfo = carService.rentCar(user, vin, startDate, endDate);

        //THEN
        assertThat(rentalInfo).isNull();
    }

    @Test
    void carDoesntExist() {
        //GIVEN
        User user = new User("1");
        String vin = "NieMaTakiegoVinu";
        LocalDate startDate = LocalDate.of(2022, 12, 1);
        LocalDate endDate = LocalDate.of(2022, 12, 11);

        //WHEN
        RentalInfo rentalInfo = carService.rentCar(user, vin, startDate, endDate);

        //THEN
        assertThat(rentalInfo).isNull();
    }

}