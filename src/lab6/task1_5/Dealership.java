package lab6.task1_5;

import java.util.Random;

public class Dealership {
    private class BrandOffer implements Offer {
        @Override
        public int getDiscount(Car car) {
            if (car.getCarType() == Car.CarType.Volvo) {
                return 5 * car.getPrice() / 100;
            } else {
                if (car.getCarType() == Car.CarType.Toyota) {
                    return 7 * car.getPrice() / 100;
                }
                else {
                    return 10 * car.getPrice() / 100;
                }
            }
        }
    }

    private class DealerOffer implements Offer {
        @Override
        public int getDiscount(Car car) {
            int currentYear = 2021;

            return (currentYear - car.getManufactureYear()) * 100;
        }
    }

    private class SpecialOffer implements Offer {
        @Override
        public int getDiscount(Car car) {
            Random rand = new Random();
            return rand.nextInt(300);
        }
    }

    public void applyBrandDiscount(Car car) {
        BrandOffer brandOffer = new BrandOffer();
        int discount = brandOffer.getDiscount(car);

        System.out.println("Applying Brand Discount: " + discount);
        car.setPrice(car.getPrice() - discount);
    }

    public void applyDealerDiscount(Car car) {
        DealerOffer dealerOffer = new DealerOffer();
        int discount = dealerOffer.getDiscount(car);

        System.out.println("Applying Dealer Discount: " + discount);
        car.setPrice(car.getPrice() - discount);
    }

    public void applySpecialDiscount(Car car) {
        SpecialOffer specialOffer = new SpecialOffer();
        int discount = specialOffer.getDiscount(car);

        System.out.println("Applying Special Discount: " + discount);
        car.setPrice(car.getPrice() - discount);
    }

    public void getFinalPrice(Car car) {
        this.applyBrandDiscount(car);
        this.applyDealerDiscount(car);
        this.applySpecialDiscount(car);
    }

    public void negotiate(Car car, Offer offer) {
        int discount = offer.getDiscount(car);
        System.out.println("Applying Client discount: " + discount);

        Random rand = new Random();
        if (rand.nextInt(2) == 1) {
            car.setPrice(car.getPrice() - discount);
        }
    }
}
