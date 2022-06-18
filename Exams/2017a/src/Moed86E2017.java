import java.util.Arrays;

public class Moed86E2017 {
    public static int edit(String str1, String str2) {
        if (str1.equals(str2))
            return 0;
        if (str1.isEmpty() || str2.isEmpty())
            return Math.max(str1.length(), str2.length());
        return edit(str1, str2, 0);
    }

    private static int edit(String str1, String str2, int i) {
        if (str1.equals(str2))
            return 0;

        if (i > str2.length() - 1 || i > str1.length() - 1)
            return Integer.MAX_VALUE;

        if (str1.charAt(i) == str2.charAt(i))
            return edit(str1, str2, i + 1);

        int delete = edit(str1.substring(0, i) + str1.substring(i + 1), str2, i + 1);
        int add = edit(str1.substring(0, i) + str2.charAt(i) + str1.substring(i), str2, i + 1);

        if (add == Integer.MAX_VALUE && delete == Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        return 1 + Math.min(add, delete);

    }

    public static int countTriplets(int[] arr, int num) {
        if (arr.length < 3)
            return 0;
        int count = 0;
        for (int first = 0; first < arr.length - 2; first++)
        {
            for (int second = first + 1, third = arr.length - 1; second < third; )
            {
                if (arr[first] + arr[second] + arr[third] < num)
                {
                    count += third - second;
                    second++;
                }
                else
                    third--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
//        System.out.println(edit("geek", "geek"));
        int[] a = {1, 3, 4, 5, 7};
//        System.out.println(countTriplets(a, 12));
        AA1 a5 = new AA1();
        Object o = a5;
        ((BB1)o).f();
        

    }
}
