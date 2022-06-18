public class Moed84E2019 {
    public static boolean sumPower3(int num) {
        if (num < 0)
            return false;
        return sumPower3(num, 0, 0);
    }

    private static boolean sumPower3(int num, int pow, int sum) {
        if (num == sum)
            return true;
        if (num < sum || (int) Math.pow(3, pow) > num)
            return false;
        return sumPower3(num, pow + 1, (int) (sum + Math.pow(3, pow))) || sumPower3(num, pow + 1, sum);
    }

    public static int average(int[] arr) {
        if (arr == null || arr.length == 0)
            return -1;
        int sum = 0;
        for (int i = 0; i < arr.length; i++)
            sum += arr[i];

        int result = -1, sumLeft = 0;
        double diff = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            sumLeft += arr[i];
            sum -= arr[i];
            double avgLeft = (double) sumLeft / (i + 1);
            double avg = (double) sum / (arr.length - (i + 1));
            if (Math.abs(avgLeft - avg) > diff) {
                diff = Math.abs(avgLeft - avg);
                result = i;
            }
        }
        return result;

    }

    public static void main(String[] args) {
        System.out.println("<b><u> Question 1 </b></u>");
        System.out.println(sumPower3(37));
        //--

        System.out.println("<hr><b><u> Question 2 </b></u>");
        int[] arr = {5, 7, -2, 10};
        System.out.println(average(arr));


    }
}
