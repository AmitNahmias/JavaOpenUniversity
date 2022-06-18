public class Moed85 {
    public static int findMax(int[][] mat) {
        if (mat[0][0] == -1)
            return 0;
        return findMax(mat, 0, 0) + mat[0][0];
    }

    private static int findMax(int[][] mat, int row, int col) {
        int down = 0, left = 0, right = 0, cols = mat[0].length, rows = mat.length;
        if (row % 2 == 0 && col + 1 < cols && mat[row][col + 1] >= 0)
            right = findMax(mat, row, col + 1);
        else if (row % 2 == 1 && col - 1 >= 0 && mat[row][col - 1] >= 0)
            left = findMax(mat, row, col - 1);
        if (row + 1 < rows && mat[row + 1][col] >= 0)
            down = findMax(mat, row + 1, col);
        return Math.max(down, Math.max(right, left)) + mat[row][col];
    }

    public static int strictlyIncreasing(int[] a) {
        if (a.length < 2) return 0;
        int end = 0, count = 0, len = 1;
        while (end < a.length - 1) {
            if (a[end] < a[end + 1])
            {
                count += len;
                len++;
            }
            else
                len = 1;

            end++;
        }
        return count;
    }
}
