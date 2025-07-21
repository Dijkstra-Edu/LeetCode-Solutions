# 39. Combination Sum

**Difficulty:** *Medium*  
**Category:** *Backtracking, Recursion*  
**Leetcode Link:** [Problem Link](https://leetcode.com/problems/combination-sum/)

---

## 📝 Introduction

*Given an array of distinct integers and a target, the task is to return all unique combinations where the chosen numbers sum up to the target. Each number in the array may be used an unlimited number of times.*

*Constraints typically include:<br>
- All input numbers are distinct positive integers.<br>
- Each number may be used any number of times in a combination.<br>
- Total number of unique combinations is less than 150.*

---

## 💡 Approach & Key Insights

*The core idea is to explore all valid combinations recursively using the "pick / not pick" technique:<br>
- At each step, either pick the current number and stay at the same index (since it can be reused), or skip it and move to the next index.<br>
- Maintain a running sum and a temporary combination list.<br>
- If the running sum becomes 0, we’ve found a valid combination and we save it.<br>
- Backtrack after each recursive call to try new combinations.*

---

## 🛠️ Breakdown of Approaches

### 1️⃣ Recursive Backtracking (Pick / Non-pick)

- **Explanation:** *We recursively explore all combinations starting from index 0. For each number, we can choose to either include it (and stay at the same index) or exclude it (move to next index). Whenever target becomes 0, we add the current path to the result.*
- **Time Complexity:** *O(2^t) – where t = target value. Actual complexity depends on pruning.*
- **Space Complexity:** *O(k * x) – where x is the number of valid combinations, k is average length.*
- **Example/Dry Run:**

```plaintext
Input: [2,3,6,7], target = 7
Sorted: [2,3,6,7]

Start at index 0:
- Pick 2 → [2], target = 5
  - Pick 2 → [2,2], target = 3
    - Pick 2 → [2,2,2], target = 1
      - Pick 2 → [2,2,2,2], target = -1 (backtrack)
    - Skip 2, pick 3 → [2,2,3], target = 0 → ✅
  - Skip 2, pick 3 → [2,3], target = 2
    - Pick 3 again → target = -1 (backtrack)
- Pick 7 → [7], target = 0 → ✅

Output: [[2,2,3], [7]]
```

---

## 📊 Complexity Analysis

| Approach            | Time Complexity | Space Complexity |
| ------------------- | --------------- | ---------------- |
| Recursive Backtrack | O(2^t)          | O(k × x)         |

---

## 📉 Optimization Ideas

*Although the recursion tree explores all combinations, sorting the input and pruning branches where target < candidate[i] can improve efficiency. Additionally, memoization can be applied but is typically unnecessary within the constraint of <150 combinations.*

---

## 📌 Example Walkthroughs & Dry Runs

```plaintext
Example 1:
Input: [2,3,6,7], target = 7

Recursive Tree:
Start with []
Pick 2: [2] → target=5
Pick 2 again: [2,2] → target=3
Pick 2 again: [2,2,2] → target=1
Pick 2 again → exceeds → backtrack
Backtrack and pick 3 → [2,2,3] → ✅ target=0

Pick 7: [7] → ✅

Output: [[2,2,3],[7]]

Example 2:
Input: [2], target = 1

Only choice: 2 > 1 → cannot pick → return []

Output: []
```

---

## 🔗 Additional Resources

- [Backtracking explanation](https://medium.com/upsolve-digest/template-for-backtracking-problems-part1-the-basics-75f744cab925)
- [Python recursion guide](https://realpython.com/python-thinking-recursively/)

---

Author: Neha Amin <br>
Date: 19/07/2025
