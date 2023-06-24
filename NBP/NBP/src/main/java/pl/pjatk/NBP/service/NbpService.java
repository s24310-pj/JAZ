package pl.pjatk.NBP.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.pjatk.NBP.model.CurrencyData;
import pl.pjatk.NBP.model.NbpResponse;
import pl.pjatk.NBP.repository.CurrencyDataRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NbpService {

    private final RestTemplate restTemplate;
    private final CurrencyDataRepository currencyDataRepository;
    private static final String NbpUrl = "http://api.nbp.pl/api/exchangerates/rates";

    public NbpService(RestTemplate restTemplate, CurrencyDataRepository currencyDataRepository) {
        this.restTemplate = restTemplate;
        this.currencyDataRepository = currencyDataRepository;
    }

    public NbpResponse getCurrencyRates(String table, String code, int lastDays) {
        String url = String.format("%s/%s/%s/last/%d", NbpUrl, table, code, lastDays);
        return restTemplate.getForObject(url, NbpResponse.class);
    }

    public double calculateAverageRate(List<NbpResponse.Rate> rates) {
        return rates.stream().mapToDouble(NbpResponse.Rate::getMid).average()
                .orElseThrow(() -> new RuntimeException("Nie można obliczyć średniego kursu"));
    }

    public CurrencyData saveCurrencyData(String currency, int days, double averageRate) {
        CurrencyData item = new CurrencyData();
        item.setCurrency(currency);
        item.setDays(days);
        item.setAverageRate(averageRate);
        item.setQueryDateTime(LocalDateTime.now());

        currencyDataRepository.save(item);

        return item;
    }


}
