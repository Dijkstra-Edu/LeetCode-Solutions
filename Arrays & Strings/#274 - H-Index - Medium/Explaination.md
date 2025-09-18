# H-Index

**Difficulty:** Medium
**Category:** Arrays, Sorting, Counting Sort
**LeetCode Link:**  [Problem Link](https://leetcode.com/problems/h-index/)  

---

## 📝 Introduction

We are given an array `citations` where `citations[i]` represents the number of citations a researcher received for their `i-th` paper.  

The **H-Index** is defined as the **maximum value `h`** such that the researcher has published at least `h` papers that have each been cited at least `h` times.

We need to compute and return this H-Index.

---

## 💡 Approach & Key Insights

1. **Definition Recap**:  
   The H-Index is the point where the number of papers with at least `h` citations is **greater than or equal to `h`**.

2. **Sorting Insight**:  
   If we sort the `citations` in descending order, then the `h-index` is simply the largest index `i` where:
   ```
   citations[i] >= i + 1
   ```
   (`i+1` represents the number of papers considered so far).

3. **Alternative Counting Approach**:  
   Since the maximum H-Index is at most `n` (number of papers), we can use a counting array to bucket citation frequencies and avoid sorting.

---

## 🛠️ Breakdown of Approaches

### 1️⃣ Sorting-Based Approach

- **Explanation:**  
  - Sort citations in descending order.  
  - Traverse and find the last index `i` such that `citations[i] >= i+1`.  
  - That `i+1` is the H-Index.  
- **Time Complexity:** O(n log n) (due to sorting).  
- **Space Complexity:** O(1) (if in-place sort is allowed).

---

### 2️⃣ Counting Approach (Optimized)

- **Explanation:**  
  - Create a frequency array `count` of size `n+1`.  
  - For each citation `c`:
    - If `c >= n`, increment `count[n]` (since H-Index cannot exceed `n`).  
    - Else increment `count[c]`.  
  - Traverse `count` from `n` down to `0`, maintaining a cumulative sum of papers.  
  - The first index `i` where cumulative papers ≥ `i` is the H-Index.  
- **Time Complexity:** O(n).  
- **Space Complexity:** O(n).

---

## 📊 Complexity Analysis

| Approach              | Time Complexity | Space Complexity |
| --------------------- | --------------- | ---------------- |
| Sorting               | O(n log n)      | O(1) / O(n)      |
| Counting (Optimized)  | O(n)            | O(n)             |

---

## 📌 Example Walkthroughs & Dry Runs

Example 1:
```
Input: citations = [3, 0, 6, 1, 5]

Step 1: Sort descending → [6, 5, 3, 1, 0]
Step 2: Check each index:
  i=0 → 6 >= 1 → valid
  i=1 → 5 >= 2 → valid
  i=2 → 3 >= 3 → valid
  i=3 → 1 >= 4 → false → stop
Answer = 3
```

Output: `3`

---

Example 2:
```
Input: citations = [1, 3, 1]

Sort descending → [3, 1, 1]
Check:
  i=0 → 3 >= 1 → valid
  i=1 → 1 >= 2 → false → stop
Answer = 1
```

Output: `1`

---

## 🔗 Additional Resources

- [H-Index Explanation (Wikipedia)](https://en.wikipedia.org/wiki/H-index)  
- [Leetcode Discuss - H-Index Solutions](https://leetcode.com/problems/h-index/discuss/)  

---

Author: Aman Deol  
Date: 26/08/2025  
