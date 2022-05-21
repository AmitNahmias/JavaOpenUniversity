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
     * From common reasons the memory complications will be also from order of O(n).
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
     * From common reasons the memory complications will be also from order of O(n).
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


}
