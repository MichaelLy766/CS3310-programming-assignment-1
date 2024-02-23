/**************************************************************/
/* Michael Ly                                                 */
/* Login ID: stud9999                                         */
/* CS 3310, Spring 2024                                       */
/* Programming Assignment 1                                   */
/* Prog1 class: driver program                                */
/**************************************************************/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Prog1 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Invalid input. input: java Prog1 sample.txt");
        }
        File inputFile = new File(args[0]);
        try {
            System.out.println(inputFile);
            Scanner sc = new Scanner(inputFile);
            int numVertices;
            Graph graph;
            while (sc.hasNextLine()) {
                numVertices = Integer.parseInt(sc.next());     
                graph = new Graph(numVertices); 
                while (sc.hasNext()) {
                    // get rid of parantheses, delimit by comma to get ints
                    sc.next().replace("(", "");
                    sc.next().replace(")", "");
                    String[] tokens = sc.next().split(",");
                    graph.addEdge(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1])); // now error is here 
                }
                System.out.println(graph.connectedComponents());
            }
            
            sc.close();

        }
        catch(FileNotFoundException fnf) {
            fnf.printStackTrace();
        }

    }
}