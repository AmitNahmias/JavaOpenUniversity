
/**
 * Prints if the shape is a square.
 *
 * @author amit
 * @version 26.2.22
 */
import java.util.Scanner;
public class Square
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter 4 lenghts: ");
        double first = scan.nextDouble();
        double second = scan.nextDouble();
        double third = scan.nextDouble();
        double fourth = scan.nextDouble();
        if ((first==second) && (second==third) && (third==fourth))
            System.out.println("Square");
        else
            System.out.println("Not square");
    }
}
