package pl.pjatk.zjazd3.model;

public class Car {

    private int vin;
    private String marka;
    private String model;

    public Car(int vin, String marka, String model) {
        this.vin = vin;
        this.marka = marka;
        this.model = model;
    }

    public Car(int vin) {
    }

    public int getVin() {
        return vin;
    }

    public String getMarka() {
        return marka;
    }

    public String getModel() {
        return model;
    }

    public void setVin(int vin) {
        this.vin = vin;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
