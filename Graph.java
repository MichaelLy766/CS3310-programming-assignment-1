/**************************************************************/
/* Michael Ly                                                 */
/* Login ID: stud9999                                         */
/* CS 3310, Spring 2024                                       */
/* Programming Assignment 1                                   */
/* Graph class: defines graph and graph methods               */
/**************************************************************/

import java.util.ArrayList;

public class Graph {
    int numVertices;
    ArrayList<ArrayList<Integer> > adjacencyList;
    
    /**
     * Constructor: Graph
     * Purpose: Construct a new Graph object with number of vertices numVertices
     * @param numVertices           number of vertices
     */
    public Graph (int numVertices) {
        this.numVertices = numVertices;
        adjacencyList = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            adjacencyList.add(i, new ArrayList<>());
        }
    }

    /**
     * Method: addEdge
     * Purpose: add an undirected edge to the adjecancy list storing the grpah's 
     *          connections
     * @param source            starting vertex of the edge
     * @param destination       ending vertex of the edge
     */
    public void addEdge (int source, int destination) {
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source);
    }

    /**
     * Method: DFS
     * Purpose: tranverse the graph using depth-first search, adding visited
     *          and connected nodes to Arraylist component
     * Paremters: 
     * @param component         ArrayList of connected vertices
     * @param vertex            integer representing a vertex 
     * @param visited           boolean represent visited or not
     * @return
     */
    private ArrayList<Integer> DFS(ArrayList<Integer> component, int vertex, boolean[] visited) {
        visited[vertex] = true;
        
        component.add(vertex + 1);

        for (int v : adjacencyList.get(vertex)) {
            if (!visited[v]) {
                DFS(component, v, visited);
            }
        }
        return component; 
    }

    //TODO method header comments, 
    public ArrayList<ArrayList<Integer>> connectedComponents() {
        boolean[] visited = new boolean[numVertices + 1];       //TODO comments explaining vars
        ArrayList<ArrayList<Integer>> connectedComponents = new ArrayList<>();
        for (int vertex = 0; vertex < numVertices; vertex++) {          //TODO comments explaining taks
            if (!visited[vertex]) {
                ArrayList<Integer> component = new ArrayList<>();
                connectedComponents.add(DFS(component, vertex, visited));
            }
        }
        return connectedComponents;
    }
}