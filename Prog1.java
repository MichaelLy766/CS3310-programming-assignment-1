/**************************************************************/
/* Michael Ly                                                 */
/* Login ID: stud9999                                         */
/* CS 3310, Spring 2024                                       */
/* Programming Assignment 1                                   */
/* Prog1 class: driver program                                */
/**************************************************************/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Prog1 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Invalid input. input: java Prog1 sample.txt");
        }
        File inputFile = new File(args[0]);
        try {
            Scanner fileScanner = new Scanner(inputFile);
            int numVertices;
            Graph graph;
            String edge;
            String[] tokens;
            int graphCounter = 0; 
            while (fileScanner.hasNextLine()) {
                graphCounter++;
                String line = fileScanner.nextLine();
                Scanner lineScanner = new Scanner(line);

                numVertices = Integer.parseInt(lineScanner.next());     
                graph = new Graph(numVertices); 

                while (lineScanner.hasNext()) {
                    // get rid of parantheses, delimit by comma to get ints
                    edge = lineScanner.next();
                    //System.out.println("edge before replacement function:" + edge);
                    edge = edge.replace("(", "");         // replace doesnt work 
                    edge = edge.replace(")", "");
                    //System.out.println("edge after replacement function:" + edge);
                    tokens = edge.split(",");
                    //System.out.println(tokens[0]);
                    //System.out.println(tokens[1]);      // tokens[1] is out of bounds for some reason 
                    graph.addEdge(Integer.parseInt(tokens[0]) - 1, Integer.parseInt(tokens[1]) - 1); // now error is here 
                }
                ArrayList<ArrayList<Integer>> cc = new ArrayList<>();
                cc = graph.connectedComponents();
                int numCC = cc.size();
                System.out.println("Graph" + graphCounter + ":");
                System.out.println(numCC + " Connected Components: " + cc + "\n");

                lineScanner.close();

                
            }
            
            fileScanner.close();

        }
        catch(FileNotFoundException fnf) {
            System.err.println("File Not Found");;
        }

    }
}