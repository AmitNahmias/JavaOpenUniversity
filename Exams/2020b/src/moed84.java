public class moed84
{
    public static void findWord(char[][] arr, String word) {
        int[][] resultMat = new int[arr.length][arr.length];
        findWord(arr, word, 0, 0, resultMat);
    }

    public static void findWord(char[][] arr, String word, int row, int col, int[][] mat) {
        if (col == arr.length) {
            col = 0;
            row++;
        }
        if (row < arr.length)
            if (findWord(arr, word, row, col, mat, 0))
                printArr(mat);
            else
                findWord(arr, word, row, col + 1, mat);
        else
            System.out.println("No such word");
    }

    private static boolean findWord(char[][] arr, String word, int row, int col, int[][] mat, int pos) {
        if (pos == word.length())
            return true;
        else {
            if (row < mat.length && row >= 0 && col < mat.length && col >= 0 && word.charAt(pos) == arr[row][col] && mat[row][col] == 0) {
                pos++;
                mat[row][col] = pos;
                arr[row][col] = '#';

                boolean down = findWord(arr, word, row + 1, col, mat, pos);
                boolean right = findWord(arr, word, row, col + 1, mat, pos);
                boolean left = findWord(arr, word, row, col - 1, mat, pos);
                boolean up = findWord(arr, word, row - 1, col, mat, pos);

                arr[row][col] = word.charAt(pos - 1);

                if (down || up || right || left)
                    return true;
                mat[row][col] = 0;
                return false;
            }
            return false;
        }
    }
    public static void findFactors(int n)
    {
        int low = 1,high = n - 1,mid;
        while (low <  high)
        {
            mid = (high + low) / 2;
            if (isHighFactorInRange(n, low, mid))
                high = mid;
            else
                low = mid + 1;
        }
        System.out.println("First " + high + " second " + n / high);
    }

    // not part of the solution
    public static boolean isHighFactorInRange(int n, int low, int high) {
        int p = findHighFactor(n);
        return p >= low && p <= high;
    }

    static int findHighFactor(int n) {
        for (int i = n - 1; i > 1; i--) {
            if (isPrime(i) && n % i == 0)
                return i;
        }
        return n;
    }

    static boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
    static void printArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++)
                System.out.print((arr[i][j] == 0 ? 0 : arr[i][j]) + "\t");
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        char[][] arr =
                {
                        {'t', 'z', 'x', 'c', 'd'},
                        {'s', 'h', 'a', 'z', 'x'},
                        {'h', 'w', 'l', 'o', 'm'},
                        {'o', 'r', 'n', 't', 'n'},
                        {'a', 'b', 'r', 'i', 'n'}
                };
//        findWord(arr, "shalom");
        findFactors(8509);

    }


}

