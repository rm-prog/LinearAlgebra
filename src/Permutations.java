import java.util.Arrays;

public class Permutations {

    static int Factorial(int n) {

        int result = n;

        for (int i = n - 1; i > 1; i--) {
            result *= i;
        }

        return result;
    }

    static int[][] ProducePermutations(int[] numbers) {

        if (numbers.length == 2) {
            return new int[][]{
                    {numbers[0], numbers[1]},
                    {numbers[1], numbers[0]}
            };
        }

        int[][] permutations = new int[Permutations.Factorial(numbers.length)][];
        int permutationIndex = 0;

        for (int i = 0; i < numbers.length; i++) {

            int[] subArray = new int[numbers.length - 1];
            int index = 0;

            // fill subArray with all the numbers other than numbers[i]
            for (int j = 0; j < numbers.length; j++) {
                if (j != i) {
                    subArray[index] = numbers[j];
                    index++;
                }
            }

            // produce permutations with all numbers other than numbers[i]
            int[][] subPermutations = ProducePermutations(subArray);

            // produce all permutations starting with numbers[i]
            for (int j = 0; j < Permutations.Factorial(numbers.length - 1); j++) {
                permutations[permutationIndex] = new int[numbers.length];
                permutations[permutationIndex][0] = numbers[i];
                for (int k = 1; k < numbers.length; k++) {
                    permutations[permutationIndex][k] = subPermutations[j][k - 1];
                }
                permutationIndex++;
            }
        }

        return permutations;

    }

    static void ProducePermutations2(int[] numbers, int startingIndex) {

        if (startingIndex == numbers.length - 2) {
            System.out.println(Arrays.toString(numbers));

            int temp = numbers[numbers.length - 2];
            numbers[numbers.length - 2] = numbers[numbers.length - 1];
            numbers[numbers.length - 1] = temp;
            System.out.println(Arrays.toString(numbers));
            return;
        }

        for (int i = startingIndex; i < numbers.length; i++) {

            int[] newNumbers = new int[numbers.length];
            for (int j = 0; j < numbers.length; j++) {
                newNumbers[j] = numbers[j];
                if (j == i) {
                    newNumbers[j] = numbers[startingIndex];
                } else if (j == startingIndex) {
                    newNumbers[j] = numbers[i];
                }
            }

            ProducePermutations2(newNumbers, startingIndex + 1);
        }
    }

    static void HeapPermutation(int[] arr, int length, int n) {

        if (length == 1) {
            System.out.println(Arrays.toString(arr));
            return;
        }

        for (int i = 0; i < length; i++) {
            HeapPermutation(arr, length - 1, n);

            if (length % 2 == 1) {
                int temp = arr[0];
                arr[0] = arr[length - 1];
                arr[length - 1] = temp;
            } else {
                int temp = arr[i];
                arr[i] = arr[length - 1];
                arr[length - 1] = temp;
            }
        }
    }

    // Permutation is positive when -1^(sum of distance of each number from their position in the identity permutation)
    // gives +1
    static boolean isPositivePermutation(int[] permutation) {

        boolean isPositive = true;

        for (int i = 0; i < permutation.length - 1; i++) {
            // Count how many smaller numbers are in front of number in i-th index
            for (int j = i + 1; j < permutation.length; j++) {
                if (permutation[i] > permutation[j]) isPositive = !isPositive;
            }
        }

        return isPositive;
    }

}
