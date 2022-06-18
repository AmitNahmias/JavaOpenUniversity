public class Moed96 {
    public static int maxSumKnight(int[][] mat) {
        if (mat.length <= 1 || mat[0].length <= 1)
            return 0;
        return maxSumKnight(mat, 0, 0, 0, mat[0][0]);
    }

    private static int maxSumKnight(int[][] mat, int row, int col, int sum, int prev) {
        int rows = mat.length, cols = mat[0].length;
        if (row >= rows || row < 0 || col >= cols || col < 0)
            return 0;

        int temp = mat[row][col];

        if (!abs(temp, prev))
            return 0;

        sum += temp;
        if (row == rows - 1 && col == cols - 1)
            return sum;

        mat[row][col] = -10;

        int move1 = maxSumKnight(mat, row + 2, col + 1, sum, temp);
        int move2 = maxSumKnight(mat, row + 2, col - 1, sum, temp);
        int move3 = maxSumKnight(mat, row - 2, col + 1, sum, temp);
        int move4 = maxSumKnight(mat, row - 2, col - 1, sum, temp);
        int move5 = maxSumKnight(mat, row + 1, col + 2, sum, temp);
        int move6 = maxSumKnight(mat, row + 1, col - 2, sum, temp);
        int move7 = maxSumKnight(mat, row - 1, col + 2, sum, temp);
        int move8 = maxSumKnight(mat, row - 1, col - 2, sum, temp);

        mat[row][col] = temp;

        return max(move1, max(move2, max(move3, max(move4, max(move5, max(move6, max(move7, move8)))))));
    }

    private static boolean abs(int a, int b) {
        return a - b == 0 || a - b == 1 || a - b == -1;
    }

    private static int max(int a, int b) {
        return a > b ? a : b;
    }

    public static int minimalPositive(Range[] rangeA) {
        if (rangeA.length == 0)
            return -1;
        int low = 0, high = rangeA.length - 1, mid;
        while (low < high) {
            mid = (high + low) / 2;
            if (rangeA[mid].getSmall() > 0 || rangeA[mid].getBig() > 0)
                high = mid;
            else
                low = mid + 1;
        }
        if (rangeA[high].getBig() < 0 && rangeA[high].getSmall() < 0)
            return -1;
        if (rangeA[high].getSmall() > 0)
            return rangeA[high].getSmall();
        else return 1;

    }

    public static void main(String[] args) {
        int[][] mat = {
                {4, 5, 6, 7, 1},
                {3, 5, 1, 7, 4},
                {4, 5, 6, 5, 8},
                {3, 4, 7, 7, 9},
                {6, 2, 2, 7, 6}
        };
//        System.out.println(maxSumKnight(mat));

        Range[] arr = {new Range(-7, -3), new Range(-1, -1), new Range(4, 6), new Range(20, 22)};
        System.out.println(minimalPositive(arr));
    }
}

class Range {
    private int _small, _big;

    public Range(int s, int b) {
        _small = s;
        _big = b;
    }

    public int getSmall() {
        return _small;
    }

    public int getBig() {
        return _big;
    }
}
//    private static int maxSumKnight(int[][] mat, int row, int col) {
//        int rows = mat.length, cols = mat[0].length;
//        int temp = mat[row][col];
//        if (row == rows - 1 && col == cols - 1)
//            return temp;
//
//        mat[row][col] = -10;
//
//        int move1 = 0, move2 = 0, move3 = 0, move4 = 0, move5 = 0, move6 = 0, move7 = 0, move8 = 0;
//        if (row + 2 < rows) {
//            if (col + 1 < cols && abs(temp, mat[row + 2][col + 1]))
//                move1 = temp + maxSumKnight(mat, row + 2, col + 1);
//            if (col - 1 >= 0 && abs(temp, mat[row + 2][col - 1]))
//                move2 = temp + maxSumKnight(mat, row + 2, col - 1);
//        }
//        if (row - 2 >= 0) {
//            if (col + 1 < cols && abs(temp, mat[row - 2][col + 1]))
//                move3 = temp + maxSumKnight(mat, row - 2, col + 1);
//            if (col - 1 >= 0 && abs(temp, mat[row - 2][col - 1]))
//                move4 = temp + maxSumKnight(mat, row - 2, col - 1);
//        }
//        if (row + 1 < rows) {
//            if (col + 2 < cols && abs(temp, mat[row + 1][col + 2]))
//                move5 = temp + maxSumKnight(mat, row + 1, col + 2);
//            if (col - 2 >= 0 && abs(temp, mat[row + 1][col - 2]))
//                move6 = temp + maxSumKnight(mat, row + 1, col - 2);
//        }
//        if (row - 1 >= 0) {
//            if (col + 2 < cols && abs(temp, mat[row - 1][col + 2]))
//                move7 = temp + maxSumKnight(mat, row - 1, col + 2);
//            if (col - 2 >= 0 && abs(temp, mat[row - 1][col - 2]))
//                move8 = temp + maxSumKnight(mat, row - 1, col - 2);
//        }
//        System.out.println("col " + col + " row " + row + " temp " + temp);
//        mat[row][col] = temp;
//
//        return max(move1, max(move2, max(move3, max(move4, max(move5, max(move6, max(move7, move8)))))));
//    }