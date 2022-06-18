/**
 * Question 1 section a:
 * 1 - False
 * 2 - False
 * 3 - True
 * 4 - False
 * 5 - True
 * 6 - True
 *
 * @author Amit Nahmias
 * @version 21.5.22
 */
public class Ex14 {

    /**
     * Get sorted two dimensions array according to what function and return if value inside him in O(n) run time.
     * <p>
     * According to my implementation the method run time will be O(n) because if we look at the two dimensions array,
     * we will see that the maximum operation that we can do is 2n,
     * that is because we start in the bottom left corner, and I allow only one single step 'down' or 'right'.
     * In the worst case we will do n steps down and then n step right or vice versa -> 2n steps.
     * </p>
     * <p>
     * The memory complications is from order of O(1), because we didn't created the array,
     * and just initialized row, column and temp.
     * </p>
     *
     * @param m   Two dimensions array full in integers.
     * @param val Value to search inside m.
     * @return True if val inside m, otherwise false.
     */
    public static boolean findValWhat(int[][] m, int val) {
        int row = m.length - 1, column = 0;
        while (column < m.length && row >= 0) {
            int temp = m[row][column];
            if (temp == val) return true;
            else if (temp > val) row--;
            else column++;
        }
        return false;
    }

    /**
     * Get sorted two dimensions according to test function array and return if value inside him in O(n) run time.
     * <p>
     * According to my implementation the method run time will be O(n) because if we look at the two dimensions array,
     * we will see that the maximum operation that we can do is 2n,
     * that is because the method doing binary search on the first column,
     * find the two rows that the number can be inside them (kind of range),
     * then iterate over the two rows as regular search,
     * because of that the run time will be maximum O(2n) -> O(n).
     * </p>
     * <p>
     * The memory complications is from order of O(1), because we didn't created the array,
     * and just initialized low, high mid, and i.
     * </p>
     *
     * @param m   Two dimensions array full in integers.
     * @param val Value to search inside m.
     * @return True if val inside m, otherwise false.
     */
    public static boolean findValTest(int[][] m, int val) {
        int low = 0, high = m.length - 1, mid;
        while (low < high - 1) {
            mid = (low + high) / 2;
            if (m[mid][0] == val)
                return true;
            else if (m[mid][0] > val)
                high = mid;
            else
                low = mid;
        }
        for (int i = 0; i < m.length; i++)
            if (val == m[low][i] || val == m[high][i]) return true;
        return false;
    }


    /**
     * Get array full of integers and returns the number of sorted sub-arrays (at least in length 2) that the array contains.
     * <p>
     * Run time is O(n) -> iterate over all the array while array's length is n.
     * </p>
     * <p>
     * The memory complications is from order of O(1) because we didn't created the array,
     * and just initialized sum, counter and i.
     * </p>
     *
     * @param a Input array.
     * @return The number of sorted sub-arrays.
     */
    public static int strictlyIncreasing(int[] a) {
        int sum = 0, counter = 1;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] < a[i + 1]) {
                counter++;
                sum = sum + counter - 1;
            } else counter = 1;
        }
        return sum;
    }


    /**
     * Find the length of the longest flat sub-sequence in array.
     *
     * @param arr Input array - full in integers.
     * @return The length of the longest flat sub-sequence in array.
     */
    public static int longestFlatSequence(int[] arr) {
        if (arr.length <= 1)
            return arr.length;
        return findMaxSubArray(arr, 0);
    }

    /**
     * Find the length of flat sequence from specific index inside array.
     *
     * @param arr     Input array - full in integers.
     * @param index   Start index.
     * @param first   First flat number.
     * @param second  Second flat number.
     * @param counter Length of flat sequence.
     * @param equal   Indicate if first and second are the same.
     * @return Length of flat sequence (counter).
     */
    public static int lengthFlat(int[] arr, int index, int first, int second, int counter, boolean equal) {
        if (index == arr.length - 1)
            return counter;
        else if (equal) {
            if (arr[index + 1] == first) {
                return lengthFlat(arr, index + 1, first, second, counter + 1, true);
            } else if (arr[index + 1] + 1 == first || arr[index + 1] - 1 == first) {
                return lengthFlat(arr, index + 1, first, arr[index + 1], counter + 1, false);
            } else return counter;
        } else {
            if (arr[index + 1] == first || arr[index + 1] == second && (first - second == 1 || first - second == -1)) {
                return lengthFlat(arr, index + 1, first, second, counter + 1, false);
            } else return counter;
        }
    }

    private static int findMaxSubArray(int[] arr, int index) {
        if (index == arr.length - 1)
            return 1;
        else { // Find the maximum length of flat sub-sequence inside array.
            return Math.max(lengthFlat(arr, index, arr[index], arr[index + 1], 1, arr[index] == arr[index + 1]), findMaxSubArray(arr, index + 1));
        }
    }

    /**
     * Calculate longest valid track in 2D array.
     *
     * @param mat Input two dimensions array.
     * @return The longest track in array.
     */
    public static int findMaximum(int[][] mat) {
        if (mat[0][0] == -1) return -1;
        return mat[0][0] + findMaximum(mat, 0, 0);
    }

    private static int findMaximum(int[][] mat, int row, int column) {
        int down = 0, right = 0, left = 0;

        if (row < mat.length - 1) // Verify array limits
        {
            if (mat[row + 1][column] == 0 || mat[row + 1][column] == 1)
                // going row down to 0 or 1
                down = mat[row + 1][column] + findMaximum(mat, row + 1, column);
        }
        if (isEval(row)) // row index is eval.
        {
            if (column + 1 <= mat[0].length - 1) // Verify array limits
                if (mat[row][column + 1] == 0 || mat[row][column + 1] == 1)
                    // going column right to 0 or 1
                    right = mat[row][column + 1] + findMaximum(mat, row, column + 1);
        } else // row index is odd.
        {
            if (column - 1 >= 0) // Verify array limits
                if (mat[row][column - 1] == 0 || mat[row][column - 1] == 1)
                    // going column left to 0 or 1
                    left = mat[row][column - 1] + findMaximum(mat, row, column - 1);
        }
        return max(max(down, left), right);
    }


    private static boolean isEval(int number) { // returns if number is eval.
        return number % 2 == 0;
    }

    private static int max(int number1, int number2) { // return the bigger number from two input integers.
        return number1 > number2 ? number1 : number2;
    }

}
