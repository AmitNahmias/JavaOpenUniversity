
/**
 * Calculate the perimeter and the area of Rectangle.
 *
 * @author amit
 * @version 26.2.22
 */
import java.util.Scanner;
public class Rectangle
{
   public static void main(String[] args)
   {
       Scanner scan = new Scanner(System.in);
       System.out.println("Enter height:");
       int height = scan.nextInt();
       System.out.println("Enter width:");
       int width = scan.nextInt();
       int area = width * height;  
       int perimeter = 2 * width + 2 * height;
       System.out.println("The area is: " + area + " and the perimeter is: " + perimeter);
   }
}
