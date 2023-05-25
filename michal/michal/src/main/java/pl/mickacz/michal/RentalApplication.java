package pl.mickacz.michal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class RentalApplication {

	public RentalApplication(CarService carService)
	{
		//System.out.println(carService.getAllCars());
		//carService.rentCar(new User("user1"), "bbb", LocalDate.of(2022, 11, 30), LocalDate.of(2022,12,13));
		//carService.rentCar(new User("user2"), "ccc", LocalDate.of(2022, 11, 30), LocalDate.of(2022,12,5));
		//carService.rentCar(new User("user1"), "aaa", LocalDate.of(2022, 11, 30), LocalDate.of(2022,12,10));
		//System.out.print(carService.getAllRentals());
	}


	public static void main(String[] args) {
		SpringApplication.run(RentalApplication.class, args);
	}

}
