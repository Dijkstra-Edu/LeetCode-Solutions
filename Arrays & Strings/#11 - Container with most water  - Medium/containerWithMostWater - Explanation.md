# Problem Title: Container With Most Water

**Difficulty:** Medium  
**Category:** Two Pointers, Greedy  
**Leetcode Link:** https://leetcode.com/problems/container-with-most-water/

---

## 📝 Introduction

You're given an array `height[]` where each element represents the height of a vertical line on the x-axis. Picking any two lines forms a container that can trap water. The objective is to determine the **maximum possible water** that can be trapped.

---

## 💡 Approach & Key Insights

- Water trapped between two lines depends on:
  - Width = (right - left)
  - Height = minimum of the two heights
- To maximize area, we need a combination of good width and good height.
- Moving the pointer with the **smaller height** gives a chance to find a taller boundary, which could increase area.

---

## 🛠️ Breakdown of Approaches

### 1️⃣ Brute Force / Naive Approach

- **Explanation:**
  - Check all possible pairs of lines `(i, j)`.
  - Compute the area for each.
  - Keep track of the highest.
- **Time Complexity:** O(n²)
- **Space Complexity:** O(1)
- **Example/Dry Run:**

Example: `height = [1, 8, 6]`
```
Pairs:
(0,1): width=1, minHeight=1 → area=1
(0,2): width=2, minHeight=1 → area=2
(1,2): width=1, minHeight=6 → area=6
Max = 6
```

---

### 2️⃣ Optimized Approach

- **Explanation:**
  - Use two pointers starting at both ends.
  - Compute area.
  - Move the pointer with the lower height inward.
  - Continue until left meets right.
- **Time Complexity:** O(n)
- **Space Complexity:** O(1)
- **Example/Dry Run:**

Example: `height = [1,8,6,2,5,4,8,3,7]`
```
l=0 (1), r=8 (7) → area=8 → move l
l=1 (8), r=8 (7) → area=49 → move r
l=1 (8), r=7 (3) → area=18 → move r
l=1 (8), r=6 (8) → area=40 → move r
...
Max area = 49
```

---

### 3️⃣ Best / Final Optimized Approach

- The two-pointer solution is already optimal.
- No better time complexity exists for this problem.

---

## 📊 Complexity Analysis

| Approach      | Time Complexity | Space Complexity |
| ------------- | --------------- | ---------------- |
| Brute Force   | O(n²)           | O(1)             |
| Optimized     | O(n)            | O(1)             |
| Best Approach | O(n)            | O(1)             |

---

## 📉 Optimization Ideas

- You can't beat O(n), but you can:
  - Improve pointer movement logic for readability.
  - Add early exits if certain patterns are detected.

---

## 📌 Example Walkthroughs & Dry Runs

```plaintext
Example:
Input: [4,3,2,1,4]
- (0,4): width=4, height=4 → area=16
- Next comparisons produce smaller areas
Output: 16
```

```plaintext
Example:
Input: [1,2,1]
- (0,2): width=2, height=1 → area=2
- (1,2): width=1, height=1 → area=1
Output: 2
```

---

## 🔗 Additional Resources

- Two Pointer Techniques
- Greedy Strategy Explanations
- LeetCode Official Discuss Section

---

Author:  
Date: 18/11/2025

