package lab3;

import java.lang.Math;

public class Baravelli extends CandyBox{
    private float radius;
    private float height;

    public Baravelli() {
        super();
        radius = 0;
        height = 0;
    }

    public Baravelli(String flavor, String origin, float radius, float height) {
        super(flavor, origin);
        this.radius = radius;
        this.height = height;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void printBaravelliDim() {
        System.out.println("radius=" + radius + " height=" + height);
    }

    @Override
    public void printDim() {
        System.out.println("radius=" + radius + " height=" + height);
    }

    @Override
    public float getVolume() {
        return (float)(Math.PI) * radius * radius * height;
    }

    @Override
    public String toString() {
        return "The " + this.getOrigin() + " " + this.getFlavor() + " has volume " +
                this.getVolume();
    }
}
