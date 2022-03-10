/**
המטבעות העומדים לרשותנו הם : 10 ₪, 5 ₪, 1 ₪

 כתבו תכנית ב-BlueJ הקולטת מהמשתמש את הסכום הרצוי (בשקלים) ומדפיסה את המרתו למספר מינימלי של מטבעות.
 
 *
 * @author amit
 * @version 26.2.22
 */
import java.util.Scanner;
public class Coins
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number: ");
        int sum = scan.nextInt();
        System.out.println("We need " + (sum / 10) + " coins of 10 NIS");
        System.out.println("We need " + (sum % 10 / 5 ) + " coins of 5 NIS");
        System.out.println("We need " + (sum % 5) + " coins of 1 NIS");
    }
}
