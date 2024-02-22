/**************************************************************/
/* Michael Ly                                                 */
/* Login ID: stud9999                                         */
/* CS 3310, Spring 2024                                       */
/* Programming Assignment 1                                   */
/* Prog1 class: driver program                                */
/**************************************************************/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Prog1 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Invalid input format. Format: java Prog1 sample.txt");
        }
        File inputFile = new File(args[0]);
        try {
            Scanner sc = new Scanner(inputFile);
            while (sc.hasNext()) {
                System.out.println(sc.next());
            }
        }
        catch(Exception FileNotFoundException) {
            System.err.println("File not found");
        }

    }
}