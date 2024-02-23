/**************************************************************/
/* Michael Ly                                                 */
/* Login ID: stud9999                                         */
/* CS 3310, Spring 2024                                       */
/* Programming Assignment 1                                   */
/* Prog1 class: driver program                                */
/**************************************************************/

import java.io.File;
import java.util.Scanner;

public class Prog1 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Invalid input. input: java Prog1 sample.txt");
        }
        File inputFile = new File(args[0]);
        try {
            Scanner sc = new Scanner(inputFile);
            int numVertices;
            Graph graph;
            while (sc.hasNextLine()) {
                numVertices = Integer.parseInt(sc.next());     //change later so that you only create one int and graph object
                graph = new Graph(numVertices);
                while (sc.hasNext()) {
                    // get rid of parantheses, delimit by comma to get ints
                    sc.next().replace("(", "");
                    sc.next().replace(")", "");
                    String[] tokens = sc.next().split(",");
                    graph.addEdge(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
                }
                System.out.println(graph.connectedComponents());
            }

            sc.close();

        }
        catch(Exception FileNotFoundException) {
            System.err.println("File not found");
        }

    }
}