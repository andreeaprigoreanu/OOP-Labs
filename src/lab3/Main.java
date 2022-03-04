package lab3;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // task 3:
        Lindt lindt1 = new Lindt("vanilla", "Lindt Switzerland", 2f, 1f, 2f);
        Lindt lindt2 = new Lindt("dark chocolate", "Lindt Switzerland", 3f, 1.5f, 2f);

        System.out.println("lindt1: " + lindt1);
        System.out.println("lindt2: " + lindt2);
        System.out.println("Compare lindt1 and lindt2: " + lindt1.equals(lindt2));
        System.out.println();

        // task 4:
        Baravelli baravelli1 = new Baravelli("caramel", "Baravelli UK", 3.4f, 4.2f);
        Baravelli baravelli2 = new Baravelli("strawberry", "Baravelli UK", 5.6f, 2.2f);

        ChocAmor chocAmor1 = new ChocAmor("mint", "Choc Amor UK", 3.6f);
        ChocAmor chocAmor2 = new ChocAmor("milk", "Choc Amor UK", 2.5f);

        ArrayList<CandyBox> candyBoxes = new ArrayList<CandyBox>();
        candyBoxes.add(lindt1);
        candyBoxes.add(lindt2);
        candyBoxes.add(baravelli1);
        candyBoxes.add(baravelli2);
        candyBoxes.add(chocAmor1);
        candyBoxes.add(chocAmor2);
        CandyBag candyBag = new CandyBag(candyBoxes);

        // task 6
        Area area = new Area(candyBag, 41, "Theodor Aman");
        area.getBirthdayCard();
    }
}
