import java.util.Arrays;

public class Moed83E2018 {
    public static int prince(int[][] mat, int i, int j) {
        if (mat == null || i < 0 || j < 0 || i >= mat.length || j >= mat[0].length)
            return -1;
        int res = prince(mat, 0, 0, 0);
        if (res == Integer.MAX_VALUE)
            return -1;
        return res;
    }

    private static int prince(int[][] mat, int row, int col, int count) {
        int rows = mat.length, cols = mat[0].length;
        int temp = mat[row][col];
        if (temp == -1)
            return count + 1;
        if (temp == -10)
            return Integer.MAX_VALUE;
        mat[row][col] = -10;
        count++;

        int down = Integer.MAX_VALUE, up = Integer.MAX_VALUE, right = Integer.MAX_VALUE, left = Integer.MAX_VALUE;

        if (row > 0 && (Math.abs(temp - mat[row - 1][col]) <= 1 || temp - mat[row - 1][col] == 2 || mat[row - 1][col] == -1))
            up = prince(mat, row - 1, col, count);
        if (row < rows - 1 && (Math.abs(temp - mat[row + 1][col]) <= 1 || temp - mat[row + 1][col] == 2 || mat[row + 1][col] == -1))
            down = prince(mat, row + 1, col, count);
        if (col > 0 && (Math.abs(temp - mat[row][col - 1]) <= 1 || temp - mat[row][col - 1] == 2 || mat[row][col - 1] == -1))
            left = prince(mat, row, col - 1, count);
        if (col < cols - 1 && (Math.abs(temp - mat[row][col + 1]) <= 1 || temp - mat[row][col + 1] == 2 || mat[row][col + 1] == -1))
            right = prince(mat, row, col + 1, count);

        mat[row][col] = temp;
        return Math.min(Math.min(down, up), Math.min(right, left));


    }

    public static int findSingle(int[] a)
    {
        if (a.length <= 2)
            return a[0];

        int low = 0, high = a.length - 1;
        while (low <= high)
        {
            int mid = (low + high) / 2;

            if (mid == 0 || mid == a.length - 1 || (a[mid - 1] != a[mid] && a[mid] != a[mid + 1]))
                return a[mid];

            // the missing number can only be in a sub-array with an odd length.
            if (mid % 2 == 0)
            {
                if (a[mid] == a[mid + 1])
                    low = mid + 2;
                else
                    high = mid - 2;
            }
            else
            {
                if (a[mid] == a[mid + 1])
                    high = mid - 1;
                else
                    low = mid + 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        System.out.println("<b><u> Question 1 </b></u>");
        int[][] mat = {
                {2, 0, 1, 2, 3},
                {2, 3, 5, 5, 4},
                {8, -1, 6, 8, 7},
                {3, 4, 7, 2, 4},
                {2, 4, 3, 1, 2}
        },
                mat2 = {
                        {2, 5, 3},
                        {0, 9, -1},
                        {1, 3, 1}
                };
        System.out.println(prince(mat, 0, 0));
        //--


        System.out.println("<hr><b><u> Question 2 </b></u>");
        int[][] q = {
                {6, 6, 18, 18, -4, -4, 12, 9, 9}, // 12
                {8, 8, -7, -7, 3, 3, 0, 0, 10, 10, 5, 5, 4}, // 4
                {5}, // 5
                {1, 1, 2}, // 2
                {2, 1, 1}, // 2
                {1, 1, 2, 2, 3, 4, 4}, // 3
                {1, 0, 0, 2, 2, 3, 3}, // 1
                {1, 1, 2, 2, 3, 3,4, 5, 5, 6, 6, 8, 8}, // 4
                {3, 3, 4, 4, 1}, // 1
                {1, 1, 2, 2, 4, 3, 3}// 4
        };
        for (int[] a : q) {
            System.out.println("Array: " + Arrays.toString(a) + " single num:" + findSingle(a));
            System.out.println("---");
        }
    }


}
