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
            if (m[mid][0] == val) return true;
            else if (m[mid][0] > val) high = mid;
            else low = mid;
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

    /**
     * Find the maximum length of flat sub-sequence inside array.
     *
     * @param arr   Input array - full in integers.
     * @param index Start index.
     * @return the maximum length of flat sub-sequence.
     */
    private static int findMaxSubArray(int[] arr, int index) {
        if (index == arr.length - 1)
            return 1;
        else {
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

    /**
     * Calculate longest valid track in 2D array.
     *
     * @param mat Input two dimensions array.
     * @param row Row to begin.
     * @param column Column to begin.
     * @return The longest track in array.
     */
    private static int findMaximum(int[][] mat, int row, int column) {
        int down = 0, right =0, left =0;

        if (row < mat.length - 1)
        {
            if (mat[row+1][column] == 0)
            { // going down to 0
                down = findMaximum(mat,row+1,column);
            }
            else if (mat[row+1][column] == 1)
            { // going down to 1
                down = 1 + findMaximum(mat,row+1,column);
            }
        }

        if (isEqual(row))
        {
            if (column + 1 <= mat[0].length - 1)
            {
                if (mat[row][column + 1] == 0)
                { // going right to 0
                    right = findMaximum(mat, row, column + 1);
                }
                else if (mat[row][column + 1] == 1)
                { // going right to 1
                    right = 1 + findMaximum(mat, row, column + 1);
                }
//                return down > right ? down : right;

            }
        }
        else
        {
            if (column - 1 >= 0)
            {
                if (mat[row][column - 1] == 0 )
                { // going left to 0
                    left = findMaximum(mat, row, column - 1);
                }
                else if(mat[row][column - 1] == 1)
                { // going left to 1
                    left = 1 + findMaximum(mat, row, column - 1);
                }
//                return down > left ? down : left;
            }

        }

//        if (row==mat.length-1 && column==mat[0].length-1)
//            if (mat[row][column] >= 0)
//            return mat[row][column] + mat[0][0];
        return (down > left ? down : left) > right ? (down > left ? down : left) : right;
    }

    /**
     * Returns if number is equal.
     *
     * @param number Input number.
     * @return True if equal, otherwise false.
     */
    private static boolean isEqual(int number) {
        return number % 2 == 0;
    }

//    public static int maxSumSnake(int[][] m) {
//
//        return maxSumSnake(m, 0, 0);
//
//    }

//    private static int maxSumSnake(int[][] m, int i, int j) {
//        final int BEEN_HERE = -10;
//
//        if (i == m.length - 1 && j == m[0].length - 1)
//
//            return m[i][j];
//
//        // avoid repeat a cell
//
//        int temp = m[i][j];
//
//        m[i][j] = BEEN_HERE;
//
//        // recurtion for all neighbors
//        int up = -1, down = -1, left = -1, right = -1;
//
//        if (i - 1 >= 0 && Math.abs(temp - m[i - 1][j]) <= 1)
//
//            up = maxSumSnake(m, i - 1, j);
//
//        if (i + 1 < m.length && Math.abs(temp - m[i + 1][j]) <= 1)
//
//            down = maxSumSnake(m, i + 1, j);
//
//        if (j - 1 >= 0 && Math.abs(temp - m[i][j - 1]) <= 1)
//
//            left = maxSumSnake(m, i, j - 1);
//
//        if (j + 1 < m[0].length && Math.abs(temp - m[i][j + 1]) <= 1)
//
//            right = maxSumSnake(m, i, j + 1);
//
//        m[i][j] = temp;
//        // couldn't find a path
//
//        if (up == -1 && down == -1 && left == -1 && right == -1)
//
//            return -1;
//
//        // return the max path
//
//        int max = Math.max(Math.max(up, down), Math.max(left, right));
//
//        return max + m[i][j];
//
//    }
}
