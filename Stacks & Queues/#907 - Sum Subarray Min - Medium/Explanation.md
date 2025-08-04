# 907. Sum of Subarray Minimums  
[](https://github.com/Dijkstra-Edu/LeetCode-Solutions/blob/master/Explanation-Template.md#problem-title)  
Difficulty: Medium  
Category: Arrays, Monotonic Stack, Dynamic Programming  
Leetcode Link: [Problem Link](https://leetcode.com/problems/sum-of-subarray-minimums/)  

---

## 📝 Introduction  
Given an array arr of integers, the task is to compute the sum of the minimum element of every contiguous subarray.  
Since the total can be very large, the answer must be returned modulo 10^9 + 7.  
Constraints:
- 1 <= arr.length <= 3 × 10^4  
- 1 <= arr[i] <= 3 × 10^4  

---

## 💡 Approach & Key Insights   
We are asked to find the sum of all subarray minimums.  
A brute force approach would involve generating all subarrays and calculating their minimum, which is inefficient.  
To optimize, we observe that:
- Each element arr[i] contributes to multiple subarrays as the minimum.
- We can calculate how many subarrays each arr[i] will be the minimum for, using a monotonic stack.
- With dynamic programming, we avoid recalculating overlapping subarray results.

---

## 🛠️ Breakdown of Approaches  

### 1️⃣ Brute Force / Naive Approach  
  
Explanation:  
Generate all subarrays, find the minimum of each, and add them to a running total.  
This method becomes inefficient for large arrays.  

Time Complexity: O(n²) – Generating and traversing all subarrays  
Space Complexity: O(1) – No extra space beyond loop variables  

Example/Dry Run:  
Example input: [3, 1, 2, 4]  
Step 1 → [3] → min = 3  
Step 2 → [3,1] → min = 1  
Step 3 → [3,1,2] → min = 1  
... → Total = 17  

---

### 2️⃣ Optimized Approach  
 
Explanation:  
Use a monotonic stack to track the previous less element for each index.  
Using a DP array res, where res[i] stores the sum of minimums for all subarrays ending at index i.  
We compute res[i] using:
res[i] = res[j] + arr[i] × (i - j), where j is the index of the last element less than arr[i].

Time Complexity: O(n) – Each element is pushed and popped once  
Space Complexity: O(n) – For res array and stack  

Example/Dry Run:  
Input: [3, 1, 2, 4]  
Step 1 → stack = [], res = [3, 0, 0, 0]  
Step 2 → pop 3, res[1] = 2  
Step 3 → stack = [1,2], res[2] = 4  
Step 4 → res[3] = 8  
Output: sum = 17  

---

### 3️⃣ Best / Final Optimized Approach (if applicable)  

Explanation:  
Same as optimized. There are no better solutions than O(n) using monotonic stacks for this problem.  

Time Complexity: O(n) – Monotonic stack traversal  
Space Complexity: O(n) – Stack and DP array  

Example/Dry Run:  
Example input: [3, 1, 2, 4]  
Step 1 → res = [3, 2, 4, 8]  
Step 2 → Sum = 3 + 2 + 4 + 8 = 17  

---

## 📊 Complexity Analysis   

| Approach       | Time Complexity | Space Complexity |
|----------------|------------------|------------------|
| Brute Force    | O(n²)            | O(1)             |
| Optimized      | O(n)             | O(n)             |
| Best Approach  | O(n)             | O(n)             |

---

## 📉 Optimization Ideas  
  
- We could reduce space slightly by avoiding the res array and using a single accumulator.  
- However, the monotonic stack approach is already optimal in time and space for this problem's constraints.  

---

## 📌 Example Walkthroughs & Dry Runs  

Input: arr = [3, 1, 2, 4]  
Process:  
- i = 0 → arr[0] = 3 → res[0] = 3  
- i = 1 → pop stack → arr[1] = 1 → res[1] = 2  
- i = 2 → arr[2] > arr[1] → res[2] = res[1] + 2 × 1 = 4  
- i = 3 → res[3] = res[2] + 4 × 1 = 8  
res = [3, 2, 4, 8]  
Output = sum(res) = 17  

---

## 🔗 Additional Resources    

- [Monotonic Stack Guide](https://www.geeksforgeeks.org/dsa/introduction-to-monotonic-stack-2/)  
- [Dynamic Programming Basics](https://www.geeksforgeeks.org/dynamic-programming/)  
- [C++ STL Stack](https://cplusplus.com/reference/stack/stack/)  

Author: Neha Amin 
Date: 19/07/2025  
