package pl.pjatk.NBP.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pjatk.NBP.model.CurrencyData;

public interface CurrencyDataRepository extends JpaRepository<CurrencyData, Long> {
}