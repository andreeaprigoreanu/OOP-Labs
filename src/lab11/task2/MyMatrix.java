package lab11.task2;

import java.util.Arrays;

public class MyMatrix implements Summable {
    private final Integer[][] myMatrix;

    public MyMatrix(Integer[][] myMatrix) {
        this.myMatrix = myMatrix;
    }

    @Override
    public void addValue(Summable value) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                this.myMatrix[i][j] += ((MyMatrix) value).myMatrix[i][j];
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder matrixString = new StringBuilder();
        matrixString.append("MyMatrix=\n");
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                matrixString.append(myMatrix[i][j]).append(" ");
            }
            matrixString.append("\n");
        }

        return matrixString.toString();
    }
}
