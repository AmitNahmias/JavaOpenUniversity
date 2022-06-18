public class Moed85E2018 {
    public static int longestSlope(int[][] mat, int num) {
        if (mat == null)
            return 0;
        return longestSlope(mat, num, 0, 0, 1);
    }

    private static int longestSlope(int[][] mat, int num, int row, int col, int count) {
        int temp = mat[row][col];

        if (isLast(mat, row, col, num, count) && count > 1)
            return count;

        int down = 0, up = 0, right = 0, left = 0;
        if (row > 0)
            if (temp - mat[row - 1][col] == num * count)
                up = longestSlope(mat, num, row - 1, col, count + 1);
            else
                up = longestSlope(mat, num, row - 1, col, 1);
        if (row < mat.length - 1)
            if (temp - mat[row + 1][col] == num * count)
                down = longestSlope(mat, num, row + 1, col, count + 1);
            else
                down = longestSlope(mat, num, row + 1, col, 1);
        if (col > 0)
            if (temp - mat[row][col - 1] == num * count)
                left = longestSlope(mat, num, row, col - 1, count + 1);
            else
                left = longestSlope(mat, num, row, col - 1, 1);
        if (col < mat[0].length - 1)
            if (temp - mat[row][col + 1] == num * count)
                right = longestSlope(mat, num, row, col + 1, count + 1);
            else
                right = longestSlope(mat, num, row, col + 1, 1);

        return Math.max(Math.max(down, up), Math.max(right, left));
    }

    private static boolean isLast(int[][] mat, int row, int col, int num, int count) {
        if (row > 0 && mat[row][col] - mat[row - 1][col] == num * count)
            return false;
        if (row < mat.length - 1 && mat[row][col] - mat[row + 1][col] == num * count)
            return false;
        if (col > 0 && mat[row][col] - mat[row][col - 1] == num * count)
            return false;
        if (col < mat[0].length - 1 && mat[row][col] - mat[row][col + 1] == num * count)
            return false;
        return true;
    }

    public static int what(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++)
            sum += arr[i];

        if (sum % 2 == 1)
            return arr.length;
        int high = arr.length - 1, temp = sum;
        while (temp % 2 == 0 && high > 0) {
            temp -= arr[high];
            high--;
        }
        int sizeLeft = high + 1;
        int low = 0, temp2 = sum;
        while (temp2 % 2 == 0 && low < arr.length) {
            temp2 -= arr[low];
            low++;
        }
        int sizeRight = arr.length - low;
        return Math.max(sizeRight, sizeLeft);
    }

    public static void main(String[] args) {

        System.out.println("<b><u> Question 1: </b></u>");
        int[][] mat = {
                {3, 13, 15, 28, 30},
                {55, 54, 53, 27, 26},
                {54, 12, 52, 51, 50},
                {50, 10, 8, 53, 11}
        };
        System.out.println(longestSlope(mat, 1));

        System.out.println("<hr><b><u>Question 2:</b></u>");
        int[] arr = {2, 2, 5, 2, 1};
//        int[] arr = {1, 4, 7, 3, 2, 5, 0, 6, 8, 2};
        System.out.println(what(arr));
    }

}
