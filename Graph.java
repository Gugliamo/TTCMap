
package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author Alexander Guglenko
 */
class Graph<T> {

    public HashMap<T, Set<T>> adjacencyList;
    public HashMap<T, Integer> xCoordinates = new HashMap<>();
    public HashMap<T, Integer> yCoordinates = new HashMap<>();
        
        //create new Graph object
        public Graph(){
            this.adjacencyList = new HashMap<>();
        }
        
        //add new vertext to graph
        public void addVertex(T u){
            if(this.adjacencyList.containsKey(u)){
                throw new IllegalArgumentException("Vertex already exists.");
            }
            this.adjacencyList.put(u, new HashSet<T>());
        }
        
        //add new vertext to graph with coordinates for later use
        public void addVertex(T u,Integer xCoordinate, Integer yCoordinate){
            if(this.adjacencyList.containsKey(u)){
                throw new IllegalArgumentException("Vertex already exists.");
            }
            this.adjacencyList.put(u, new HashSet<T>());
            this.xCoordinates.put(u, xCoordinate);
            this.yCoordinates.put(u, yCoordinate);
        }
        
        //get x coordinate
        public Integer getX(T u){
            return this.xCoordinates.get(u);
        }
        
        //get y coordinate
        public Integer getY(T u){
            return this.yCoordinates.get(u);
        }
        
        /*  add a new edge between existing vertices
            adding a new edge from u to v will automatically
            add a new edge from v to u as this graph is undirected  */
        public void addEdge(T u, T v){
            if(!this.adjacencyList.containsKey(u) || !this.adjacencyList.containsKey(v)){
                throw new IllegalArgumentException("One of the vertexes doesn't exist");
            }
            this.adjacencyList.get(u).add(v);
            this.adjacencyList.get(v).add(u);
        }
        
        /*  check for adjacency between two vertices
            where u is the start and v is the destination
        */
        public boolean isAdjacent(String u, String v){
            return this.adjacencyList.get(u).contains(v);
        }
        
        /*
            get connected vertices of a vertex
            return is an iterable for connected vertices
        */
        public Iterable<T> getNeighbors(T u){
            return this.adjacencyList.get(u);
        }
        
        
        /*
            Get all vertices in the graph
            return is an iterable for all vertices in the graph
        */
        public Iterable<T> getAllVertices(){
            return this.adjacencyList.keySet();
        }
        
        
        //breadth-first search from start station to end station
        Set<String> BFS(Graph graph, String start, String end){
            //save visited vertices in a LinkedHashSet
            Set<String> visited = new LinkedHashSet<String>();
            //create a queue, as this is a BFS
            Queue<String> queue = new LinkedList<String>();
            queue.add(start);//first vertex in queue is given start position
            visited.add(start);//add first vertex to visited set
            while(!queue.isEmpty()){
                String vertex = queue.poll();//grab the element from front of queue
                for(T x: this.adjacencyList.get(vertex)){//find adjacent vertices of current vertex
                    if(!visited.contains(x)){//adjacent vertex hasn't been visited
                        visited.add(x.toString());//add to visited set
                        //if vertex matches end element  
                        if(visited.contains(x) && x.toString().equals(end)){ 
                            //return visited list after it's parsed through conCheck method
                            return conCheck(visited);
                        }                
                        //add adjacent vertex to queue
                        queue.add(x.toString());
                    }
                }
            }
            return conCheck(visited);
        }
        
        //method to check if visited list elements have adjacenecy 
        //mostly to trim elements at intersections created by BFS traversal
        Set<String> conCheck(Set<String> visited){
            //convert visited set to arraylist
            List<String> list = new ArrayList<String> (visited);
            
            //loop through arraylist from end to start
            for( int i = list.size()-1 ; i>0; i--){
                //if next element isn't adjacent to last element, remove it
                if(!isAdjacent(list.get(i),list.get(i-1))){
                    list.remove(i-1);
                    i = list.size();//modify i because size has changed 
                }
            }
            //convert arraylist back to a set and return
            Set<String> returnList = new LinkedHashSet<String>(list);            
            return returnList;
        }
        
        /*
            print out the adjacency list of each vertex
        */
        @Override
        public String toString(){
            StringBuilder builder = new StringBuilder();
            
            for(T u : adjacencyList.keySet()){
                builder.append(u.toString() + ": ");
                for(T v: adjacencyList.get(u)){
                    builder.append(v.toString() + " ");
                }
                builder.append("\n");
            }
            return (builder.toString());
        }
        
        //my dataset
        static Graph builder(){
            Graph<String> graph = new Graph<>();
            
            graph.addVertex("Ossington", 1, 5);
            graph.addVertex("Christie", 2, 5);
            graph.addVertex("Bathurst", 3, 5);            
            graph.addVertex("Spadina", 4, 5);
            graph.addVertex("St George", 5, 5);
            graph.addVertex("Bay", 6, 5);
            graph.addVertex("Bloor–Yonge", 7, 5);
            graph.addVertex("Sherbourne", 8, 5);
            graph.addVertex("Castle Frank", 9, 5);

            
            graph.addVertex("Dupont", 4, 4);
            graph.addVertex("St Clair West", 3, 3);         
            
            
            graph.addVertex("Museum", 5, 6);
            graph.addVertex("Queen's Park", 5, 7);
            graph.addVertex("St Patrick", 5, 8);
            graph.addVertex("Osgoode", 5, 9);
            graph.addVertex("St Andrew", 5, 10);
            graph.addVertex("Union", 6, 11);
            graph.addVertex("King", 7, 10);
            graph.addVertex("Queen", 7, 9);
            graph.addVertex("Dundas", 7, 8);
            graph.addVertex("College", 7, 7);
            graph.addVertex("Wellesley", 7, 6);
            graph.addVertex("Rosedale", 7, 4);
            graph.addVertex("Summerhill", 7, 3);


            graph.addEdge("Ossington", "Christie");
            graph.addEdge("Christie", "Bathurst");
            graph.addEdge("Bathurst", "Spadina");
            graph.addEdge("Spadina", "St George");
            graph.addEdge("St George", "Bay");
            graph.addEdge("Bay", "Bloor–Yonge");
            graph.addEdge("Bloor–Yonge", "Sherbourne");
            graph.addEdge("Sherbourne", "Castle Frank");

            graph.addEdge("St Clair West", "Dupont");
            graph.addEdge("Dupont", "Spadina");
            graph.addEdge("Spadina", "St George");
            graph.addEdge("St George", "Museum");
            graph.addEdge("Museum", "Queen's Park");
            graph.addEdge("Queen's Park", "St Patrick");
            graph.addEdge("St Patrick", "Osgoode");
            graph.addEdge("Osgoode", "St Andrew");
            graph.addEdge("St Andrew", "Union");
            graph.addEdge("Union", "King");
            graph.addEdge("King", "Queen");
            graph.addEdge("Queen", "Dundas");
            graph.addEdge("Dundas", "College");
            graph.addEdge("College", "Wellesley");
            graph.addEdge("Wellesley", "Bloor–Yonge");
            graph.addEdge("Bloor–Yonge", "Rosedale");
            graph.addEdge("Rosedale", "Summerhill");            
            
            return graph;
        }
        
        
    public static void main(String[] args) {
        
        //mostly just testing stuff out
        
        Graph<String> ttcGraph = builder();     

        System.out.println(ttcGraph.toString());
        System.out.println(ttcGraph.getAllVertices().toString());
        System.out.println(ttcGraph.getNeighbors("Royal York"));
        
        /*
        LinkedList<String> traverse = ttcGraph.DFS(ttcGraph, "Ossington");
        System.out.println(traverse);
        traverse = ttcGraph.DFS(ttcGraph, "Kipling");
        System.out.println(traverse);
        */
        
        Set<String> traverse = ttcGraph.BFS(ttcGraph, "Ossington", "Bay");
        System.out.println(traverse);
        
        System.out.println(ttcGraph.getX("Bathurst"));

        System.out.println(ttcGraph.adjacencyList.size());      
  
    }    
}
