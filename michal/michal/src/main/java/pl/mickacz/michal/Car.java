package pl.mickacz.michal;

public class Car {
    private String make;
    private String model;
    private String vin;
    private CarType carType;

    public Car(String make, String model, String vin, CarType carType) {
        this.make = make;
        this.model = model;
        this.vin = vin;
        this.carType = carType;

    }

    public String getMake() {
        return this.make;
    }

    public String getModel() {
        return this.model;
    }

    public String getVin() {
        return this.vin;
    }

    public CarType getCarType() {
        return carType;
    }


    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", vin='" + vin + '\'' +
                ", carType='" + carType + '\'' +
                '}';
    }
}
