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

            int numVertices;            // TODO: comments all vars with purpose
            Graph graph;
            String edge;
            String[] tokens;
            int graphCounter = 0; 

            while (fileScanner.hasNextLine()) {     // TODO: inline comments about task performed
                
                graphCounter++;
                String line = fileScanner.nextLine();
                Scanner lineScanner = new Scanner(line);

                numVertices = Integer.parseInt(lineScanner.next());     
                graph = new Graph(numVertices); 

                while (lineScanner.hasNext()) {
                    edge = lineScanner.next();
                    edge = edge.replace("(", "");
                    edge = edge.replace(")", "");
                    tokens = edge.split(",");
                    graph.addEdge(Integer.parseInt(tokens[0]) - 1, Integer.parseInt(tokens[1]) - 1); 
                }
                ArrayList<ArrayList<Integer>> connectedComponents = new ArrayList<>();
                connectedComponents = graph.connectedComponents();
                int numCC = connectedComponents.size();
                System.out.println("Graph" + graphCounter + ":");
                System.out.println(numCC + " Connected Components: " + connectedComponents + "\n");

                lineScanner.close();
            }
            fileScanner.close();
        }
        catch(FileNotFoundException fnf) {
            System.err.println("File Not Found");
        }

    }
}