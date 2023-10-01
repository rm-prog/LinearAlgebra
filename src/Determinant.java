public class Determinant {

    // pre-condition: matrix is square
    static int LaplaceExpansionColumns(int[][] matrix) {

        // if 2x2 matrix calculate determinant
        if (matrix.length == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }

        int determinant = 0;

        int sign = -1;

        for(int i=0; i < matrix.length; i++) {
            sign *= -1;

            // determinant of subMatrix is a cofactor of matrix
            int[][] subMatrix = new int[matrix.length-1][matrix.length-1];
            int row = 0;
            int column = 0;

            // copy the entries of matrix into subMatrix, excluding entries on 0th row and i column
            for (int j=1; j < matrix.length; j++) {
                for (int k=0; k < matrix.length; k++) {
                    if (column == matrix.length-1) {
                        column = 0;
                        row++;
                    }
                    if (k != i) {
                        subMatrix[row][column] = matrix[j][k];
                        column++;
                    }
                }
            }
            // alternating +, - sign * entry on 0th row and i column * cofactor
            determinant += sign * matrix[0][i] * LaplaceExpansionColumns(subMatrix);
        }

        return determinant;
    }

    // pre-condition: matrix is square
    static int LaplaceExpansionRows(int[][] matrix) {

        // if 2x2 matrix calculate determinant
        if (matrix.length == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }

        int determinant = 0;

        int sign = -1;

        for(int i=0; i < matrix.length; i++) {
            sign *= -1;

            // determinant of subMatrix is a cofactor of matrix
            int[][] subMatrix = new int[matrix.length-1][matrix.length-1];
            int row = 0;
            int column = 0;

            // copy the entries of matrix into subMatrix, excluding entries on 0th column and ith row
            for (int j=0; j < matrix.length; j++) {
                for (int k=1; k < matrix.length; k++) {
                    if (column == matrix.length-1) {
                        column = 0;
                        row++;
                    }
                    if (j != i) {
                        subMatrix[row][column] = matrix[j][k];
                        column++;
                    }
                }
            }
            // alternating +, - sign * entry on 0th row and i column * cofactor
            determinant += sign * matrix[i][0] * LaplaceExpansionRows(subMatrix);
        }

        return determinant;
    }

    // pre-condition: matrix is square
    // Calculate determinant of square matrix by adding the product of Permutations
    static int sumOfPermutations (int[][] matrix) {

        int[] numbers = new int[matrix.length];

        for (int i = 0; i<numbers.length; i++) {
            numbers[i] = i;
        }

        int[][] permutations = Permutations.ProducePermutations(numbers);
        int determinant = 0;

        for (int i=0; i < permutations.length; i++) {
            // Multiply the entries in each row in the columns defined by the permutation
            int productOfPermutation = 1;
            for (int j=0; j < permutations[i].length; j++) {
                productOfPermutation *= matrix[j][permutations[i][j]];
            }
            determinant += Permutations.isPositivePermutation(permutations[i]) ? productOfPermutation : -productOfPermutation;
        }

        return determinant;
    }

}
