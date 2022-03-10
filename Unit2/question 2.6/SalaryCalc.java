
/**
 כתבו תכנית ב-BlueJ הקולטת שני מספרים המייצגים את גיל העובד (מספר שלם) ושכרו בשקלים (מספר ממשי).

 אם העובד מעל גיל 18 ומתחת לגיל 67, מורידים מהשכר 100 ₪ מס בריאות. אחרת, מוסיפים מענק של 200 ₪.
 יש להדפיס את השכר המעודכן בסוף התכנית.
 *
 * @author amit
 * @version 26.2.22
 */
import java.util.Scanner;
public class SalaryCalc
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your salary: ");
        double salary = scan.nextDouble();
        System.out.println("Enter your age: ");
        int age = scan.nextInt();

        if ((age > 18) && (age < 67))
            System.out.println(salary - 100);
        else
            System.out.println(salary + 200);
    }
}
