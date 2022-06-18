public class Moed87 {
    public static int totalWays(int[][] mat, int k) {
        if (mat.length == 1 || mat[0].length == 1)
            return 0;
        return totalWays(mat, k, 0, 0, 0);
    }

    private static int totalWays(int[][] mat, int k, int row, int col, int count) {
        int rows = mat.length, cols = mat[0].length;
        if (row >= rows || row < 0 || col >= cols || col < 0)
            return 0;
        int temp = mat[row][col];
        mat[row][col] = Integer.MIN_VALUE;

        if (row - 1 >= 0 && col - 1 >= 0 && mat[row - 1][col - 1] == Integer.MIN_VALUE)
            count++;
        if (count == k && row == rows - 1 && col == cols - 1)
            return 1;
        if (row == rows - 1 && col == cols - 1)
            return 0;
        int down = totalWays(mat, k, row + 1, col, count);
        int right = totalWays(mat, k, row, col + 1, count);

        mat[row][col] = temp;

        return right + down;

    }

    public static void printTriplets(int[] a, int num)
    {
        if (a == null || a.length < 3)
            return;
        for (int first = 0; first < a.length - 2; first++)
        {
            for (int second = first + 1, third = a.length - 1; second < third; )
            {
                if (a[first] * a[second] * a[third] == num) {
                    System.out.println(a[first] + " " + a[second] + " " + a[third]);
                    second++;
                }
                else if (a[first] * a[second] * a[third] > num)
                    third--;
                else
                    second++;
            }
        }
    }

    public static void main(String[] args) {
        int[][] mat = new int[3][3];
        for (int k = 1; k <= 4; k++)
            System.out.println("k: " + k + " - ways: " + totalWays(mat, k));
        printTriplets(new int[]{1, 2, 3, 4, 5, 7, 8, 9}, 40);
//        A a1 = new A();
//        B b2 = new B("B", 5);
//        B b1 = new B("B", 1);
//        A ab = new B();
//        A c = (A) b2;
//        if(b1.equals(ab))
//            System.out.println(5);
//        if(c.equals(a1))
//            System.out.println(10);

    }
}
