package lab2.task1;

public class Complex {
    private int real;
    private int imaginary;

    public Complex(int real, int imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public Complex() {
        this(0, 0);
    }

    public Complex(Complex complexNumber) {
        this(complexNumber.real, complexNumber.imaginary);
    }

    public int getReal() {
        return real;
    }

    public void setReal(int real) {
        this.real = real;
    }

    public int getImaginary() {
        return imaginary;
    }

    public void setImaginary(int imaginary) {
        this.imaginary = imaginary;
    }

    public void addWithComplex(Complex complexNumber) {
        real += complexNumber.real;
        imaginary += complexNumber.imaginary;
    }

    public void showNumber() {
        System.out.println(real + " + " + imaginary + "i");
    }
}
