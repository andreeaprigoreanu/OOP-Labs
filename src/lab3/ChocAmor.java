package lab3;

public class ChocAmor extends CandyBox{
    private float length;

    public ChocAmor() {
        super();
        length = 0;
    }

    public ChocAmor(String flavor, String origin, float length) {
        super(flavor, origin);
        this.length = length;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public void printChocAmorDim() {
        System.out.println("length=" + length);
    }

    @Override
    public void printDim() {
        System.out.println("length=" + length);
    }

    @Override
    public float getVolume(){
        return length * length * length;
    }

    @Override
    public String toString() {
        return "The " + this.getOrigin() + " " + this.getFlavor() + " has volume " +
                this.getVolume();
    }
}
