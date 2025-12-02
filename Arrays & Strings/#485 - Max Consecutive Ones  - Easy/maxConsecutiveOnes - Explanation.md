# Problem Title: Max Consecutive Ones

**Difficulty:** Easy  
**Category:** Arrays  
**Leetcode Link:** https://leetcode.com/problems/max-consecutive-ones/

---

## 📝 Introduction

You're given a binary array `nums` (only 0s and 1s). Your task is to find the **maximum number of consecutive 1s** in the array.

Deceptively simple on the surface, but a perfect warm-up problem to build sliding window intuition.

---

## 💡 Approach & Key Insights

- We want the **longest streak** of consecutive 1s.
- Every time we hit a `0`, the streak ends.
- The simplest way: use a running counter for current streak and a max counter to store the best streak seen.

This is extremely efficient and requires just one pass.

---

## 🛠️ Breakdown of Approaches

### 1️⃣ Brute Force / Naive Approach

- **Explanation:**
  - Check each starting index.
  - Count how many 1s follow it.
  - Track the maximum.
  - Works, but extremely inefficient.
- **Time Complexity:** O(n²)
- **Space Complexity:** O(1)
- **Example/Dry Run:**

Example: `[1,1,0,1]`
```
Start at index 0 → streak = 2
Start at index 1 → streak = 1
Start at index 2 → streak = 0
Start at index 3 → streak = 1
Max = 2
```

---

### 2️⃣ Optimized Approach

- **Explanation:**
  - Traverse the array once.
  - Keep:
    - `currentCount` → current streak of 1s
    - `maxCount` → best streak found
  - Reset `currentCount` to 0 whenever you encounter a 0.
- **Time Complexity:** O(n)
- **Space Complexity:** O(1)
- **Example/Dry Run:**

Example: `[1,1,0,1,1,1]`
```
1 → current=1, max=1
1 → current=2, max=2
0 → current=0
1 → current=1, max=2
1 → current=2, max=2
1 → current=3, max=3
Final answer = 3
```

---

### 3️⃣ Best / Final Optimized Approach

- There is no faster solution than O(n) — the optimized pass is already the final method.

---

## 📊 Complexity Analysis

| Approach      | Time Complexity | Space Complexity |
| ------------- | --------------- | ---------------- |
| Brute Force   | O(n²)           | O(1)             |
| Optimized     | O(n)            | O(1)             |
| Best Approach | O(n)            | O(1)             |

---

## 📉 Optimization Ideas

- If the array is extremely large and memory-mapped, streaming evaluation still works due to O(1) space.
- Useful trick: whenever you see a problem involving **consecutive streaks**, think linear scan + counters first.

---

## 📌 Example Walkthroughs & Dry Runs

```plaintext
Example:
Input: [0,1,1,1,0,1,1]
Process:
- Streaks: 3 and 2
Output: 3
```

```plaintext
Example:
Input: [1,1,1,1]
Process:
- Entire array is a streak of 4
Output: 4
```

---

## 🔗 Additional Resources

- Sliding Window Basics
- Counting Techniques in Arrays
- LeetCode Discuss Thread

---

Author:
Date: 18/11/2025