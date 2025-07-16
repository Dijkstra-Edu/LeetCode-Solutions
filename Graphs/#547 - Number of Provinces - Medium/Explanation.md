# 547. Number of Provinces

**Difficulty:** Medium  
**Category:** Graphs, DFS, Union Find  
**Leetcode Link:** [Problem Link](https://leetcode.com/problems/number-of-provinces/)

---

## 📝 Introduction

You are given an undirected graph represented as an adjacency matrix, where isConnected[i][j] = 1 indicates a direct connection between the ith and jth cities.  
A province is a group of directly or indirectly connected cities that are disconnected from other cities.  
The task is to count the number of such provinces in the graph.

Constraints:<br>
- 1 ≤ n ≤ 200  
- isConnected[i][j] is 1 or 0  
- isConnected[i][i] is always 1  

---

## 💡 Approach & Key Insights

The problem reduces to finding the number of connected components in an undirected graph.  
Each connected component represents one province.  
We can apply graph traversal techniques (DFS or BFS) to visit each connected component and count how many separate traversals we had to make.

---

## 🛠️ Breakdown of Approaches

### 1️⃣ Brute Force / Naive Approach

- **Explanation:**  
  Treat each city as a node. For each city, initiate a DFS/BFS to mark all reachable cities.  
  Use a visited array to avoid revisiting nodes. Every time we start a new DFS from an unvisited node, it indicates a new province.

- **Time Complexity:** O(N²) — because we scan the full adjacency matrix  
- **Space Complexity:** O(N) — for the visited array  
- **Example/Dry Run:**

```plaintext
Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
Step 1: Start DFS at node 0 → mark 0,1 as visited
Step 2: Skip node 1 (already visited)
Step 3: Node 2 is unvisited → new DFS → mark 2
Provinces = 2
```

---

### 2️⃣ Optimized Approach (DFS using adjacency list)

- **Explanation:**  
  Convert the adjacency matrix to an adjacency list to reduce redundant checks.  
  Perform DFS from each unvisited node, marking all nodes reachable from it.

- **Time Complexity:** O(V + E)  
- **Space Complexity:** O(V + E) for adjacency list + O(V) for visited array  
- **Example/Dry Run:**

```plaintext
Input: [[1,0,0],[0,1,0],[0,0,1]]
Adjacency List: [[], [], []] (self-loops ignored)
Start DFS at node 0 → visit 0 → count++
Start DFS at node 1 → visit 1 → count++
Start DFS at node 2 → visit 2 → count++
Output = 3 provinces
```

---

### 3️⃣ Best / Final Optimized Approach (Union-Find)

- **Explanation:**  
  Use Union-Find (Disjoint Set Union) to group connected cities.  
  Initially, each city is its own parent. For every connection, perform a union operation.  
  Finally, count how many unique parents exist.

- **Time Complexity:** O(N² × α(N)) — where α is the inverse Ackermann function  
- **Space Complexity:** O(N) — for parent array  
- **Example/Dry Run:**

```plaintext
Input: [[1,1,0],[1,1,0],[0,0,1]]
Parent: [0,1,2]
Union(0,1) → Parent[1] = 0 → Parent: [0,0,2]
Count unique parents → [0,2] → Output: 2
```

---

## 📊 Complexity Analysis

| Approach      | Time Complexity    | Space Complexity |
| ------------- | ------------------ | ---------------- |
| Brute Force   | O(N²)              | O(N)             |
| DFS (Adj List)| O(V + E)           | O(V + E)         |
| Union-Find    | O(N² × α(N))       | O(N)             |

---

## 📉 Optimization Ideas

- In the Union-Find approach, use both path compression and union by rank to optimize further.
- Avoid converting to an adjacency list if the matrix is sparse.

---

## 📌 Example Walkthroughs & Dry Runs

```plaintext
Example:
Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
Each city is isolated
Result: 3 provinces

Example:
Input: [[1,1,0],[1,1,0],[0,0,1]]
City 0 and 1 are connected
City 2 is isolated
Result: 2 provinces
```

---

## 🔗 Additional Resources

- [DFS Traversal - GFG](https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/)
- [Union Find Explained](https://www.geeksforgeeks.org/dsa/introduction-to-disjoint-set-data-structure-or-union-find-algorithm/)

---

Author: Abdul Wahab  
Date: 19/07/2025
