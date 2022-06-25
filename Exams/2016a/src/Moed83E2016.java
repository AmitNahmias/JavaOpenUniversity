public class Moed83E2016 {
    public static boolean findX(int[] a, int x)
    {
        if (a == null || a.length <= 1)
            return false;
        int low = 0, high = a.length - 1, mid;
        while (low < high)
        {
            mid = (high + low) / 2;

            if (a[mid] + a[mid + 1] == x)
                return true;
            else if (a[mid] + a[mid + 1] < x)
                low = mid + 1;
            else
                high = mid;
        }
        return false;
    }
    public static void main(String[]args)
    {
        int[] arr = {1,2,5,3,6,10}; // 3,7,8,9,16
        System.out.println(findX(arr, 9));
    }
}
