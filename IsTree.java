/* Online Java Compiler and Editor */
import java.util.*;
public class Graph{
    
    private int V; // No. of vertices 
    private static LinkedList<Integer> adj[]; //Adjacency List 
 
    // Constructor 
   
    @SuppressWarnings("unchecked")
    Graph(int v) 
    { 
        V = v; 
        adj = new LinkedList[V]; 
        for (int i=0; i<v; ++i) 
            adj[i] = new LinkedList<Integer>(); 
    } 
 
    // Function to add an edge into the graph 
    void addEdge(int v,int w) 
    { 
        adj[v].add(w); 
        adj[w].add(v); 
    } 
    
    static boolean iscycle(int v, boolean[] visited, int parent) {
        visited[v] = true;
        Integer i;
        
        Iterator<Integer> it = adj[v].iterator(); 
        while (it.hasNext()) 
        { 
            i = it.next(); 
            
            if(!visited[i]) {
                if(iscycle(i, visited, v)) {
                    return true;
                }
            } else if (i != parent) {
                return true;
            }
        }
        
        return false;
    }
    

     public static void main(String []args){
         
        Graph g1 = new Graph(5); 
        g1.addEdge(1, 0); 
        g1.addEdge(0, 2); 
        g1.addEdge(0, 3); 
        g1.addEdge(3, 4); 
        
        boolean[] visited = new boolean[g1.V];
        System.out.println(iscycle(0, visited, -1));
        
        Graph g2 = new Graph(5); 
        g2.addEdge(1, 0); 
        g2.addEdge(0, 2); 
        g2.addEdge(2, 1); 
        g2.addEdge(0, 3); 
        g2.addEdge(3, 4); 
        
        visited = new boolean[g2.V];
        System.out.println(iscycle(0, visited, -1));
     }
}
