package Package1;

public class Car {

    String brand;
    String model;
    String VIN;
    int year;
    double price;
    boolean available;

    /*Constructor vacio, asignar valores directamente */
    public Car(){
    }

    /*Información ya conocida */
    public Car(String brand, String model, String VIN, int year, double price, boolean available) {
        this.brand = brand;this.model = model; this.VIN = VIN;this.year = year;this.price = price; this.available = available;
    }    



}
