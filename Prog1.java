/**************************************************************/
/* Michael Ly                                                 */
/* Login ID: 016185078                                        */
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

            int numVertices;            // used to track number of vertices for each graph            
            Graph graph;                // used as the variable for graph objects
            String edge;                // used as variable for edges 
            String[] tokens;            // used as variable for tokens after splitting edges
            int graphCounter = 0;       // counts graphs number, used for displaying
            ArrayList<ArrayList<Integer>> connectedComponents;      // variable used for print connected components
            int numCC;                  // variable used for print number of connected components

            while (fileScanner.hasNextLine()) {
                
                graphCounter++;
                String line = fileScanner.nextLine();
                Scanner lineScanner = new Scanner(line);

                numVertices = Integer.parseInt(lineScanner.next());     
                graph = new Graph(numVertices);     // create new graph with numVertices vertices

                while (lineScanner.hasNext()) {     // processed edges from input file
                    edge = lineScanner.next();                     
                    edge = edge.replace("(", "");       
                    edge = edge.replace(")", "");
                    tokens = edge.split(",");                        
                    graph.addEdge(Integer.parseInt(tokens[0]) - 1, Integer.parseInt(tokens[1]) - 1); // add edges to graph
                }
                connectedComponents = new ArrayList<>();
                connectedComponents = graph.connectedComponents();          // gets list of connected components
                numCC = connectedComponents.size();                         // gets number of connected components
                System.out.println("Graph" + graphCounter + ":");           // display to stdout
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