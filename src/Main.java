import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[][] matrix1 = {
                {1, 1},
                {2, 1}
        };
        int[][] matrix2 = {
                {1, 0, 1},
                {2, 3, 0},
                {0, 5, 1}
        };
        int[][] matrix3 = {
                {1, 0, 3, 4},
                {0, 1, 2, 1},
                {2, 5, 0, 6},
                {7, 1, 8, 0}
        };

        System.out.println(Determinant.LaplaceExpansionColumns(matrix1));
        System.out.println(Determinant.LaplaceExpansionColumns(matrix2));
        System.out.println(Determinant.LaplaceExpansionColumns(matrix3));

        System.out.println(Determinant.LaplaceExpansionRows(matrix1));
        System.out.println(Determinant.LaplaceExpansionRows(matrix2));
        System.out.println(Determinant.LaplaceExpansionRows(matrix3));

        System.out.println(Arrays.deepToString(Permutations.ProducePermutations(new int[]{1, 2, 3})));
        System.out.println(Arrays.deepToString(Permutations.ProducePermutations(new int[]{1, 2, 3, 4})));

        System.out.println(Permutations.isPositivePermutation(new int[]{1, 2, 3}));
        System.out.println(Permutations.isPositivePermutation(new int[]{1, 3, 2}));
        System.out.println(Permutations.isPositivePermutation(new int[]{2, 3, 1}));

        System.out.println(Determinant.sumOfPermutations(new int[][]{{2, 2}, {1, 4}}));
        System.out.println(Determinant.sumOfPermutations(new int[][]{{1, 0, 3}, {3, 2, 5}, {6, 1, 2}}));

        int[] row1 = new int[]{1, 2, 3, 4, 5};
        int[] row2 = new int[]{6, 7, 8, 9, 5};

        RowColumnElementary.RowExchange(row1, row2);

        System.out.println(Arrays.toString(row1));
        System.out.println(Arrays.toString(row2));

        row2 = RowColumnElementary.RowMultiplication(row2, 2);
        System.out.println(Arrays.toString(row2));

        int[] row3 = RowColumnElementary.RowAddition(RowColumnElementary.RowMultiplication(row1, 2), row2);
        System.out.println(Arrays.toString(row3));
    }
}