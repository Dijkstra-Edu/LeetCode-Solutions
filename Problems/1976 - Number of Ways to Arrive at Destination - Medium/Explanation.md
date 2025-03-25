# Explanation of the Program

### **Objective**
The goal of the program is to count the number of distinct shortest paths from node `0` to node `n-1` in a weighted, undirected graph. The result is returned modulo \( 10^9 + 7 \).

---

### **Key Components**
1. **Class `Pair`:**  
   - Represents a pair of values (distance and node index).
   - Used for storing the distance of a node from the source and the index of the node.

2. **Adjacency List (`adj`):**  
   - The graph is represented as an adjacency list where each node's neighbors and edge weights are stored.
   - The adjacency list is built using input data from the `roads` array.

3. **Priority Queue (`pq`):**  
   - Implements a min-heap to efficiently get the node with the smallest distance.
   - Helps in applying Dijkstra's algorithm.

4. **Arrays `dist` and `ways`:**  
   - `dist[i]`: Stores the shortest distance from the source node (node `0`) to node `i`.
   - `ways[i]`: Stores the number of distinct ways to reach node `i` with the shortest distance.

---

### **Step-by-Step Process**
1. **Input Parsing and Graph Construction:**
   - The graph is built using the `roads` array, where each road connects two nodes (`u` and `v`) with a specific weight (`w`).
   - Two directed edges are created for each road since the graph is undirected.

2. **Initialization:**
   - Initialize the `dist` array with `Long.MAX_VALUE` to signify unreachable nodes.
   - Initialize the `ways` array to `0` (initially no paths to any node).
   - Set `dist[0] = 0` (distance from node `0` to itself is `0`).
   - Set `ways[0] = 1` (only one way to stay at the source).

3. **Dijkstra's Algorithm:**
   - Use the priority queue to process the node with the smallest distance.
   - For each neighbor of the current node:
     - If a shorter path is found, update the distance and reset the number of ways.
     - If a path with the same shortest distance is found, add the number of ways to reach the current node to the neighbor's path count.

4. **Return Result:**
   - The number of ways to reach the destination node (`n-1`) is returned modulo \( 10^9 + 7 \).

---

### **Code Explanation**
#### 1. **Graph Representation**
```java
ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
for(int i = 0; i < n; i++) {
    adj.add(new ArrayList<>());
}
for(int i = 0; i < m; i++) {
    adj.get(roads[i][0]).add(new Pair(roads[i][2], roads[i][1]));
    adj.get(roads[i][1]).add(new Pair(roads[i][2], roads[i][0]));
}

Time Complexity: O((n+m)log(n)) 
The program processes all m roads to build the adjacency list.
This operation takes O(m) time.
Dijkstra’s Algorithm:
Each node and its neighbors are processed through the priority queue.
Popping a node from the priority queue takes O(log n) time.
Over all m edges, the operations amount to O((n + m) log n) time.
Overall Time Complexity:
The dominant factor is Dijkstra’s algorithm, so the time complexity is O((n + m) log n).

Space Complexity: O(n)
The adjacency list stores all m edges, requiring O(m) space.
The dist and ways arrays require O(n) space each.
The priority queue stores up to O(n) nodes.
Overall Space Complexity:
The total space complexity is O(n + m)