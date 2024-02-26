/**************************************************************/
/* Michael Ly                                                 */
/* Login ID: 016185078                                        */
/* CS 3310, Spring 2024                                       */
/* Programming Assignment 1                                   */
/* Graph class: defines graph and graph methods               */
/**************************************************************/

import java.util.ArrayList;

public class Graph {
    int numVertices;
    ArrayList<ArrayList<Integer>> adjacencyList;
    
    /**
     * Constructor: Graph
     * Purpose: Construct a new Graph object with number of vertices numVertices
     * Parameters:
     * @param numVertices          int: number of vertices
     */
    public Graph (int numVertices) {

        // sets number of vertices
        this.numVertices = numVertices;

        // creates new arraylist, add a new arraylist for each vertex in the graph
        adjacencyList = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            adjacencyList.add(i, new ArrayList<>());
        }
    }

    /**
     * Method: addEdge
     * Purpose: add an undirected edge to the adjecancy list storing the graph's 
     *          connections
     * Parameters:
     * @param source            int: starting vertex of the edge
     * @param destination       int: ending vertex of the edge
     */
    public void addEdge (int source, int destination) {

        // add connection both ways because of undirected graph
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source);
    }

    /**
     * Method: DFS
     * Purpose: tranverse the graph using depth-first search, adding visited
     *          and connected vertices to the Arraylist component
     * Parameters: 
     * @param component         ArrayList<Integer>: of connected vertices
     * @param vertex            int: representing a vertex 
     * @param visited           boolean[]: representing if each vertex visited or not
     * @return ArrayList<Integer>: a connected component of the graph
     */
    private ArrayList<Integer> DFS(ArrayList<Integer> component, int vertex, boolean[] visited) {
        visited[vertex] = true;
        
        // add visited vertex to the arraylist component, to be return once tranversal finishes,
        // using vertex + 1 because so vertices are display as indexed 1
        component.add(vertex + 1);

        // for every vertex that the current vertex is connected to
        // if it is unvisited, recursively visit with DFS
        for (int v : adjacencyList.get(vertex)) {
            if (!visited[v]) {
                DFS(component, v, visited);
            }
        }
        return component; 
    }

    /**
     * Method: connectedComponents
     * Purpose: to continue tranversing other components of the graph even if DFS finished tranversing
     *          a particular component, keeps tracking of the connected components of the graph and 
     *          returns it
     * @return ArrayList<ArrayList<Integer>>: 2D arraylist of all connected components
     */
    public ArrayList<ArrayList<Integer>> connectedComponents() {

        // boolean array representing visit status for each vertex
        boolean[] visited = new boolean[numVertices];       

        // 2D arraylist of all connected components
        ArrayList<ArrayList<Integer>> connectedComponents = new ArrayList<>();

        // for each vertex in graph, if it is unvisted, perform DFS 
        for (int vertex = 0; vertex < numVertices; vertex++) {
            if (!visited[vertex]) {
                ArrayList<Integer> component = new ArrayList<>();
                connectedComponents.add(DFS(component, vertex, visited));
            }
        }
        return connectedComponents;
    }
}