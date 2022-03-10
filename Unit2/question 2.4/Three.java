
/**
 * Gets three digit number and prints his digits.
 *
 * @author amit
 * @version 26.2.22
 */
import java.util.Scanner;
public class Three
{
   public static void main(String[] args)
   {
       Scanner scan = new Scanner(System.in);
       System.out.println("Enter number:");
       int number= scan.nextInt();
       System.out.println(number % 10);
       System.out.println(number % 100 / 10);
       System.out.println(number / 100);
   }
}
