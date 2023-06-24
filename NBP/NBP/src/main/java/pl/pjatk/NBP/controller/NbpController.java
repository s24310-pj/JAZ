package pl.pjatk.NBP.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.NBP.model.CurrencyData;
import pl.pjatk.NBP.model.NbpResponse;
import pl.pjatk.NBP.repository.CurrencyDataRepository;
import pl.pjatk.NBP.service.NbpService;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/NBP")
public class NbpController {
    private final NbpService nbpService;

    public NbpController(NbpService nbpService) {
        this.nbpService = nbpService;
    }

    @Operation(summary = "Pobiera średni kurs waluty dla podanej ilości dni", description = "domyślnie watość dni jest ustawiona na 1")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Zapytanie wykonane pomyślnie", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = CurrencyData.class)) }),
            @ApiResponse(responseCode = "400", description = "Niepoprawny kod waluty lub liczba dni", content = @Content),
            @ApiResponse(responseCode = "404", description = "Nie znaleziono danych dla zapytania", content = @Content),
            @ApiResponse(responseCode = "500", description = "Błąd serwera NBP lub błąd wewnętrzny", content = @Content)
    })
    @GetMapping("/rate/{currency}")
    public ResponseEntity<CurrencyData> getCurrencyRate(@PathVariable("currency") String currency, @RequestParam(defaultValue = "1") int lastDays) {
        NbpResponse nbpResponse = nbpService.getCurrencyRates("A", currency, lastDays);
        double averageRate = nbpService.calculateAverageRate(nbpResponse.getRates());
        CurrencyData item = nbpService.saveCurrencyData(currency, lastDays, averageRate);

        return ResponseEntity.ok(item);
    }

}
