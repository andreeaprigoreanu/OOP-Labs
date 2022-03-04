package lab2.task3;

import java.util.Arrays;

public class Polygon {
    private int n;
    private Point[] points;

    public Polygon(int n) {
        this.n = n;
        this.points = new Point[n];
    }

    public Polygon(float[] pointsList) {
        this(pointsList.length / 2);

        for (int i = 0; i < n; ++i) {
            points[i] = new Point(pointsList[2 * i], pointsList[2 * i + 1]);
        }
    }

    @Override
    public String toString() {
        return "Polygon: " +
                "n=" + n +
                ", points=" + Arrays.toString(points) +
                '}';
    }
}
