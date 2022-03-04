package lab2.task1;

public class Main {
    public static void main (String[] args) {
        Complex num1 = new Complex(2, 3);
        System.out.printf("num1 = ");
        num1.showNumber();

        Complex num2 = new Complex();
        System.out.printf("num2 = ");
        num2.showNumber();

        Complex num1Copy = new Complex(num1);
        System.out.printf("num1Copy = ");
        num1Copy.showNumber();

        num1.addWithComplex(num1Copy);
        System.out.printf("num1 + num1Copy = ");
        num1.showNumber();
    }
}
