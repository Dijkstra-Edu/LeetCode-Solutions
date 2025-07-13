# 283. Move Zeroes

**Difficulty:** *Easy*  
**Category:** *Arrays, Two Pointers*  
**Leetcode Link:** [Problem Link](https://leetcode.com/problems/move-zeroes/)

---

## 📝 Introduction

*Given an array, the task is to move all the zeros to the end of the array while maintaining the relative order of the non-zero elements.*

*Constraints typically include:<br>
- The operation must be done in-place without making a copy of the array.<br>
- Minimize the total number of operations.*

---

## 💡 Approach & Key Insights

*The key idea is to segregate non-zero elements from zeros without disturbing their relative order. There are multiple approaches:<br>
- Brute force copies non-zero elements to a temporary array.<br>
- Optimal approach uses two pointers to do in-place swapping, reducing space complexity and preserving order efficiently.*

---

## 🛠️ Breakdown of Approaches

### 1️⃣ Brute Force / Naive Approach

- **Explanation:** *We copy all non-zero elements to a temporary array. Then, we place them back into the original array starting from the beginning. Finally, we fill the remaining positions with zeros.*
- **Time Complexity:** *O(n) – linear scan to collect non-zeros and overwrite.*
- **Space Complexity:** *O(n) – extra space for temporary array.*
- **Example/Dry Run:**

```plaintext
Input: [1, 0, 2, 3, 2, 0, 0, 4, 5, 1]
Step 1: temp = [1, 2, 3, 2, 4, 5, 1]
Step 2: Overwrite first 7 positions with temp → [1, 2, 3, 2, 4, 5, 1, _, _, _]
Step 3: Fill remaining with 0 → [1, 2, 3, 2, 4, 5, 1, 0, 0, 0]
```

### 2️⃣ Optimized Approach

- **Explanation:** *Use two pointers `j` and `i`. Pointer `j` finds the first zero, and `i` scans ahead. When `a[i]` is non-zero, swap `a[i]` with `a[j]` and move `j` forward.*
- **Time Complexity:** *O(n) – each element is visited once.*
- **Space Complexity:** *O(1) – in-place operation.*
- **Example/Dry Run:**

```plaintext
Input: [1, 0, 2, 3, 2, 0, 0, 4, 5, 1]
Step 1: j = index of first 0 → j = 1
Step 2: i = j + 1 = 2
Iterate:
i=2 → a[2]=2 ≠ 0 → swap a[2] and a[1] → [1, 2, 0, 3, 2, 0, 0, 4, 5, 1], j=2  
i=3 → a[3]=3 ≠ 0 → swap a[3] and a[2] → [1, 2, 3, 0, 2, 0, 0, 4, 5, 1], j=3  
i=4 → a[4]=2 ≠ 0 → swap a[4] and a[3] → [1, 2, 3, 2, 0, 0, 0, 4, 5, 1], j=4  
... and so on.
Final Output: [1, 2, 3, 2, 4, 5, 1, 0, 0, 0]
```

---

## 📊 Complexity Analysis

| Approach      | Time Complexity | Space Complexity |
| ------------- | --------------- | ---------------- |
| Brute Force   | O(n)            | O(n)             |
| Optimized     | O(n)            | O(1)             |

---

## 📉 Optimization Ideas

*The two-pointer method is already optimal in terms of both time and space. Further optimizations are unnecessary, though one could explore variations like minimizing swaps.*

---

## 📌 Example Walkthroughs & Dry Runs

```plaintext
Example:
Input: [0, 1, 0, 3, 12]
Two pointers:
j = 0 (points to 0)
i = 1 → a[1]=1 ≠ 0 → swap → [1, 0, 0, 3, 12], j=1  
i = 2 → a[2]=0 → skip  
i = 3 → a[3]=3 ≠ 0 → swap → [1, 3, 0, 0, 12], j=2  
i = 4 → a[4]=12 ≠ 0 → swap → [1, 3, 12, 0, 0], j=3  
Output: [1, 3, 12, 0, 0]
```

---

## 🔗 Additional Resources

- [Python list methods](https://docs.python.org/3/tutorial/datastructures.html)

---

Author: Neha Amin  <br>
Date: 18/07/2025