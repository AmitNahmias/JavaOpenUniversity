/**
 כתבו ב-BlueJ תכנית הקולטת מספר שלם למשתנה num.

 - אם המספר קטן מ-10, יודפס "small". 
-  אחרת, אם המספר קטן מ-100, יודפס "middle".

-  אחרת, אם המספר קטן מ-1000, יודפס "big".

-  אחרת, יודפס "very big".
 *
 * @author amit
 * @version 26.2.22
 */
import java.util.Scanner;
public class SecondQuestion
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number: ");
        int num = scan.nextInt();
        if (num < 10)
            System.out.println("small");
        else if (num < 100)
            System.out.println("middle");
        else if (num < 1000)
            System.out.println("big");
        else
            System.out.println("huge");
        
    }
}
