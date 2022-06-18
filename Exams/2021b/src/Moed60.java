public class Moed60 {
    public static boolean split3(int[] arr) {
        if (arr.length == 0)
            return true;
        else if (arr.length <= 2)
            return false;
        return split3(arr, arr[0], 0, 0, 1);
    }

    private static boolean split3(int[] arr, int sum1, int sum2, int sum3, int pos) {
        if (pos < arr.length)
            return split3(arr, sum1 + arr[pos], sum2, sum3, pos + 1)
                    || split3(arr, sum1, sum2 + arr[pos], sum3, pos + 1)
                    || split3(arr, sum1, sum2, sum3 + arr[pos], pos + 1);
        else
            return sum1 == sum2 && sum1 == sum3 && sum1 > 0;
    }

    public static int smallestSub(int[] a, int k) {
        int first = 0, second = 0;
        int sum = 0, count = 0, minLen = a.length + 1;
        while (first < a.length)
        {
            if (second == a.length)
            {
                if (sum > k)
                    minLen = minLen < count ? minLen : count;
                sum = 0;
                count = 0;
                second = first + 1;
                first++;
            }
            else if (sum > k)
            {
                minLen = minLen < count ? minLen : count;
                sum = 0;
                count = 0;
                second = first + 1;
                first++;
            }
            else if (a[second] > k)
                return 1;
            else
            {
                sum = sum + a[second];
                count++;
                second++;
            }
        }
        return minLen;
    }

    public static void main(String[] args) {
//        int[] arr = {8, 4, 7, 1, 2, 3, 5};
//        boolean x = split3(arr);
//        System.out.println(x);
        int[] a = {1, 4, 13, 6, 0, 19};
        int result = smallestSub(a, 0);
        System.out.println(result);
    }
}
