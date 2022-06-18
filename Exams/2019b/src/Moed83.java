public class Moed83 {
    public static int longestPath(int[][] mat, int x, int y) {
        if (mat == null || mat.length <= x || mat[0].length <= y || y < 0 || x < 0)
            return 0;
        return longestPath(mat, x, y, 0, 0);
    }

    private static int longestPath(int[][] mat, int x, int y, int row, int col) {
        if (mat.length <= row || mat[0].length <= col || col < 0 || row < 0 || mat[row][col] == 0)
            return 0;
        if (row == x && col == y)
            return 1;
        mat[row][col] = 0;
        int right = longestPath(mat, x, y, row, col + 1);
        int left = longestPath(mat, x, y, row, col - 1);
        int down = longestPath(mat, x, y, row + 1, col);
        int up = longestPath(mat, x, y, row - 1, col);
        mat[row][col] = 1;
        return 1 + Math.max(up, Math.max(down, Math.max(right, left)));
    }
    public static void main(String[] args) {
        System.out.println("<b><u> Question 1 </b></u>");
        int[][] mat = {
                {1,1,1,1,1,1,1},
                {1,1,0,1,0,0,1},
                {1,1,1,1,0,1,1}
        };
        System.out.println(longestPath(mat, 2, 5));
        //--

//        System.out.println("<hr><b><u> Question2 </b></u>");
//        int[][] arr = {
//                {-99,-72,-64,-55,-28,-10,-5},
//                {-72,-53,-46,-38,11,13,22},
//                {-63,-48,-27,-12,14,16,23},
//                {-44,-29,-10,0,18,20,28},
//                {0,12,14,20,28,30,35}
//        };
//        System.out.println(Question2.howManyNegativeNumbers(arr));
    }
}
