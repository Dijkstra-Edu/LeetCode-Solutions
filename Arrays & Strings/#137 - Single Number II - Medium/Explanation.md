# Single Number II

**Difficulty:** Medium  
**Category:** Arrays, Bit Manipulation  
**Leetcode Link:** [Problem Link](https://leetcode.com/problems/single-number-ii/)  

---

## 📝 Introduction

We are given an integer array `nums` where every element appears exactly **three times**, except for one element which appears exactly **once**. The task is to find and return this unique element.  
The solution must have:
- **Linear runtime complexity** O(n)
- **Constant extra space** O(1)

---

## 💡 Approach & Key Insights

The naive approach would involve counting the occurrences of each number (using a hash map), but that would require **O(n)** extra space, violating the space constraint.

Instead, we can use **bitwise manipulation** to track the count of each bit across all numbers:
- Maintain two bitmasks:
  - **`ones`** → bits that have appeared exactly once so far.
  - **`twos`** → bits that have appeared exactly twice so far.
- When a bit appears a **third time**, it is removed from both `ones` and `twos`.

The key insight:
- `ones = (ones ^ num) & ~twos`
- `twos = (twos ^ num) & ~ones`
- XOR toggles the bit, AND with `~` masks out unwanted bits.

---

## 🛠️ Breakdown of Approaches

### 1️⃣ Brute Force / Naive Approach

- **Explanation:**  
  Use a hash map to count each number’s frequency, then return the number with count = 1.
- **Time Complexity:** O(n)  
- **Space Complexity:** O(n)

Example:  
`nums = [2, 2, 3, 2]` → Frequency: `{2: 3, 3: 1}` → Output: `3`

---

### 2️⃣ Bitwise Counting Approach

- **Explanation:**  
  For each bit position (0–31), count how many numbers have that bit set.  
  Take `count % 3` to determine if that bit belongs to the unique number.
- **Time Complexity:** O(32n) ≈ O(n)  
- **Space Complexity:** O(1)

Example:  
Count bits column-wise → reconstruct the number.

---

### 3️⃣ Best / Final Optimized Approach (Bitmask Method)

- **Explanation:**  
  Use `ones` and `twos` to track the counts of bits modulo 3.
- **Time Complexity:** O(n) — single pass  
- **Space Complexity:** O(1) — only two variables used

Example/Dry Run for `nums = [2, 2, 3, 2]`:  
Binary:  
- 2 → `10`  
- 3 → `11`

Step-by-step:
```
Initial: ones=00, twos=00

num=2: ones=(00^10)&~00=10, twos=(00^10)&~10=00
num=2: ones=(10^10)&~00=00, twos=(00^10)&~00=10
num=3: ones=(00^11)&~10=01, twos=(10^11)&~01=00
num=2: ones=(01^10)&~00=11, twos=(00^10)&~11=00
Final: ones=11 (decimal 3)
```
Output: `3`

---

## 📊 Complexity Analysis

| Approach      | Time Complexity | Space Complexity |
| ------------- | --------------- | ---------------- |
| Brute Force   | O(n)            | O(n)             |
| Bit Count     | O(n)            | O(1)             |
| Bitmask Method| O(n)            | O(1)             |

---

## 📉 Optimization Ideas

The **bitmask method** is already optimal for both runtime and space. Any further improvements would be micro-optimizations or hardware-specific.

---

## 📌 Example Walkthroughs & Dry Runs

Example:  
```
Input: nums = [0, 1, 0, 1, 0, 1, 99]
Output: 99

Step-by-step bitmask evolution:
ones=0, twos=0
Process each number using:
ones = (ones ^ num) & ~twos
twos = (twos ^ num) & ~ones
Final ones=99 → Output
```

---

## 🔗 Additional Resources

- [LeetCode Bit Manipulation Patterns](https://leetcode.com/tag/bit-manipulation/)
- [GeeksforGeeks - Bitwise Operators](https://www.geeksforgeeks.org/bitwise-operators-in-c-cpp/)

---

Author: Kailash Senthilkumar  
Date: 09/08/2025  
