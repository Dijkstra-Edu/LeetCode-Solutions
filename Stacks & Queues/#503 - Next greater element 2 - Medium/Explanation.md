# 503. Next Greater Element II

**Difficulty:** Medium  
**Category:** Arrays, Stack, Monotonic Stack  
**Leetcode Link:** [Problem Link](https://leetcode.com/problems/next-greater-element-ii)

---

## 📝 Introduction

Given a circular array, the task is to find the next greater element for each element in the array. The "next greater element" for a number x is the first greater number traversing the array in the forward direction. If it doesn’t exist, assign -1. Since the array is circular, we simulate traversing the array twice.

Constraints typically include:<br>
- 1 ≤ nums.length ≤ 10⁴  
- -10⁹ ≤ nums[i] ≤ 10⁹  

---

## 💡 Approach & Key Insights

The brute force solution involves checking for the next greater element by looping through the array for each element. This leads to O(n²) time complexity.

The optimized approach uses a monotonic decreasing stack and processes the array twice to simulate circularity. While traversing in reverse, we pop elements smaller than or equal to the current one from the stack. If the stack is not empty, the top is the next greater element.

---

## 🛠️ Breakdown of Approaches

### 1️⃣ Brute Force / Naive Approach

- **Explanation:**  
  For each element, we look forward in the array (circularly) to find the next greater number. This requires a nested loop.
- **Time Complexity:** O(n²) – We iterate through the array for each element.
- **Space Complexity:** O(1) – No extra space except for the output.
- **Example/Dry Run:**

```plaintext
Input: [1, 2, 1]
i = 0 → 2 is next greater → ans[0] = 2  
i = 1 → no element greater → ans[1] = -1  
i = 2 → 2 is next greater (wraps around) → ans[2] = 2  
Output: [2, -1, 2]
```

### 2️⃣ Optimized Approach

- **Explanation:**  
  We use a stack to maintain indices in a decreasing order of values. We traverse the array twice in reverse order to simulate the circular array. At each index, we pop all smaller or equal values. If the stack is not empty, the top of the stack is the next greater element.
- **Time Complexity:** O(n) – Each element is pushed and popped at most once.
- **Space Complexity:** O(n) – For the stack and output array.
- **Example/Dry Run:**

```plaintext
Input: [1, 2, 1]
Initialize ans = [-1, -1, -1]
Pass 1 (i = 5 to 0): (simulate 2*n = 6 steps)

i=5 → idx=2 → stack=[], ans[2]=-1 → push 1  
i=4 → idx=1 → stack=[1], 2>1 → pop → stack=[], ans[1]=-1 → push 2  
i=3 → idx=0 → stack=[2], 2>1 → ans[0]=2 → push 1  
i=2 → idx=2 → stack=[2,1], top=1==1 → pop → stack=[2], top=2>1 → ans[2]=2 → push 1  
i=1 → idx=1 → top=1<2 → ans[1]=-1 (already assigned) → push 2  
i=0 → idx=0 → ans[0]=2 (already assigned)

Final Output: [2, -1, 2]
```

### 3️⃣ Best / Final Optimized Approach

- **Explanation:**  
  Same as optimized above using a monotonic decreasing stack. The idea of traversing 2n times in reverse is optimal and handles circularity efficiently.
- **Time Complexity:** O(n) – Each index is processed at most twice.
- **Space Complexity:** O(n) – Stack and output array.

---

## 📊 Complexity Analysis

| Approach      | Time Complexity | Space Complexity |
| ------------- | --------------- | ---------------- |
| Brute Force   | O(n²)           | O(1)             |
| Optimized     | O(n)            | O(n)             |
| Best Approach | O(n)            | O(n)             |

---

## 📉 Optimization Ideas

This problem is well-optimized with a monotonic stack. Further optimization is not needed. Any approach faster than O(n) is not feasible as every element must be checked at least once.

---

## 📌 Example Walkthroughs & Dry Runs

```plaintext
Example:
Input: [1, 2, 3, 4, 3]

i=4 → 3 → stack=[], ans[4]=-1 → push 3  
i=3 → 4 → pop 3, stack=[], ans[3]=-1 → push 4  
i=2 → 3 → 4>3 → ans[2]=4 → push 3  
i=1 → 2 → 3>2 → ans[1]=3 → push 2  
i=0 → 1 → 2>1 → ans[0]=2 → push 1  

Output: [2, 3, 4, -1, 4]
```

---

## 🔗 Additional Resources

- [Monotonic Stack - Intuition](https://www.geeksforgeeks.org/dsa/introduction-to-monotonic-stack-2/)
- [Java Stack Docs](https://docs.oracle.com/javase/8/docs/api/java/util/Stack.html)

---

Author: Abdul Wahab  
Date: 19/07/2025
