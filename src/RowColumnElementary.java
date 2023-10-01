public class RowColumnElementary {

    static int[] RowMultiplication(int[] row, int scalar) {

        for (int i = 0; i < row.length; i++) {
            row[i] *= scalar;
        }

        return row;
    }

    static int[] RowAddition(int[] row1, int[] row2) {

        int[] result = new int[row1.length];

        for (int i = 0; i < row1.length; i++) {
            result[i] += row1[i] + row2[i];
        }

        return result;

    }

    static void RowExchange(int[] row1, int[] row2) {

        int[] third = row1;
        row1 = row2;
        row2 = third;

    }

    static int[][] BelowDiagonalZeroes(int[][] matrix) {

        int[][] result = matrix;

        if (matrix[0][0] == 0) {
            for (int i = 1; i < matrix.length; i++) {

            }
        }

        return result;

    }

}
