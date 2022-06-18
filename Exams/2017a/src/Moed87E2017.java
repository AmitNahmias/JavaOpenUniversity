public class Moed87E2017 {
    public static boolean covers(int[][] mat, int[] arr, int k) {
        int[] a = new int[arr.length];
        copy(a, arr);
        return covers(mat, a, k, 0);
    }

    private static boolean covers(int[][] mat, int[] arr, int k, int row) {
        if (k >= 0 && allZero(arr))
            return true;
        if (row >= mat.length || k < 0)
            return false;
        int[] b = new int[arr.length];
        copy(b, arr);
        xZero(b, mat[row]);
        return covers(mat, b, k - 1, row + 1) || covers(mat, arr, k, row + 1);
    }

    // the implementations are not part of the solution
    private static boolean allZero(int[] x) {
        for (int i = 0; i < x.length; i++)
            if (x[i] != 0)
                return false;
        return true;
    }

    private static void copy(int[] dest, int[] src) {
        for (int i = 0; i < src.length; i++) {
            dest[i] = src[i];
        }
    }

    private static void xZero(int[] x, int[] y) {
        int max = 0;
        for (int i = 0; i < y.length; i++) {
            max = Math.max(max, y[i]);
        }
        boolean[] exists = new boolean[max + 1];

        for (int i = 0; i < y.length; i++) {
            exists[y[i]] = true;
        }

        for (int i = 0; i < x.length; i++) {
            if (x[i] < exists.length && exists[x[i]])
                x[i] = 0;
        }
    }

    public static boolean isPythagorean(int[] arr) {
        for (int c = arr.length - 1; c > 1; c--)
        {
            int a = 0, b = c - 1;
            while (a <= b)
            { // a and b are indices
                int sum = arr[a] * arr[a] + arr[b] * arr[b], cS = arr[c] * arr[c];
                if (sum < cS)
                    a++;
                else if (sum > cS)
                    b--;
                else
                    return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println("<b><u> Question 1 </b></u>");
        int[] arr = {7, 2, 3};
        int[][] mat = {
                {1, 5, 7},
                {3, 2, 9},
                {1, 2, 3}
        };
        System.out.println(covers(mat, arr, 2));
        int[] a = {6, 7, 8, 9, 10}, b = {4, 5, 6, 10, 12};
        System.out.println(isPythagorean(a));
    }
}
