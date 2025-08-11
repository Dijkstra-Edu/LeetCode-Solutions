# 15. 3Sum 

**Difficulty:** Medium  
**Category:** Arrays, Two Pointers, Hashing  
**Leetcode Link:** [Problem Link](https://leetcode.com/problems/3sum)

---

## 📝 Introduction

Given an integer array `nums`, return all the unique triplets `[nums[i], nums[j], nums[k]]` such that:
- `i != j`, `i != k`, and `j != k`,
- `nums[i] + nums[j] + nums[k] == 0`

The solution must not contain duplicate triplets.

---

## 💡 Approach & Key Insights

The main idea is to find all unique triplets in the array that sum to zero. Since the problem demands uniqueness and excludes repeated indices, care must be taken in how the triplets are collected. We can go from a brute force solution using three nested loops to a highly optimized two-pointer strategy that leverages sorting and duplicate skipping.

---

## 🛠️ Breakdown of Approaches

### 1️⃣ Brute Force / Naive Approach

- **Explanation:**  
  Iterate through all combinations of three distinct indices using three nested loops. For each combination, check if the sum is zero. Use a set to store sorted triplets to avoid duplicates.

- **Time Complexity:** O(N³ * log M)  
  Where `N` is the length of the array and `M` is the number of unique triplets (for insertion into the set).

- **Space Complexity:** O(M)  
  For storing unique triplets in a set.

- **Example/Dry Run:**

  Input: `[-1, 0, 1, 2, -1, -4]`  
  Valid triplets (after sorting): `[-1, -1, 2]`, `[-1, 0, 1]`  
  Output: `[[-1, -1, 2], [-1, 0, 1]]`

---

### 2️⃣ Better Approach (Using HashSet)

- **Explanation:**  
  Fix two elements using nested loops and calculate the third element required to make the sum zero. Use a HashSet to check if this third element has already been seen. Ensure only elements between the second loop's index range are included in the HashSet to prevent using the same element multiple times.

- **Time Complexity:** O(N² * log M)  
  Due to two loops and set insertions.

- **Space Complexity:** O(M + N)  
  For storing unique triplets and temporary HashSet.

- **Example/Dry Run:**

  Input: `[-1, 0, 1, 2, -1, -4]`  
  Valid triplets: `[-1, -1, 2]`, `[-1, 0, 1]`  
  Output: `[[-1, -1, 2], [-1, 0, 1]]`

---

### 3️⃣ Best / Final Optimized Approach (Two Pointers + Sorting)

- **Explanation:**  
  Sort the array first. Use one fixed pointer `i`, and two moving pointers `j` and `k` (`j = i+1`, `k = n-1`). Move the pointers inward while skipping duplicates. If the sum is zero, store the triplet. If the sum is too small, increment `j`; if too large, decrement `k`.

- **Time Complexity:** O(N²)  
  Due to one fixed pointer and a linear scan with two pointers.

- **Space Complexity:** O(M)  
  Only for storing the result triplets.

- **Example/Dry Run:**

  Sorted Input: `[-4, -1, -1, 0, 1, 2]`  
  i = 0 → j = 1, k = 5 → `-4 + (-1) + 2 = -3` → j++  
  ...  
  Found: `[-1, -1, 2]` and `[-1, 0, 1]`

---

## 📊 Complexity Analysis

| Approach         | Time Complexity         | Space Complexity       |
| ---------------- | ----------------------- | ---------------------- |
| Brute Force      | O(N³ * log M)           | O(M)                   |
| Better Approach  | O(N² * log M)           | O(M + N)               |
| Best Approach    | O(N²)                   | O(M)                   |

---

## 📉 Optimization Ideas

- Sorting the array simplifies duplicate management.
- Using two pointers eliminates the need for a HashSet and reduces time complexity.
- Skipping duplicates on the fly avoids unnecessary checks and result post-processing.

---

## 📌 Example Walkthroughs & Dry Runs

plaintext
Example:
Input: [-1, 0, 1, 2, -1, -4]
Sorted: [-4, -1, -1, 0, 1, 2]

Iteration:
i = 0 → arr[i] = -4, j = 1, k = 5
Sum = -4 + (-1) + 2 = -3 → j++

i = 1 → arr[i] = -1, j = 2, k = 5
Sum = -1 + (-1) + 2 = 0 → Store triplet [-1, -1, 2], j++, k--

i = 1, j = 3, k = 4
Sum = -1 + 0 + 1 = 0 → Store triplet [-1, 0, 1], j++, k--

Duplicates skipped using while loops

Output: [[-1, -1, 2], [-1, 0, 1]]

---

## 🔗 Additional Resources

- [GeeksForGeeks Explanation](https://www.geeksforgeeks.org/find-triplets-array-whose-sum-equal-zero/)

---

Author: Abdul Wahab 
Date: 19/07/2025
