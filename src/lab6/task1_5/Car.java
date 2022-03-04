package lab6.task1_5;

public class Car {
    private int price;
    private int manufactureYear;
    private CarType carType;
    public enum CarType {
        Volvo,
        Toyota,
        Ford;
    }

    public Car(int price, int manufactureYear, CarType carType) {
        this.price = price;
        this.manufactureYear = manufactureYear;
        this.carType = carType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getManufactureYear() {
        return manufactureYear;
    }

    public void setManufactureYear(int manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    @Override
    public String toString() {
        return "Car{" +
                "price=" + price +
                ", manufactureYear=" + manufactureYear +
                ", carType=" + carType +
                '}';
    }
}
