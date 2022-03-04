package lab2.task3;

public class Main {
    public static void main (String[] args) {
        float[] pointsList = {1.4f, 3.2f, 2.2f, 4.4f, 3.6f, 4.7f, 2.5f, 1.1f};

        Polygon polygon = new Polygon(pointsList);

        System.out.println(polygon);
    }
}
