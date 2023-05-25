package pl.pjatk.mickacpizzeria;

import org.springframework.stereotype.Component;

import static java.util.Objects.nonNull;

@Component
public class Order {

    public Order(Pizzeria pizzeria) {
        final Pizza pizza = pizzeria.zamow("cappricosa");
        if (nonNull(pizza)) {
            System.out.println("Zamówiono pizze: " + pizza.getName() + " o cenie: " + pizza.getPrice() + " zl.");
        } else {
            System.out.println("pizza o podanej nazwie nie istnieje");
        }
    }

}
