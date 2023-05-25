package pl.pjatk.mickacpizzeria;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Storage {

    Pizza margherita = new Pizza("margherita", 25);
    Pizza cappricosa = new Pizza("cappricosa", 30);
    Pizza quattroFromaggi = new Pizza("quattroFromaggi", 40);
    List<Pizza> pizzaList = new ArrayList<>();

    public List<Pizza> getPizzaList()
    {
        return this.pizzaList;
    }

    public Storage() {
        pizzaList.add(margherita);
        pizzaList.add(cappricosa);
        pizzaList.add(quattroFromaggi);
    }


}
