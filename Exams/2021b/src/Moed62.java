public class Moed62 {
    public static boolean equalSplit(int[] arr) {
        if (arr.length == 0)
            return true;
        else if (arr.length % 2 == 1)
            return false;
        return equalSplit(arr, arr[0], 1, 0, 0, 1);
    }

    public static boolean equalSplit(int[] arr, int sum1, int count1, int sum2, int count2, int pos) {
        if (pos < arr.length)
        {
            return equalSplit(arr, sum1 + arr[pos], count1 + 1, sum2, count2, pos + 1) ||
                    equalSplit(arr, sum1, count1, sum2 + arr[pos], count2 + 1, pos + 1);
        }
        else
            return (sum1 == sum2 && count1 == count2);
    }

    public static boolean search(int[][] mat, int num) {
        int row = 0, col = 0;
        int len = mat.length;
        if (num > mat[len - 1][0] || num < mat[0][0]) return false;
        while (len > 1)
        {
            int minS1 = mat[row][col];
            int maxS1 = mat[len / 2 - 1 + row][col];
            int minS2 = mat[row][col + len / 2];
            int maxS2 = mat[len / 2 - 1 + row][col + len / 2];
            int minS3 = mat[len / 2 + row][col + len / 2];
            int maxS3 = mat[len - 1 + row][col + len / 2];
            int minS4 = mat[len / 2 + row][col];
            int maxS4 = mat[len - 1 + row][col];
            if (num>maxS2)
            {
                if (num < minS4)
                    col+=len/2;
                row+=len/2;
            }
            else
                if (num > maxS1)
                    col+=len/2;
            len = len / 2;
        }
        if (num == mat[row][col])
        {
            System.out.println("row = "+row);
            System.out.println("col = "+col);
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
//        int[] a = {-3, 5, -12, 14, -9};
//        boolean x = equalSplit(a);
//        System.out.println(x);
        int[][] arr =
                {
                        {1, 3, 7, 9},
                        {6, 4, 15, 11},
                        {36, 50, 21, 22},
                        {60, 55, 30, 26}
                };
        boolean r = search(arr, 26);
        System.out.println(r);
    }

}
