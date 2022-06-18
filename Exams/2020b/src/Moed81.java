public class Moed81 {

    public static int makeSum(int[] lengths, int k, int num) {
        if (lengths == null || lengths.length == 0) return 0;
        return makeSum(lengths, k, num, 0);
    }

    private static int makeSum(int[] lengths, int k, int num, int pos) {
        if (k == 0)
            return 1;
        else if (k < 0 || num == 0 || pos == lengths.length)
            return 0;
        return makeSum(lengths, k - lengths[pos], num - 1, pos) + makeSum(lengths, k, num, pos + 1);
    }


    public static void minimumSubK(int[] arr, int k) {
        if (arr.length == 0) {
            System.out.println("Minimum sum sub-array is (0,0)");
            return;
        }
        int minSum = 0;
        for (int index = 0; index < k; index++)
            minSum += arr[index];
        int low = 0, tempLow = 1, high = k - 1, tempHigh = k;
        if (k == arr.length) {
            System.out.println("Minimum sum sub-array is (0," + high + ")");
            return;
        }

        int sumK = minSum + arr[tempHigh] - arr[low];
        while (tempHigh < arr.length - 1) {
            if (minSum > sumK) {
                minSum = sumK;
                low = tempLow;
                high = tempHigh;
            }
            sumK = sumK - arr[tempLow++] + arr[tempHigh++ + 1];
        }
        System.out.println("Minimum sum sub-array is (" + low + "," + high + ")");
    }

    public static void main(String[] args) {
        int[] a = {10, 4, 2, 5, 6, 3, 8, 1, 5, 9};
//        minimumSubK(a, 2);
        First f1 = new First("One");
        f1.print();
        First f2 = new First("Two");
        f2.print();
        First f3 = new First(f2);
        f3.print();
        First f4 = new First();
        f4.print();
        Second s1 = new Second(f1,f3);
        s1.print();
        Second s2 = new Second(f4,f2);
        s2.print();
    }
}
