import java.util.ArrayList;

public class Graph {
    int numVertices;
    ArrayList<ArrayList<Integer> > adjacencyList;

    public Graph (int numVertices) {
        this.numVertices = numVertices;
        adjacencyList = new ArrayList<>();
        for (int i = 1; i <= numVertices; i++) {
            adjacencyList.add(i, new ArrayList<>());
        }
    }

    public void addEdge (int source, int destination) {
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source);
    }

    private ArrayList<Integer> DFS(ArrayList<Integer> component, int vertex, boolean[] visited) {
        visited[vertex] = true;
        
        component.add(vertex);

        for (int v : adjacencyList.get(vertex)) {
            if (!visited[v]) {
                DFS(component, v, visited);
            }
        }
        return component; 
    }

    public ArrayList<ArrayList<Integer>> connectedComponents() {
        boolean[] visited = new boolean[numVertices + 1];
        ArrayList<ArrayList<Integer>> cc = new ArrayList<>();
        for (int vertex = 1; vertex <= numVertices; vertex++) {
            if (!visited[vertex]) {
                ArrayList<Integer> component = new ArrayList<>();
                cc.add(DFS(component, vertex, visited));
            }
        }
        return cc;
    }
}