/**
כתבו ב-BlueJ תכנית הקולטת מספר שלם למשתנה num.

 אם num הוא 1 או 2, הגדילו אותו ב-1.
 אם num בין 3 ל-5 כולל, הקטינו אותו ב-1.
 אם num שווה ל-6, הכפילו אותו ב-2.
 אם num הוא לא בין המספרים שציינו, הכפילו אותו ב-3.
הדפיסו את המספר שהתקבל.
 *
 * @author amit
 * @version 26.2.22
 */
import java.util.Scanner;
public class FirstQuestion
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number: ");
        int num = scan.nextInt();
        switch ( num )
        {
            case 1:
            case 2:
                num++;
                System.out.println(num);
                break;
            case 3:
            case 4:
            case 5:
                num--;
                System.out.println(num);
                break;
            case 6:
                num*=2;
                System.out.println(num);
                break;
            default:
                num*=3;
                System.out.println(num);
        }
    }
}
