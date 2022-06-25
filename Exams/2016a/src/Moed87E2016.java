public class Moed87E2016 {
    public static int minDiff(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;
        int sum1 = sum(arr, 0);
        return minDiff(arr, sum1, 0, 0, sum1);

    }

    private static int minDiff(int[] arr, int sum1, int sum2, int i, int diff) {
        if (Math.abs(sum1-sum2) < diff)
            diff = Math.abs(sum1-sum2);
        if (arr.length == i)
            return diff;
        return Math.min(minDiff(arr,sum1,sum2,i+1,diff),minDiff(arr,sum1-arr[i],sum2+arr[i],i+1,diff));
    }

    private static int sum(int[] arr, int i) {
        if (i < arr.length)
            return arr[i] + sum(arr, i + 1);
        return 0;
    }
    public static int passingCars(int []a)
    {
        if (a == null || a.length<=1)
            return 0;
        int sum = 0, count = 0;
        for (int i = 0; i<a.length;i++)
        {
            if (a[i]==0)
                count++;
            else
                sum+=count;
        }
        return sum;
    }
    public static void main(String[]args)
    {
        int[] arr = {1,2,7,17,6};
        System.out.println(minDiff(arr));
        System.out.println(passingCars(new int[] {0, 1, 0, 1, 1}));
    }

}
