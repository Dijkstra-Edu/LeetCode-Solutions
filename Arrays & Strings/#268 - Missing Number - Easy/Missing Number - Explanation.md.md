# Missing Number

**Difficulty:** Easy  
**Category:** Arrays, Bit Manipulation  
**Leetcode Link:** [Problem Link](https://leetcode.com/problems/missing-number/)  

---

## 📝 Introduction

Given an array `nums` containing `n` distinct numbers in the range `[0, n]`, the task is to find the single number missing from this range. The input guarantees exactly one missing number.

**Constraints:**
- `n` numbers, each unique, ranging from 0 to n.
- Exactly one number in this range is missing.
- Expected output: the missing number.

---

## 💡 Approach & Key Insights

The main idea is to leverage the **XOR property**:
- XOR of a number with itself is 0 (`x ^ x = 0`).
- XOR of a number with 0 is the number itself (`x ^ 0 = x`).
- XOR is commutative and associative.

If we XOR all indices (0 to n) with all numbers in the array, the duplicates cancel out, leaving only the missing number.

---

## 🛠️ Breakdown of Approaches

### 1️⃣ Brute Force / Naive Approach

- **Explanation:**  
  Loop through numbers from `0` to `n` and check if each is present in the array. Return the number that is not found.
- **Time Complexity:** O(n²) — because for each number we scan the array.
- **Space Complexity:** O(1) — no extra space needed apart from variables.

Example:  
Input: `[3, 0, 1]`  
Step 1: Check `0` → Found  
Step 2: Check `1` → Found  
Step 3: Check `2` → Missing → Output: `2`

---

### 2️⃣ Optimized Approach (Sum Formula)

- **Explanation:**  
  Use the sum formula for the first `n` integers:  
  `expectedSum = n * (n + 1) / 2`  
  Subtract the actual sum of the array from `expectedSum` to get the missing number.
- **Time Complexity:** O(n) — single pass to get the sum.
- **Space Complexity:** O(1) — only variables for sums.

Example:  
Input: `[3, 0, 1]`  
n = 3 → Expected Sum = `6`  
Actual Sum = `4`  
Missing = `6 - 4 = 2`

---

### 3️⃣ Best / Final Optimized Approach (XOR Method)

- **Explanation:**  
  XOR all numbers from `0` to `n` with all elements of the array. All pairs cancel out except the missing number.  
  This avoids integer overflow (unlike sum approach for very large n) and still runs in O(n).
- **Time Complexity:** O(n) — single pass.
- **Space Complexity:** O(1) — no extra space.

Example:  
Input: `[3, 0, 1]`  
```
xor = 0
xor ^ 0 ^ 3 = 3  
xor ^ 1 ^ 0 = 4 (in binary cancels out)  
xor ^ 2 = 2 (final answer)
```

---

## 📊 Complexity Analysis

| Approach      | Time Complexity | Space Complexity |
| ------------- | --------------- | ---------------- |
| Brute Force   | O(n²)           | O(1)             |
| Optimized     | O(n)            | O(1)             |
| Best Approach | O(n)            | O(1)             |

---

## 📉 Optimization Ideas

The XOR method is already optimal for both time and space. Any further optimization would focus on language-specific performance tricks, but asymptotic complexity cannot be improved.

---

## 📌 Example Walkthroughs & Dry Runs

Example:  
Input: `nums = [3, 0, 1]`  
n = 3  
```
xor = 0
i = 0 → xor = 0 ^ 0 ^ 3 = 3
i = 1 → xor = 3 ^ 1 ^ 0 = 2
i = 2 → xor = 2 ^ 2 ^ 1 = 1
Final: xor = 1 ^ 3 = 2
Output: 2
```

---

## 🔗 Additional Resources

- [LeetCode Discussion on XOR Trick](https://leetcode.com/problems/missing-number/discuss)
- [Bit Manipulation Basics](https://www.geeksforgeeks.org/bitwise-operators-in-c-cpp/)

---

Author: Kailash Senthilkumar  
Date: 09/08/2025  
