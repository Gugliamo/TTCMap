# TTCMap
Find the shortest path between two TTC subway stations.


For my graph project, I used an adjacency list to keep track of my vertices and their edges.  My graph is unweighted and undirected. For my data set, I used a hard-coded list of vertices and edges representing subway stations on the TTC, specifically the core section of the subway line. The downtown core has multiple intersecting lines, which I thought might give me some experience with a graph that has vertices with up to 4 adjacencies. 

| ![image](https://user-images.githubusercontent.com/69227675/194148322-15463b0a-5227-4ae0-9268-c85a0fde9e81.png) |
|:--:|
| *Figure 1 My data set used most of the stations and their connections as shown above.*|
  
  
I tried to design my class to use generics for practice, especially because I was dealing with string representations of my vertices instead of integers and thought this might be a good opportunity for practice. My program includes methods to add a vertex with or without x-y coordinates (for later graphical representation), get methods for the x and y coordinates, a method to add an edge, a method to retrieve all neighbors of a given vertex, a method to check whether two vertices are adjacent, and a method to get all vertices within the graph. 

My end goal was to represent my data set graphically, in the same manner as a TTC map. I then wanted to implement a Breadth-First Search algorithm where a user can input a start and end station and my GUI shows the shortest route between the two stations graphically with a highlighted path. My BFS method is pretty standard: it uses a LinkedHashSet to keep track of visited vertices and a queue in the form of a LinkedList to coordinate BFS traversal. The initial starting station is entered into the queue and added to the visited list, then a loop retrieves an element from the front of the queue and starts retrieving all adjacencies to that vertex. If the adjacent vertex isn’t part of the visited set, it will be added to the visited set and added to the queue. This loop continues until an adjacency is discovered that matches the ending station argument, at which point the visited set is parsed through my conCheck method and returned.

My conCheck method is specifically created because my BFS method will add adjacencies to the visited list that are not specifically part of the path from the start to end stations when my BFS encounters a split in the path. The conCheck method will compare the visited list elements from end to start. If the next element is not adjacent to the previous element, it will remove it from the visited set, it will do this until it hits the first element in the set and will return the revised set. 

My GUI mostly generates my graph automatically, using the x and y coordinates I initially included when creating my vertices. The biggest thing I did manually was add the names of the stations and their locations on the GUI.


## Screenshots
| ![image](https://user-images.githubusercontent.com/69227675/194149240-9c7894f7-46d2-45a9-a67c-eb93dbef6e03.png) |
|:--:|
| *Figure 2 Generated graph with no path.* |

| ![image](https://user-images.githubusercontent.com/69227675/194149291-28fc7405-c2bc-4c92-a769-c8fef8f17951.png) |
|:--:|
| *Figure 3 Graph with highlighted path.* |
