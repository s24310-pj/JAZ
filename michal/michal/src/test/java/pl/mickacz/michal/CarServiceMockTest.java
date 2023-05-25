package pl.mickacz.michal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CarServiceMockTest {

    @Mock
    private CarStorage carStorage;
    @Mock
    private RentalStorage rentalStorage;
    @Mock
    private RentalInfo rentalInfo;

    @InjectMocks
    private CarService carService;



    //Vin jest nullem
    @Test
    void shouldNotRentCar_VinNullMock() {
        String vin = null;
        when(carStorage.findVin(vin)).thenReturn(null);
        assertThat(carStorage.findVin(vin)).isNull();
    }


    //Data startDate jest późniejsza niż endDate
    @Test
    void DateMock() {
        LocalDate startDate = LocalDate.of(2022,10,17);
        LocalDate endDate = LocalDate.of(2022,10,10);
        when(rentalInfo.checkDate(startDate,endDate)).thenReturn(false);
        assertThat(rentalInfo.checkDate(startDate,endDate)).isFalse();
    }


}