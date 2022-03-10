/**
 * calculating of course cost by four parameters:
 * seniority
 * 1 - less than 18 points
 * 2 - more than 18 points
 * status
 * 1 - warrior
 * 2 - solider
 * 3 - not solider
 * instruction
 * 1 - regular
 * 2 - increased
 * semester
 * 1 - regular
 * 2 - summer
 *
 * @author amit
 * @version 26.2.22
 */


import java.util.Scanner;

public class CalcCourseCost {

    public static void main(String[] args) {
        final int YOUNG_STUDENT_COST = 2079; // in NIS
        final int SENIOR_STUDENT_COST = 1539; // in NIS
        final int WARRIOR_DISCOUNT = 50; // in presents
        final int SOLIDER_DISCOUNT = 10; // in presents
        final int INCREASED_INSTRUCTION = 301; // in NIS
        final int SUMMER_SEMESTER = 286; // in NIS
        final int SECURITY_COST = 59; // in NIS
        final int INCREASED_INSTRUCTION_CODE = 2;
        final int SUMMER_SEMESTER_CODE = 2;

        Scanner s = new Scanner(System.in);
        System.out.println("Enter four numbers: ");
        double courseCost;
        int seniority = s.nextInt();
        int status = s.nextInt();
        int instruction = s.nextInt();
        int semester = s.nextInt();
        if (seniority == 1) // check if the student has more than 18 points
            courseCost = YOUNG_STUDENT_COST;
        else
            courseCost = SENIOR_STUDENT_COST;
        if (status == 1)
            courseCost = courseCost * ((double) WARRIOR_DISCOUNT / 100);
        else if (status == 2)
            courseCost = courseCost * ((double) SOLIDER_DISCOUNT / 100);
        if (instruction == INCREASED_INSTRUCTION_CODE) // check if it is increased instruction
            courseCost += INCREASED_INSTRUCTION;
        if (semester == SUMMER_SEMESTER_CODE) // check if it is summer semester
            courseCost += SUMMER_SEMESTER;
        courseCost += SECURITY_COST; // add the security cost
        System.out.println("The course cost is: " + courseCost + " NIS.");
    }
}

