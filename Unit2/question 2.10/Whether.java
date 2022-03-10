/**
 * Gets four numbers that represent the next four days whether.
 * Prints if the whether is not usually.
 */

import java.util.Scanner;

public class Whether {
    public static void main(String[] args) {
        final int HOT_DAY = 30; // in degrees
        final int COLD_DAY = 5;  // in degrees
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter whether: ");
        int firstDay = scan.nextInt();
        int secondDay = scan.nextInt();
        int thirdDay = scan.nextInt();
        int fourthDay = scan.nextInt();
        int countCold = 0;
        int countHot = 0;
        if (firstDay >= HOT_DAY)
            countHot++;
        else if (firstDay <= COLD_DAY)
            countCold++;
        if (secondDay >= HOT_DAY)
            countHot++;
        else if (secondDay <= COLD_DAY)
            countCold++;
        if (thirdDay >= HOT_DAY)
            countHot++;
        else if (thirdDay <= COLD_DAY)
            countCold++;
        if (fourthDay >= HOT_DAY)
            countHot++;
        else if (fourthDay <= COLD_DAY)
            countCold++;
        if ((countHot == 1) || (countHot == 2) || (countCold == 1))
            System.out.println("Usual");
        else if ((countHot == 3) || (countHot == 4) || (countCold >= 2))
            System.out.println("Extreme");
        else
            System.out.println("Other");
    }
}
