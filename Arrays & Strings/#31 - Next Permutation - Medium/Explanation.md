# 31. Next Permutation

**Difficulty:** *Medium*  
**Category:** *Arrays, Permutations, Greedy*  
**Leetcode Link:** [Problem Link](https://leetcode.com/problems/next-permutation/)

---

## 📝 Introduction

*Given an array Arr[] of integers, rearrange the numbers into the lexicographically next greater permutation of numbers.  
If such an arrangement is not possible, rearrange it to the lowest possible order (i.e., sorted in ascending order).*

*Constraints typically include:<br>
- All integers may be distinct or contain duplicates.<br>
- The transformation must be done in-place with only constant extra memory.*

---

## 💡 Approach & Key Insights

*There are three main approaches to solve this problem:<br>
- Brute Force: Generate all permutations and pick the next.<br>
- In-Built Function: Use next_permutation() if language provides it.<br>
- Optimal: Use the standard algorithm to compute the next permutation by identifying a break point, swapping, and reversing.*

---

## 🛠️ Breakdown of Approaches

### 1️⃣ Brute Force / Naive Approach

- **Explanation:** *Generate all permutations of the array, sort them, and locate the input permutation. Return the next one in sequence. If not found or if it's the last permutation, return the first (sorted array).*
- **Time Complexity:** *O(N! × N) – N! permutations each of length N.*
- **Space Complexity:** *O(1) – ignoring recursion stack used for generating permutations.*
- **Example/Dry Run:**

```plaintext
Input: [1, 2, 3]
All permutations: [ [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1] ]
Current permutation: [1,2,3]
Next permutation: [1,3,2]
```

### 2️⃣ Language Built-in (C++ std::next_permutation)

- **Explanation:** *C++ provides next_permutation() which directly modifies the array to the next permutation.*
- **Time Complexity:** *O(N) – internally optimized.*
- **Space Complexity:** *O(1).*
- **Example:**

```cpp
std::vector<int> nums = {1, 2, 3};
std::next_permutation(nums.begin(), nums.end());
// nums is now [1, 3, 2]
```

### 3️⃣ Optimal Approach

- **Explanation:**  
  1. Find the break-point: The first index i from the back where arr[i] < arr[i+1].  
  2. If no such index exists, reverse the whole array (it was the last permutation).  
  3. Else, find the smallest number greater than arr[i] from the right half, swap it with arr[i].  
  4. Reverse the subarray from i+1 to end.

- **Time Complexity:** *O(3N) = O(N) – each of the three steps (finding break-point, finding next greater, reversing) takes O(N).*
- **Space Complexity:** *O(1) – all operations are done in-place.*
- **Example/Dry Run:**

```plaintext
Input: [1, 2, 3]

Step 1: Find break-point: 2 < 3 at index 1 → i = 1  
Step 2: Find element just greater than arr[i]: 3 at index 2  
Step 3: Swap 2 and 3 → [1, 3, 2]  
Step 4: Reverse from i+1 = 2 to end → Already sorted

Output: [1, 3, 2]
```

---

## 📊 Complexity Analysis

| Approach       | Time Complexity   | Space Complexity |
| -------------- | ----------------- | ---------------- |
| Brute Force    | O(N! × N)         | O(1)             |
| In-Built       | O(N)              | O(1)             |
| Optimal        | O(N)              | O(1)             |

---

## 📉 Optimization Ideas

*The optimal solution is already efficient for all constraints.  
You may consider early exits in case the array is already in decreasing order to avoid redundant operations.*

---

## 📌 Example Walkthroughs & Dry Runs

```plaintext
Example 1:
Input: [1, 3, 2]
Break-point: index 0 (1 < 3)
Swap with next greater: swap 1 and 2 → [2, 3, 1]
Reverse after index 0 → [2, 1, 3]
Output: [2, 1, 3]

Example 2:
Input: [3, 2, 1]
Break-point: None (fully decreasing)
Reverse entire array → [1, 2, 3]
Output: [1, 2, 3]
```

---

## 🔗 Additional Resources

- [C++ next_permutation documentation](https://en.cppreference.com/w/cpp/algorithm/next_permutation)

---

Author: Neha Amin <br>
Date: 19/07/2025
