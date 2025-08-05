# 18. 4Sum

**Difficulty:** Medium  
**Category:** Arrays, Two Pointers, Hashing  
**Leetcode Link:** [4Sum Problem](https://leetcode.com/problems/4sum/)

---

## 📝 Introduction

Given an array `nums` of `n` integers and an integer `target`, return all unique quadruplets `[nums[a], nums[b], nums[c], nums[d]]` such that:

- `0 <= a, b, c, d < n`
- `a`, `b`, `c`, and `d` are distinct
- `nums[a] + nums[b] + nums[c] + nums[d] == target`

The result must not contain duplicate quadruplets.

---

## 💡 Approach & Key Insights

To solve this problem, we explore different strategies from brute-force to optimal:

- Start by checking every combination of four numbers (brute force).
- Reduce the number of loops by leveraging hashing for lookups (better approach).
- Use sorting and two pointers to achieve an optimal time complexity (final approach).
- Remove duplicates using sorted input and pointer movement logic.

---

## 🛠️ Breakdown of Approaches

### 1️⃣ Brute Force / Naive Approach

- **Explanation:**  
  - Use four nested loops to pick all combinations of four distinct indices.
  - For each quadruplet, if their sum equals the target, sort it and insert it into a set (to avoid duplicates).
  - Finally, return all unique sorted quadruplets.

- **Time Complexity:** O(N⁴ * log M)  
  - 4 loops + set insertions (log M where M is number of unique quads)

- **Space Complexity:** O(M)  
  - To store unique quadruplets in a set.

- **Example/Dry Run:**

Example input: `[1, 0, -1, 0, -2, 2]`, Target = 0  
Process:  
Check every 4-tuple → Add valid ones to set  
Output: `[[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]]`

---

### 2️⃣ Optimized Approach (Using 3 Loops + HashSet)

- **Explanation:**  
  - Use three nested loops (`i`, `j`, `k`) to select three numbers.
  - Calculate the required fourth number as `target - (nums[i] + nums[j] + nums[k])`.
  - Search for this number in a temporary HashSet (built on-the-fly).
  - Sort the resulting quadruplet and store in a set to maintain uniqueness.

- **Time Complexity:** O(N³ * log M)  
  - 3 loops + HashSet lookup + set insertions

- **Space Complexity:** O(M + N)  
  - Set for results and HashSet for lookup

- **Example/Dry Run:**

Input: `[1, 2, -1, -2, 2, 0, -1]`, Target = 0  
Step 1: i = 0, j = 1, k = 2  
Sum = 1 + 2 + (-1) = 2, required = -2  
Step 2: Check if -2 exists in HashSet  
Continue storing valid quads

Output: `[[-2, -1, 1, 2], [-1, -1, 0, 2]]`

---

### 3️⃣ Best / Final Optimized Approach (2 Pointers + Sorting)

- **Explanation:**  
  - Sort the array first.
  - Fix two pointers (`i` and `j`) using nested loops.
  - Use two other pointers `k` and `l` to find the remaining two numbers using a two-pointer technique.
  - Skip duplicate values to maintain uniqueness.

- **Time Complexity:** O(N³)  
  - 2 fixed + 2 moving pointers = nested loops with linear scan

- **Space Complexity:** O(M)  
  - For storing results only

- **Example/Dry Run:**

Input: `[4, 3, 3, 4, 4, 2, 1, 2, 1, 1]`, Target = 9  
Sorted: `[1, 1, 1, 2, 2, 3, 3, 4, 4, 4]`  
Step 1: i = 0, j = 1, k = 2, l = 9  
While k < l, move based on current sum  
Skip duplicates after storing a valid quad

Output: `[[1, 1, 3, 4], [1, 2, 2, 4], [1, 2, 3, 3]]`

---

## 📊 Complexity Analysis

| Approach      | Time Complexity | Space Complexity |
| ------------- | --------------- | ---------------- |
| Brute Force   | O(N⁴ * log M)   | O(M)             |
| Optimized     | O(N³ * log M)   | O(M + N)         |
| Best Approach | O(N³)           | O(M)             |

---

## 📉 Optimization Ideas

- Skip duplicates after sorting to avoid storing the same quadruplet multiple times.
- Use long long to avoid integer overflow during summation.
- Efficient pointer movement makes the solution clean and fast.
- Avoid unnecessary lookups by reducing hash operations.

---

## 📌 Example Walkthroughs & Dry Runs

plaintext
Example:
Input: [1, 0, -1, 0, -2, 2], Target = 0  
Sorted: [-2, -1, 0, 0, 1, 2]  
Step-by-step:  
i = 0 (-2), j = 1 (-1), k = 2 (0), l = 5 (2)  
Sum = -1 → too small → move k  
Sum = 0 → store [-2, -1, 1, 2]  
Skip duplicates → next iteration...

Output: [[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]]

---

## 🔗 Additional Resources


- [GeeksForGeeks Explanation](https://www.geeksforgeeks.org/find-four-elements-that-sum-to-a-given-value-set-2/)

---

Author: Abdul Wahab  
Date: 19/07/2025
