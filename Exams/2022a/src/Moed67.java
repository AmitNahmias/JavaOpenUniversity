public class Moed67 {
    public static boolean isIdentity(int[][] mat, int x, int size) {
        return isIdentity(mat, x, x, x, x + size);
    }

    private static boolean isIdentity(int[][] mat, int x, int row, int col, int limit) {
        if (col < limit) {
            if (col == row) // בדיקה של האלכסון
            {
                if (mat[row][col] != 1)
                    return false;
            } else // התאים האחרים
                if (mat[row][col] != 0)
                    return false;
            // בדיקה של השורה
            if (col + 1 < limit)
                return isIdentity(mat, x, row, col + 1, limit);
        }
        if (row + 1 < limit)
            // מעבר בין שורות
            return isIdentity(mat, x + 1, row + 1, x, limit);
        return true;
    }

    public static int maxMatrix(int[][] mat) {
        return maxMatrix(mat, mat.length / 2, 1, 0);
    }

    private static int maxMatrix(int[][] mat, int start, int size, int max) {
        // בדיקה של גבולות
        if (start >= 0 && start + size < mat.length)
            // בדיקה האם התת מטריצה עומדת בתנאים
            if (isIdentity(mat, start, size))
                // מציאת מקסימום תוך שינוי גודל התת מטריצה
                max = getMax(max, maxMatrix(mat, start - 1, size + 2, size));
            else
                return max; // סיום עקב הגעה לתת מטריצה שאינה עומדת בתנאים
        return max; // סיום עקב חריגה מגבולות
    }

    private static int getMax(int a, int b) {
        return a > b ? a : b;
    }

    public static int findMissingIndex(int[] a)
    { // סיבוכיות הריצה היא log(n) וסיבוכיות המקום היא קבועה
        // מציאת ההפרש
        int diff = (a[1] - a[0]) > (a[2] - a[1]) ? (a[2] - a[1]) : (a[1] - a[0]);
        int high = a.length / 2, low = high - 1;
        while (low >= 0 && high <= a.length - 1) {
            if (a[low] + diff * (high - low) != a[high])
                return low + 1;
            high++;
            low--;
        }
        return a.length;
    }

    public static void main(String[] args) {
        int[][] a =
                {
                        {1, 2, 3, 2, 0, 1, 2},
                        {0, 1, 0, 0, 0, 3, 0},
                        {0, 0, 1, 0, 0, 0, 0},
                        {5, 0, 0, 1, 0, 0, 0},
                        {7, 0, 0, 0, 1, 0, 0},
                        {8, 0, 0, 0, 0, 1, 0},
                        {1, 0, 0, 0, 0, 0, 0}
                };
//        boolean result = isIdentity(a, 1, 4);
//        System.out.println(result);
//        int b = maxMatrix(a);
//        System.out.println(b);
        System.out.println(findMissingIndex(new int[]{2,4,6,8,10}));
    }
}

//    public static boolean isIdentity(int[][] mat, int x, int size) {
//        return isIdentity(mat, x + size, x, x);
//    }
//
//    private static boolean isIdentity(int[][] mat, int lim, int i, int j) {
//        if (j == lim) {
//            i++;
//            j = 0;
//        }
//        if (i == lim)
//            return true;
//        boolean ans = false;
//        if (i == j && mat[i][j] == 1) ans = true;
//        else if (i != j && mat[i][j] == 0) ans = true;
//        return ans && isIdentity(mat, lim, i, j + 1);
//
//    }