## 🧮 Two Sum II - Input Array Is Sorted

Difficulty: Easy
Category: Arrays, Two Pointers
Leetcode Link: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

### 📝 Introduction

You're given a sorted array of integers in non-decreasing order and a target value. The task is to find the indices of the two numbers such that they add up to the target value. The return should be in 1-based indexing, and you can assume exactly one solution exists and no element is reused.

### 💡 Approach & Key Insights

    Key Insight: Since the array is sorted, we can use the two-pointer technique instead of brute force.

    Naive approach checks all pairs — this is simple but inefficient (O(n²)).

    Optimized approach uses two pointers (start and end) to shrink the search space intelligently in O(n) time.

    We return a dynamically allocated array in C to store the result as C functions can’t directly return multiple values.

### 🛠️ Breakdown of Approaches

### 1️⃣ Brute Force / Naive Approach

Explanation:
Check every pair (i, j) where i < j. If numbers[i] + numbers[j] == target, return their 1-based indices.

Time Complexity: O(n²)
Each element is paired with every other element ahead of it.

Space Complexity: O(1)
No extra space is used apart from result.

Example / Dry Run:

Example input: [2, 7, 11, 15], target = 9
Steps:

    2+7=9 → match found
    Output: [1, 2]

### 2️⃣ Optimized Approach

Explanation:
Use two pointers:

    Start l = 0

    End r = n - 1

Repeat:

    If numbers[l] + numbers[r] == target → return [l+1, r+1]

    If sum is greater → move right pointer left

    If sum is less → move left pointer right

Time Complexity: O(n)
Only one pass through the array.

Space Complexity: O(1)
Only two pointers and result array of size 2.

Example / Dry Run:

Input: [2, 7, 11, 15], target = 9
Steps:

    l = 0, r = 3 → 2 + 15 = 17 → too big → r--

    l = 0, r = 2 → 2 + 11 = 13 → still big → r--

    l = 0, r = 1 → 2 + 7 = 9 → match!
    Output: [1, 2]

### 3️⃣ Best / Final Optimized Approach (Same as above)

Since the optimized two-pointer approach is already the most efficient for this problem, no further optimization is needed.

### 📊 Complexity Analysis

| Approach      | Time Complexity | Space Complexity |
| ------------- | --------------- | ---------------- |
| Brute Force   | O(n²)           | O(1)             |
| Optimized     | O(n)            | O(1)             |
| Best Approach | O(n)            | O(1)             |

### 📉 Optimization Ideas

    You can’t use hashing effectively here since the input is sorted, and space must be O(1).

    No need to explore binary search as two-pointer provides linear time with constant space.

### 📌 Example Walkthroughs & Dry Runs

Example 1:

Input: [2, 7, 11, 15], target = 9

Initial pointers:
l = 0 → 2
r = 3 → 15

Step 1: 2 + 15 = 17 → too big → r = 2
Step 2: 2 + 11 = 13 → still big → r = 1
Step 3: 2 + 7 = 9 → match found → return [1, 2]

### 🔗 Additional Resources

- [Understanding Two Pointer Technique - GeeksForGeeks](https://www.geeksforgeeks.org/two-pointers-technique/)


Author: hanzel-sc
Date: 07/07/2025