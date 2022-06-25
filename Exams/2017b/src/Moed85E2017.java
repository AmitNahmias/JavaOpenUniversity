public class Moed85E2017 {
    public static int oneFiveSeven(int n) {
        if (n == 0)
            return n;
        return Math.min(Math.min(oneFiveSeven(n - 1, 1), oneFiveSeven(n - 5, 1)), oneFiveSeven(n - 7, 1));
    }

    private static int oneFiveSeven(int n, int count) {
        if (n == 0)
            return count;
        else if (n < 0)
            return Integer.MAX_VALUE;
        count++;
        return Math.min(Math.min(oneFiveSeven(n - 1, count), oneFiveSeven(n - 5, count)), oneFiveSeven(n - 7, count));
    }

    public static void printClosest(int[] a, int[] b, int x) {
        if (a == null || b == null || a.length == 0 || b.length == 0)
            return;
        if (a[a.length - 1] + b[b.length - 1] <= x) {
            System.out.println(a[a.length - 1] + " and " + b[b.length - 1]);
            return;
        }
        int aI = 0, bI = b.length - 1, minA = a[aI], minB = b[bI], minDiff = Integer.MAX_VALUE;
        while (aI < a.length && bI >= 0)
        {
            if (Math.abs(a[aI] + b[bI] - x) < minDiff) {
                minA = a[aI];
                minB = b[bI];
                minDiff = Math.abs(a[aI] + b[bI] - x);
            }
            if (a[aI] + b[bI] < x)
                aI++;
            else if (a[aI] + b[bI] > x)
                bI--;
            else
                break;
        }
        System.out.println(minA + " and " + minB);

    }


    public static void main(String[] args) {
//        System.out.println(oneFiveSeven(10));
//        System.out.println(oneFiveSeven(5));
//        System.out.println(oneFiveSeven(6));
//        System.out.println(oneFiveSeven(0));
        int[] a = {10, 20, 30, 40}, b = {0, 4, 6, 11, 11}, q = {11, 13, 18, 70};
        for (int x : q) {
            System.out.print("x = " + x + ". result: ");
            printClosest(a, b, x);
            System.out.println("----");
        }
    }
}