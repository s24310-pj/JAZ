package pl.pjatk.NBP.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;

import java.time.LocalDateTime;

@Entity
public class CurrencyData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unikalne ID")
    private Long id;
    @Schema(description = "Waluta dla której sprawdzono kurs")
    private String currency;
    @Schema(description = "Ilość dni które zostały wzięte pod uwagę")
    @Min(value = 1, message = "wartość nie powinna być mniejsza od 1")
    private int days;
    @Schema(description = "Obliczony średni kurs waluty")
    private double averageRate;
    @Schema(description = "Aktualna data i czas podczas wykonywania zapytania")
    private LocalDateTime queryDateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public double getAverageRate() {
        return averageRate;
    }

    public void setAverageRate(double averageRate) {
        this.averageRate = averageRate;
    }

    public LocalDateTime getQueryDateTime() {
        return queryDateTime;
    }

    public void setQueryDateTime(LocalDateTime queryDateTime) {
        this.queryDateTime = queryDateTime;
    }
}
