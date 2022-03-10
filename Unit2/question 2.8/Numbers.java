/**
כתבו תכנית ב-BlueJ, תחת מחלקה חדשה בשם Numbers, הקולטת שני מספרים שלמים לתוך שני משתנים בשם num1, num2.
 התכנית תדפיס את תרגיל החיבור של שני המספרים, ולאחר מכן את תרגיל החיסור של שני המספרים.
 *
 * @author amit
 * @version 26.2.22
 */
import java.util.Scanner;
public class Numbers
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter two numbers: ");
        int num1 = scan.nextInt();
        int num2 = scan.nextInt();
        System.out.println(num1 + "+" + num2 + "=" + (num1+num2));
        System.out.println(num1 + "-" + num2 + "=" + (num1-num2));
    }
}
