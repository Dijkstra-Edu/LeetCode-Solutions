# 146. LRU Cache
Difficulty: Medium  
Category: HashMap, Doubly Linked List, Design  
Leetcode Link: [Problem Link](https://leetcode.com/problems/lru-cache/)

---

## 📝 Introduction

Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:
- LRUCache(int capacity) initializes the LRU cache with a positive size capacity.
- int get(int key) returns the value of the key if the key exists, otherwise returns -1.
- void put(int key, int value) updates the value of the key if it exists. Otherwise, adds the key-value pair to the cache. If the number of keys exceeds the capacity, evict the least recently used key.

Both get and put must run in O(1) average time complexity.

---

## 💡 Approach & Key Insights

To achieve O(1) time complexity for both get and put operations:
- Use a HashMap to store key → pointer to node in a Doubly Linked List (DLL).
- The DLL keeps track of the most recently used order, with:
  - Head: Most recently used.
  - Tail: Least recently used.
- When a key is accessed or added:
  - Move its node to the front (right after head).
  - If capacity is exceeded, remove node from the end (before tail).

---

## 🛠️ Breakdown of Approaches

### 1️⃣ Brute Force / Naive Approach

Explanation:  
Use a LinkedList and linear search to implement put and get.  
Too slow for O(1) requirement. Every access or insert may require O(N) time for searching.

Time Complexity: O(N) per operation  
Space Complexity: O(N) for storage

Example/Dry Run:  
get(1) — Scan entire list to find key = 1 → O(N)

---

### 2️⃣ Optimized Approach (HashMap + DLL)

Explanation:  
Use:
- HashMap<int, Node*> to access nodes in O(1).
- Doubly Linked List to maintain LRU order.

Steps:
- get(key):  
  - If key exists → move node to head → return value.  
  - Else → return -1.
- put(key, value):  
  - If key exists → update value → move node to head.  
  - If not → insert new node → add to head.  
  - If capacity exceeded → remove node from tail → erase from map.

Time Complexity: O(1) for both get and put  
Space Complexity: O(capacity)

Example/Dry Run:  
Input:
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]  
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]  
Output: [null, null, null, 1, null, -1, null, -1, 3, 4]

---

### 3️⃣ Best / Final Optimized Approach (if applicable)

Same as optimized. No better than O(1) per operation.

---

## 📊 Complexity Analysis

| Approach       | Time Complexity | Space Complexity |
|----------------|------------------|------------------|
| Brute Force    | O(N)             | O(N)             |
| Optimized      | O(1)             | O(N)             |
| Best Approach  | O(1)             | O(N)             |

---

## 📉 Optimization Ideas

- Use a custom DLL instead of built-in collections for better control over node management.
- Avoid unnecessary key re-insertion in hashmap.

---

## 📌 Example Walkthroughs & Dry Runs

Capacity = 2  
put(1,1) → cache = {1=1}  
put(2,2) → cache = {1=1, 2=2}  
get(1)   → return 1 → cache = {2=2, 1=1}  
put(3,3) → evict 2 → cache = {1=1, 3=3}  
get(2)   → return -1 (not found)  
put(4,4) → evict 1 → cache = {3=3, 4=4}  
get(1)   → return -1 (not found)  
get(3)   → return 3  
get(4)   → return 4

---


## 🔗 Additional Resources

- [Stack Visualization Tool](https://visualgo.net/en/list)  

Author: Neha Amin  
Date: 19/07/2025