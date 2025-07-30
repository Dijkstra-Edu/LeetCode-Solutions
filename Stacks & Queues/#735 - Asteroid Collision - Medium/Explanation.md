# 735. Asteroid Collision 
Difficulty: Medium  
Category: Stack, Simulation  
Leetcode Link: [Problem Link](https://leetcode.com/problems/asteroid-collision/)

---

## 📝 Introduction
You're given a list of integers representing asteroids moving in a row. Each asteroid's value represents its size and direction (positive for right-moving, negative for left-moving). When two asteroids moving in opposite directions collide, the smaller one explodes. If both are equal, both explode. Return the state of the asteroids after all collisions.  
Constraints:
- -1000 ≤ asteroids[i] ≤ 1000  
- 2 ≤ asteroids.length ≤ 10⁴  

---

## 💡 Approach & Key Insights

The core idea is to simulate collisions using a stack. As we traverse the asteroids, we push right-moving ones onto the stack. When encountering a left-moving asteroid, we check if the top of the stack has a right-moving asteroid, triggering a possible collision. This approach allows us to efficiently simulate the process and determine the surviving asteroids.

---

## 🛠️ Breakdown of Approaches

### 1️⃣ Brute Force / Naive Approach

Explanation:  
Simulate the collisions with nested loops. For each asteroid, check future asteroids for possible collisions and adjust the list accordingly.  
Inefficient due to repeated scanning and insertion/deletion from the middle of the list.

Time Complexity: O(N²) - Nested loop comparisons for every possible collision.  
Space Complexity: O(1) - No extra space besides the input list.

Example/Dry Run:  
Input: [5, 10, -5]  
Step 1 → 5 is pushed  
Step 2 → 10 is pushed  
Step 3 → -5 collides with 10 → -5 is destroyed  
Output: [5, 10]

---

### 2️⃣ Optimized Approach

Explanation:  
Use a stack to keep track of surviving asteroids. Iterate through the list and resolve collisions dynamically.  
- Push all right-moving asteroids.
- For left-moving asteroids, check if top of stack is right-moving → simulate collision.
- Pop smaller asteroid, remove both if equal, or skip push if current is destroyed.
- Finally, return the stack.

Time Complexity: O(N) - Each asteroid is pushed and popped at most once.  
Space Complexity: O(N) - In the worst case, all asteroids are pushed to the stack.

Example/Dry Run:  
Input: [10, 2, -5]  
Step 1 → 10 is pushed  
Step 2 → 2 is pushed  
Step 3 → -5 collides with 2 → 2 destroyed  
         → -5 collides with 10 → -5 destroyed  
Output: [10]

---

### 3️⃣ Best / Final Optimized Approach (if applicable)

Same as optimized above. No further optimization possible beyond O(N) time and space.

---

## 📊 Complexity Analysis

| Approach       | Time Complexity | Space Complexity |
|----------------|------------------|------------------|
| Brute Force    | O(N²)            | O(1)             |
| Optimized      | O(N)             | O(N)             |
| Best Approach  | O(N)             | O(N)             |

---

## 📉 Optimization Ideas

- Cannot reduce below O(N) time since every asteroid must be evaluated.
- Space may be reduced by modifying input list in-place (if allowed).

---

## 📌 Example Walkthroughs & Dry Runs

Example:  
Input: [8, -8]  
Process:  
1 → 8 is pushed  
2 → -8 collides with 8 → both destroyed  
Output: []

Example:  
Input: [10, 2, -5]  
Process:  
1 → 10 pushed  
2 → 2 pushed  
3 → -5 destroys 2 → then -5 is destroyed by 10  
Output: [10]

---

## 🔗 Additional Resources
 
- [Stack Visualization Tool](https://visualgo.net/en/list)  
- [Leetcode Discussion](https://leetcode.com/problems/asteroid-collision/discuss)

Author: Neha Amin  
Date: 19/07/2025
