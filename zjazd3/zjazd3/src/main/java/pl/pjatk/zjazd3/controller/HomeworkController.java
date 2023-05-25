package pl.pjatk.zjazd3.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.zjazd3.model.Car;
import pl.pjatk.zjazd3.service.FirstService;


@RestController
@RequestMapping("/homework")
public class HomeworkController {


    private final FirstService firstService;

    public HomeworkController(FirstService firstService) {
        this.firstService = firstService;
    }

    @GetMapping(value = "{someValue}")
    public ResponseEntity<String> zadanie3(@PathVariable("someValue") String someValue) {
        return ResponseEntity.ok(someValue);
    }

    @GetMapping(value = "/parametr")
    public ResponseEntity<String> zadanie4(@RequestParam("param") String param) {
        return ResponseEntity.ok(param);
    }

    @PostMapping("/car")
    public ResponseEntity<Car> postCar(@RequestBody Car car) {
        return ResponseEntity.ok(car);
    }

    @PutMapping("/updating/{vin}")
    public ResponseEntity<Car> updateCar(@PathVariable int vin, @RequestBody Car car) {

        Car newCar = new Car(vin, null, null);

        return ResponseEntity.ok(newCar);
    }

    @DeleteMapping(value = "/deleting/{vin}")
    public ResponseEntity<Car> deleteCar(@PathVariable int vin) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/exception")
    public ResponseEntity<String> exception() {
        String exceptionText = firstService.throwException(true);
        return ResponseEntity.ok(exceptionText);
    }


}
