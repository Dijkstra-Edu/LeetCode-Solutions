# Problem Title: Concatenation of Array

**Difficulty:** Easy  
**Category:** Array, Simulation  
**LeetCode Link:** https://leetcode.com/problems/concatenation-of-array/

---

## 📝 Introduction
You're given an integer array `nums`. Your task is to create a new array `ans` of size `2 * n` where:

```
ans[i] = nums[i]
ans[i + n] = nums[i]
```

In short: **Just stick the array to itself.** Yup, it’s literally copy–paste.

---

## 💡 Approach & Key Insights
- This is a straightforward construction problem.
- No tricks, no traps, no two pointers pretending to be deep.
- Just build a new array where the second half repeats the first.

---

## 🛠️ Breakdown of Approaches

### 1️⃣ Brute Force (Almost too simple to be called brute force)
- Create a new array of size `2n`.
- First loop: fill `ans[0..n-1]` with `nums`.
- Second loop: fill `ans[n..2n-1]` with `nums` again.
- **Time Complexity:** O(n)
- **Space Complexity:** O(n)

### 2️⃣ Optimized / Best Approach
- Just do: `ans = nums + nums` (in languages that allow it).
- Or use array copy utilities.
- Still **O(n)** time and space — but cleaner code.

There’s no further optimization possible here… unless you bully the interviewer.

---

## 📊 Complexity Analysis

| Approach     | Time Complexity | Space Complexity |
|--------------|----------------|------------------|
| Standard     | O(n)           | O(n)             |
| Best Approach| O(n)           | O(n)             |

---

## 📉 Example / Dry Run

### Example 1:
```
Input: nums = [1,2,1]

ans:
Index: 0 1 2 3 4 5
Value: 1 2 1 1 2 1

Output: [1,2,1,1,2,1]
```

### Example 2:
```
Input: nums = [1,3,2,1]
Output: [1,3,2,1,1,3,2,1]
```

---

## 🔗 Additional Notes
- This problem is typically used to warm up or check basic array manipulation.
- If this feels too easy — good. It was supposed to.

---

Author:  
Date: 18/11/2025

