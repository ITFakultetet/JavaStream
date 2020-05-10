package no.itfakultetet;

public class Car {

    private String make;
    private Integer model;
    private Integer price;

    public Car(String make, Integer model, Integer price) {
        this.make = make;
        this.model = model;
        this.price = price;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public Integer getModel() {
        return model;
    }

    public void setModel(Integer model) {
        this.model = model;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model=" + model +
                ", price=" + price +
                '}';
    }
}
