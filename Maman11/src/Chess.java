/**
 * The program takes six input variables in this order: first chessman type, first chessman row, first chessman column,
 * second chessman type, second chessman row, second chessman column.
 * Chessmen types are: Knight ('k'), Rook ('r') and Bishop ('b').
 * If the chessmen is identical the program prints suitable message.
 * If chessman is in illegal position the program prints suitable message.
 * If the chessmen is in the same position the program prints suitable message.
 * Otherwise, the program will print if there is a threat between those two chessmen.
 * If there is no threat the program prints suitable message.
 *
 * @author Amit Nahmias
 * @version 1.3.2022
 */

import java.util.Scanner;

public class Chess
{ // #TODO: add docs
    public static void main(String[] args)
    { // #TODO: add docs
        final int MIN_ROW = 1, MAX_ROW = 8; // the limits of input value for rows
        final int MIN_COLUMN = 1, MAX_COLUMN = 8; // the limits of input value for columns
        final char KNIGHT = 'k', ROOK = 'r', BISHOP = 'b'; // inputs for each chessman
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the type of the first chessman");
        char first = scan.next().charAt(0);
        System.out.println("Please enter the number of row");
        int row1 = scan.nextInt();
        System.out.println("Please enter the number of column");
        int col1 = scan.nextInt();
        System.out.println("Please enter the type of the second chessman");
        char second = scan.next().charAt(0);
        System.out.println("Please enter the number of row");
        int row2 = scan.nextInt();
        System.out.println("Please enter the number of column");
        int col2 = scan.nextInt();
        if (first != second)
        { // check if the chessmen are not identical
            if ((row1 >= MIN_ROW && row1 <= MAX_ROW && col1 >= MIN_COLUMN && col1 <= MAX_COLUMN) &&
                    (row2 >= MIN_ROW && row2 <= MAX_ROW && col2 >= MIN_COLUMN && col2 <= MAX_COLUMN))
            { // check if the positions is legal
                if (row1 != row2 || col1 != col2)  // check chessmen in different positions
                {
                    if ((first == KNIGHT || second == KNIGHT) && ((Math.abs(col1 - col2) == 2 &&
                            Math.abs(row1 - row2) == 1) || (Math.abs(col1 - col2) == 1 && Math.abs(row1 - row2) == 2)))
                    { // check if there is a knight and if he is threatening on the other chessman
                        if (first == ROOK || second == ROOK)
                            System.out.println("knight threat rook");
                        else
                            System.out.println("knight threat bishop");
                    }
                    else if ((first == ROOK || second == ROOK) && ((col1 == col2) || (row1 == row2)))
                    { // check if there is a rook and if he is threatening on the other chessman
                        if (first == KNIGHT || second == KNIGHT)
                            System.out.println("rook threat knight");
                        else
                            System.out.println("rook threat bishop");
                    }
                    else if ((first == BISHOP || second == BISHOP) && (Math.abs(row1 - row2) == Math.abs(col1 - col2)))
                    { // check if there is a bishop and if he is threatening on the other chessman
                        if (first == ROOK || second == ROOK)
                            System.out.println("bishop threat rook");
                        else
                            System.out.println("bishop threat knight");
                    } else
                        System.out.println("no threat");
                } else
                    System.out.println("Chessmen positions should not be identical");
            } else
                System.out.println("Position is not legal");
        } else
            System.out.println("Chessmen should be different from each other");
    } // end of method main
} //end of class Chess