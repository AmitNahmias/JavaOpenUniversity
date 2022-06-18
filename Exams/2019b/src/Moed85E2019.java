public class Moed85E2019 {
    public static int howManyPaths(int[][] mat) {
        if (mat == null)
            return 0;
        return howManyPaths(mat, 0, 0);
    }

    private static int howManyPaths(int[][] mat, int row, int col) {
        if (row < 0 || row > mat.length - 1 || col < 0 || col > mat[0].length - 1 || mat[row][col] == 0)
            return 0;
        else if (row == mat.length - 1 && col == mat[0].length - 1)
            return 1;
        int k = mat[row][col];
        mat[row][col] = 0;
        int d = howManyPaths(mat, row + k, col);
        int r = howManyPaths(mat, row, col + k);
        int l = howManyPaths(mat, row, col - k);
        int u = howManyPaths(mat, row - k, col);
        mat[row][col] = k;
        return u + r + l + d;
    }

    public static int meetPoint(int[] a, int[] b) {
        int result = -1;
        if (a == null || b == null || a.length == 0 || b.length == 0)
            return result;

        int low = 0, mid, high = a.length - 1;
        ;
        if (a.length > b.length)
            high = b.length - 1;
        while (low < high) {
            mid = (high + low) / 2;
            if (a[mid] == b[mid]) {
                result = mid;
                high = mid;
            } else if (a[mid] < b[mid])
                high = mid;
            else
                low = mid+1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] d =
                {
                        {1, 3, 1, 6},
                        {2, 8, 1, 2},
                        {6, 2, 7, 5},
                        {2, 4, 1, 3}
                };
        System.out.println(howManyPaths(d));
        int[] a = {19,19,16,15,15,13,13,13,5},
                b = {0,12,13,14,14,15,15,19,25,30,35};
        System.out.println(meetPoint(a,b));
    }
}
