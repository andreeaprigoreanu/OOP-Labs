package lab6.task1_5;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Car car1 = new Car(35000, 2017, Car.CarType.Volvo);
        Car car2 = new Car(25000, 2018, Car.CarType.Toyota);
        Car car3 = new Car(40000, 2016, Car.CarType.Ford);

        Dealership dealership = new Dealership();

        System.out.println("Initial price for " + car1.getCarType() + ": " + car1.getPrice());
        dealership.getFinalPrice(car1);
        System.out.println("Final price: " + car1.getPrice());
        dealership.negotiate(car1, new Offer() {
            @Override
            public int getDiscount(Car car) {
                return 500;
            }
        });
        System.out.println("Final price after negotiation: " + car1.getPrice());

        System.out.println();

        System.out.println("Initial price for " + car2.getCarType() + ": " + car2.getPrice());
        dealership.getFinalPrice(car2);
        System.out.println("Final price: " + car2.getPrice());
        dealership.negotiate(car2, new Offer() {
            @Override
            public int getDiscount(Car car) {
                return 200;
            }
        });
        System.out.println("Final price after negotiation: " + car2.getPrice());

        System.out.println();

        System.out.println("Initial price for " + car3.getCarType() + ": " + car3.getPrice());
        dealership.getFinalPrice(car3);
        System.out.println("Final price: " + car3.getPrice());
        dealership.negotiate(car3, new Offer() {
            @Override
            public int getDiscount(Car car) {
                return 400;
            }
        });
        System.out.println("Final price after negotiation: " + car3.getPrice());

        /*
            Dupa compilare sunt generate fisierele Car.class, Car$CarType.class,
            Dealership$BrandOffer.class, Dealership$DealerOffer.class, Dealership$SpecialOffer.class,
            Dealership.class, Offer.class si Test.class
            Clasele anonime sunt: Test$1.class, Test$2.class, Test$3.class.
        */

        System.out.println();

        Car car4 = new Car(27000, 2014, Car.CarType.Volvo);
        Car car5 = new Car(29000, 2019, Car.CarType.Toyota);
        Car car6 = new Car(45000, 2021, Car.CarType.Ford);

        ArrayList<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);
        cars.add(car6);

        System.out.println(cars);
        cars.removeIf((car) -> car.getPrice() > 30000);
        System.out.println(cars);
    }
}
