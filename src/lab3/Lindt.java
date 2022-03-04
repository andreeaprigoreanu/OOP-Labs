package lab3;

public class Lindt extends CandyBox{
    private float length;
    private float width;
    private float height;

    public Lindt() {
        super();
        length = 0;
        width = 0;
        height = 0;
    }

    public Lindt(String flavor, String origin, float length, float width, float height) {
        super(flavor, origin);
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void printLindtDim() {
        System.out.println("length=" + length + " width=" + width
                + " height=" + height);
    }

    @Override
    public void printDim() {
        System.out.println("length=" + length + " width=" + width
                + " height=" + height);
    }

    @Override
    public float getVolume(){
        return length * width * height;
    }

    @Override
    public String toString() {
        return "The " + this.getOrigin() + " " + this.getFlavor() + " has volume " +
                this.getVolume();
    }
}
