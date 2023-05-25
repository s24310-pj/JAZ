package pl.mickacz.michal;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class RentalInfo {

    private double price;
    private LocalDate startDate;
    private LocalDate endDate;

    public RentalInfo(double price, LocalDate startDate, LocalDate endDate) {
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
    }


    public boolean checkDate(LocalDate startDate, LocalDate endDate){
        if(ChronoUnit.DAYS.between(startDate, endDate) < 0){
            System.out.println("startDate pozniejsze niz endDate");
            return false;
        }
        return true;
    }



    public double getPrice() {
        return price;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
}
