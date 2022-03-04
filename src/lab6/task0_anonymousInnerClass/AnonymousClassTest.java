package lab6.task0_anonymousInnerClass;

interface Engine {
    public int getFuelCapacity();
}

class Car {
    public Engine getEngine(int fuelCapacity) {
        return new Engine () {
            private int fuelCapacity = 11;

            public int getFuelCapacity() {
                return fuelCapacity;
            }
        };
    }
}

public class AnonymousClassTest {
    public static void main(String[] args) {
        Car car = new Car();

        Engine engine1 = car.getEngine(11);
        System.out.println(engine1.getFuelCapacity());

        Engine engine2 = car.getEngine(13);
        System.out.println(engine2.getFuelCapacity());
    }
}
