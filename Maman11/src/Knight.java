/**
 * The program take input row and column from the user, the row and the column is the position of the knight on chess
 * board (size: 8 * 8).
 * Knight can move 2 rows and 1 column or 2 columns and 1 row in one turn, so the program checks all those optional
 * positions and prints all the possible moves that the knight can do from the input location.
 *
 * @author Amit Nahmias
 * @version 1.3.2022
 */

import java.util.Scanner;

public class Knight {
    // The class represents chessman knight and prints all his optional moves from his position,
    // knight's position is input from user.
    public static void main(String[] args) {
        // The function gets knight's position from the user as input
        // and prints all the optional moves that the knight can do
        final int MIN_ROW = 1, MAX_ROW = 8; // the limits of input value for rows
        final int MIN_COLUMN = 1, MAX_COLUMN = 8; // the limits of input value for columns
        Scanner scan = new Scanner(System.in);
        System.out.println("This program reads two integers which represent the knight's location on the chess board: ");
        System.out.println("Please enter the number of row");
        int row = scan.nextInt();
        System.out.println("Please enter the number of column");
        int col = scan.nextInt();
        if ((row < MIN_ROW || row > MAX_ROW) || (col < MIN_COLUMN || col > MAX_COLUMN)) // check if the input is illegal
            System.out.println("input is illegal");
        else {
            System.out.println("Moves:");
            if ((col - 1 >= MIN_COLUMN) && (row - 2 >= MIN_ROW))
                System.out.println((col - 1) + " " + (row - 2)); // one step left and two steps backward
            if ((col + 1 <= MAX_COLUMN) && (row - 2 >= MIN_ROW))
                System.out.println((col + 1) + " " + (row - 2)); // one step right and two steps backward
            if ((col - 1 >= MIN_COLUMN) && (row + 2 <= MAX_ROW))
                System.out.println((col - 1) + " " + (row + 2)); // one step left and two steps forward
            if ((col + 1 <= MAX_COLUMN) && (row + 2 <= MAX_ROW))
                System.out.println((col + 1) + " " + (row + 2)); // one step right and two steps forward
            if ((col - 2 >= MIN_COLUMN) && (row - 1 >= MIN_ROW))
                System.out.println((col - 2) + " " + (row - 1)); // two steps left and one step backward
            if ((col + 2 <= MAX_COLUMN) && (row - 1 >= MIN_ROW))
                System.out.println((col + 2) + " " + (row - 1)); // two steps right and one step backward
            if ((col - 2 >= MIN_COLUMN) && (row + 1 <= MAX_ROW))
                System.out.println((col - 2) + " " + (row + 1)); // two steps left and one step forward
            if ((col + 2 <= MAX_COLUMN) && (row + 1 <= MAX_ROW))
                System.out.println((col + 2) + " " + (row + 1)); // two steps right and one step forward
        }
    } // end of method main
} //end of class Knight

