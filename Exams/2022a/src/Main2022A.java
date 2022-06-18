public class Main2022A {
    /**
     * Gets two strings and integer as input and returns true if the second string is appears inside the first one
     * from the beginning with jumps of the input number.
     *
     * @param str1 First input string.
     * @param str2 Second input string.
     * @param step Input number.
     * @return True if the second string is appears inside the first one from the beginning with jumps of the input number.
     */
    public static boolean isJump(String str1, String str2, int step) {
        if (str1.length() >= str2.length()) {
            if (str2.length() == 1 && str1.charAt(0) == str2.charAt(0))
                return true;
            if (str1.charAt(0) == str2.charAt(0))
                return isJump(str1.substring(step), str2.substring(1), step);
            else return false;
        } else
            return false;
    }

    /**
     * Gets two input strings and returns the value of the 'jump' of str2 inside str1 from the first char in str1.
     *
     * @param str1 First Input string.
     * @param str2 Second input string.
     * @return The 'jump' of str2 inside str1 from the first char in str1.
     */
    public static int strStep(String str1, String str2) {
        if (str1.length() >= str2.length() && str1.charAt(0) == str2.charAt(0))
            return strStep(str1, str2, 1);
        return -1;
    }

    private static int strStep(String str1, String str2, int step) {
        if (step >= str1.length())
            return -1;
        if (isJump(str1, str2, step))
            return step;
        return strStep(str1, str2, step + 1);
    }

    public static int longestSubarray(int[] a)
    { // סיבוכיות מקום קבועה ויעילות לינארית
        int count = 1, start = 0, temp = 0;
        for (int i = 0; i < a.length - 2; i++)
        {
            if (a[i] < 0 && a[i+1] > 0 || a[i] > 0 && a[i+1] < 0)
                count++;
            else
            {
                if (temp < count) // בדיקת המקסימום
                {
                    temp = count;
                    start = i - temp + 1;
                }
                count = 1; // איפוס של count
            }
        }
        System.out.println("Starting index  = " + start + " Ending index = " + (start + temp - 1));
        return temp;
    }

    public static void main(String[] args) {
//        boolean x = isJump("ab", "abcd", 1);
//        System.out.println(x);
//        System.out.println(strStep("abcfbaagcxabcd", "abc"));
        System.out.println(longestSubarray(new int[]{1,2,3,4,5,4}));
    }
}
