package lab3;

public class Area {
    CandyBag candyBag;
    int number;
    String street;

    public Area() {
        candyBag = null;
        number = 0;
        street = null;
    }

    public Area(CandyBag candyBag, int number, String street) {
        this.candyBag = candyBag;
        this.number = number;
        this.street = street;
    }

    public void getBirthdayCard() {
        System.out.println("Adress: " + number + " " + street + " Street");
        System.out.println("Happy birthday!!");

        for (CandyBox candyBox : candyBag.candyBoxes) {
            System.out.println(candyBox.toString());

            /*
            if (candyBox instanceof Lindt) {
                ((Lindt) candyBox).printLindtDim();
            } else {
                if (candyBox instanceof Baravelli) {
                    ((Baravelli) candyBox).printBaravelliDim();
                } else {
                    if(candyBox instanceof ChocAmor) {
                        ((ChocAmor) candyBox).printChocAmorDim();
                    }
                }
            }
            */

            candyBox.printDim();
        }
    }
}
