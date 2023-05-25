package pl.pjatk.zjazd3.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.zjazd3.model.Car;

@RestController
@RequestMapping("/zjazd3")
public class FirstController {

    @GetMapping()
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello world");
    }

    @GetMapping("/model")
    public ResponseEntity<Car> getCar() {
        return ResponseEntity.ok(new Car(123, "Ford", "F150"));
    }

    @GetMapping(value = "hello/{someValue}")
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

}
