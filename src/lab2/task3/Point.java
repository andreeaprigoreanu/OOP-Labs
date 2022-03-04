package lab2.task3;

public class Point {
    float coordinate1;
    float coordinate2;

    public Point(float coordinate1, float coordinate2) {
        this.coordinate1 = coordinate1;
        this.coordinate2 = coordinate2;
    }

    public void changeCoords(float coordinate1, float coordinate2) {
        this.coordinate1 = coordinate1;
        this.coordinate2 = coordinate2;
    }

    @Override
    public String toString() {
        return "(" + coordinate1 + ", " + coordinate2 + ")";
    }
}
