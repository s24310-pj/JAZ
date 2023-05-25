package pl.mickacz.michal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CarServiceIntegrationTest {


    @MockBean
    private CarStorage carStorage;

    @MockBean
    private RentalStorage rentalStorage;


    @Autowired
    private CarService carService;



    @Test
    void shouldPassWithMock()
    {
        when(carStorage.getCars()).thenReturn(List.of(new Car("Pagani", "Zonda", "fajnyvin123", CarType.PREMIUM)));

        List<Car> allCars = carService.getAllCars();

        assertThat(allCars).isNotNull();
    }




    @Test
    void shouldPass()
    {
        List<Car> allCars = carService.getAllCars();

        assertThat(allCars).isNotNull();
    }



    @Test
    void shouldReturnPriceStandard() {

        when(carStorage.findCar(any())).thenReturn(new Car("Pagani", "Zonda", "aaa", CarType.STANDARD));
        when(carStorage.findVin(any())).thenReturn("aaa");

        //GIVEN
        User user = new User("1");
        String vin = "aaa";
        LocalDate startDate = LocalDate.of(2022, 12, 1);
        LocalDate endDate = LocalDate.of(2022, 12, 11);

        //WHEN
        RentalInfo rentalInfo = carService.rentCar(user, vin, startDate, endDate);

        //THEN
        assertThat(rentalInfo.getPrice()).isEqualTo(1000);
    }

    @Test
    void shouldReturnPricePremium() {

        when(carStorage.findCar(any())).thenReturn(new Car("Pagani", "Zonda", "bbb", CarType.PREMIUM));
        when(carStorage.findVin(any())).thenReturn("bbb");

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
