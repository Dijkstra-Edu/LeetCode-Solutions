# 40. Combination Sum II

**Difficulty:** *Medium*  
**Category:** *Backtracking, Recursion*  
**Leetcode Link:** [Problem Link](https://leetcode.com/problems/combination-sum-ii/)

---

## 📝 Introduction

*Given a collection of candidate numbers (candidates) and a target number (target), the task is to find all unique combinations in candidates where the numbers sum to the target. Each number may be used at most once in a combination.*

*Constraints typically include:<br>
- Each input number is a positive integer.<br>
- The same combination should not be included more than once in the result.*

---

## 💡 Approach & Key Insights

*The main idea is to perform backtracking (recursion with pruning):<br>
- Sort the array to handle duplicates easily.<br>
- At each recursive call, iterate through candidates starting from the current index.<br>
- Skip duplicates by checking if the current element is the same as the previous.<br>
- Use a temporary list to store current combination and subtract from the target as we recurse.<br>
- If target == 0, add the temporary list to the result.<br>
- Backtrack by removing the last added number to try other possibilities.*

---

## 🛠️ Breakdown of Approaches

### 1️⃣ Brute Force / Naive Approach

- **Explanation:** *Try every possible combination using backtracking. Use extra space to store combinations and avoid duplicates by checking previously seen values. Sorting helps ensure duplicates are adjacent, allowing us to skip them efficiently.*
- **Time Complexity:** *O(2^n) – in the worst case, every subset is explored.*
- **Space Complexity:** *O(n * k) – where k is the number of combinations.*
- **Example/Dry Run:**

```plaintext
Input: candidates = [10,1,2,7,6,1,5], target = 8
Sorted: [1,1,2,5,6,7,10]

Possible unique combinations:
[1,1,6], [1,2,5], [1,7], [2,6]
```

---

## 📊 Complexity Analysis

| Approach      | Time Complexity | Space Complexity |
| ------------- | --------------- | ---------------- |
| Brute Force   | O(2^n)          | O(n × k)         |

---

## 📉 Optimization Ideas

*Although this problem is inherently exponential due to subset generation, pruning steps (like breaking early when arr[i] > target and skipping duplicates) significantly reduce runtime in practice.*

---

## 📌 Example Walkthroughs & Dry Runs

```plaintext
Example 1:
Input: candidates = [10,1,2,7,6,1,5], target = 8
Sorted: [1,1,2,5,6,7,10]

Recursive Tree (Simplified):
Start at index 0 with target = 8
- Choose 1 → target = 7
    - Choose 1 → target = 6
        - Choose 6 → target = 0 → valid → [1,1,6]
        - Backtrack
    - Choose 2 → target = 5
        - Choose 5 → target = 0 → valid → [1,2,5]
    - Choose 7 → target = 0 → valid → [1,7]
    - ...
- Choose 2 → target = 6
    - Choose 6 → target = 0 → valid → [2,6]

Output: [[1,1,6], [1,2,5], [1,7], [2,6]]

Example 2:
Input: candidates = [2,5,2,1,2], target = 5
Sorted: [1,2,2,2,5]

Output: [[1,2,2],[5]]
```

---

## 🔗 Additional Resources

- [Python Backtracking Basics](https://www.geeksforgeeks.org/dsa/backtracking-algorithm-in-python/)
- [Sorting for Duplicate Handling](https://docs.python.org/3/howto/sorting.html)

---

Author: Neha Amin <br>
Date: 19/07/2025
