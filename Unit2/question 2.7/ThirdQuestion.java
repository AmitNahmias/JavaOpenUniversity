/**
  כתבו ב-BlueJ תכנית הקולטת מספר שלם למשתנה num.

 - אם num חיובי, בדקו אם הוא זוגי. 
    - אם כן, הדפיסו שהוא זוגי.
    - אחרת, הדפיסו שהוא אי זוגי.

- אם num לא חיובי, הדפיסו "wrong number".
 *
 * @author amit
 * @version 26.2.22
 */
import java.util.Scanner;
public class ThirdQuestion
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number: ");
        int num = scan.nextInt();
        if (num > 0)
            {
                if (num % 2 == 0)
                System.out.println("Zogi");
                else
                    System.out.println("Not zogi");
            }
        else
            System.out.println("wrong number");
        
    }
}
