# Find Closest Person

**Difficulty:** Easy  
**Category:** Math, Simulation  
**Leetcode Link:** [Problem Link](https://leetcode.com/problems/find-closest-person/)  

---

## 📝 Introduction

We are given three integers `x`, `y`, and `z` representing positions of three people on a number line:
- Person 1 is at position `x`.
- Person 2 is at position `y`.
- Person 3 is at position `z` (stationary).

Both Person 1 and Person 2 move toward Person 3 at the same speed.  
We must determine which person reaches Person 3 first:
- Return `1` if Person 1 arrives first.
- Return `2` if Person 2 arrives first.
- Return `0` if both arrive at the same time.

---

## 💡 Approach & Key Insights

The problem reduces to comparing **absolute distances** from each person to Person 3:
- `dist1 = abs(x - z)`
- `dist2 = abs(y - z)`

The smaller distance determines who reaches first. If both distances are equal, both reach at the same time.

---

## 🛠️ Breakdown of Approaches

### 1️⃣ Direct Distance Comparison

- **Explanation:**  
  Compute the absolute difference in positions between each moving person and Person 3. Compare distances to decide the result.
- **Time Complexity:** O(1) — Only two distance calculations and a comparison.
- **Space Complexity:** O(1) — Only a few variables are used.

Example:  
```
x = 2, y = 7, z = 4
dist1 = |2 - 4| = 2
dist2 = |7 - 4| = 3
Output: 1 (Person 1 arrives first)
```

---

## 📊 Complexity Analysis

| Approach        | Time Complexity | Space Complexity |
| --------------- | --------------- | ---------------- |
| Distance Compare| O(1)            | O(1)             |

---

## 📌 Example Walkthroughs & Dry Runs

Example 1:  
```
Input: x = 2, y = 7, z = 4
dist1 = 2, dist2 = 3
Result: 1
```

Example 2:  
```
Input: x = 2, y = 5, z = 6
dist1 = 4, dist2 = 1
Result: 2
```

Example 3:  
```
Input: x = 1, y = 5, z = 3
dist1 = 2, dist2 = 2
Result: 0
```

---

## 🔗 Additional Resources

- [Absolute Value in Programming](https://en.wikipedia.org/wiki/Absolute_value)
- [LeetCode Simulation Problems](https://leetcode.com/tag/simulation/)

---

Author: Kailash Senthilkumar  
Date: 09/08/2025  
