package pl.pjatk.mickacpizzeria;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Pizzeria {

    private Storage storage;

    public Pizzeria(Storage storage)
    {
        this.storage = storage;
    }


    public Pizza zamow(String name) {
        for (Pizza pizza : storage.getPizzaList()) {
            if (pizza.getName().equalsIgnoreCase(name)) {
                return pizza;
            }
        }
        return null;
    }
}
