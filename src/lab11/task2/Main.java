package lab11.task2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Main {

    public static <T extends Summable> T addAll(Collection<T> c) {
        Iterator<T> it = c.iterator();
        T sum = it.next();
        while (it.hasNext()) {
            sum.addValue(it.next());
        }
        return sum;
    }

    public static void main(final String[] args) {
        // TODO: add implementation testing
        Collection<Summable> c = new ArrayList<>();

        System.out.println("Vectorii adunati:");
        MyVector3 vector1 = new MyVector3(1, 2, 3);
        System.out.println(vector1);
        MyVector3 vector2 = new MyVector3(3, 8, 2);
        System.out.println(vector2);
        MyVector3 vector3 = new MyVector3(7, 4, 9);
        System.out.println(vector3);

        c.add(vector1);
        c.add(vector2);
        c.add(vector3);

        System.out.println("Rezultatul adunarii vectorilor:");
        System.out.println(addAll(c));

        System.out.println();
        c.clear();

        System.out.println("Matricile adunate:");
        Integer[][] testMatrix1 = new Integer[4][4];
        int x = 10;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                testMatrix1[i][j] = ++x;
            }
        }
        MyMatrix matrix1 = new MyMatrix(testMatrix1);
        System.out.println(matrix1);

        Integer[][] testMatrix2 = new Integer[4][4];
        x = 12;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                testMatrix2[i][j] = x;
                x += 2;
            }
        }
        MyMatrix matrix2 = new MyMatrix(testMatrix2);
        System.out.println(matrix2);

        Integer[][] testMatrix3 = new Integer[4][4];
        x = 11;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                testMatrix3[i][j] = x;
                x += 4;
            }
        }
        MyMatrix matrix3 = new MyMatrix(testMatrix3);
        System.out.println(matrix3);

        c.add(matrix1);
        c.add(matrix2);
        c.add(matrix3);

        System.out.println("Rezultatul adunarii matricilor:");
        System.out.println(addAll(c));
    }
}
