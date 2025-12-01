# 1394. Find Lucky Integer in an Array

**Difficulty:** Easy  
**Category:** Arrays, Hashing  
**Leetcode Link:** https://leetcode.com/problems/find-lucky-integer-in-an-array/ [web:18]

---

## 📝 Introduction

You are given an integer array `arr`.  
A *lucky integer* is defined as an integer whose **value is equal to its frequency** in the array.  
The task is to return the **largest** lucky integer, or `-1` if no such integer exists. [web:18][web:2]

Key points and constraints:  
- `1 <= arr.length <= 500`  
- `1 <= arr[i] <= 500`  
- Need to compare each value with how many times it appears and pick the maximum such value. [web:2][web:40]

---

## 💡 Approach & Key Insights

Main idea:  
1. Count how many times each number appears in the array (its frequency).  
2. A number is *lucky* if `value == frequency`.  
3. Among all lucky numbers, return the **largest** one. [web:16][web:4]

Insights:  
- A brute force solution can compute frequency for each element by scanning the array repeatedly (nested loops).  
- An optimal solution uses a frequency structure (hash map or counting array) to count in linear time, then scans the frequency structure to find the largest value satisfying `value == frequency`. [web:16][web:40]

---

## 🛠️ Breakdown of Approaches

### 1️⃣ Brute Force / Naive Approach

- **Explanation:**  
  - For each element `arr[i]`, iterate over the entire array and count how many times this value appears.  
  - After counting, if `count == arr[i]`, then `arr[i]` is a lucky integer candidate.  
  - Track the **maximum** such candidate across all elements.  
  - This is exactly the logic you wrote in Java/Python/C++ with nested loops (just fix the condition to `count == temp` and keep max). [web:16][web:32]

- **Time Complexity:**  
  - Outer loop runs `n` times, inner loop runs `n` times for each outer iteration.  
  - Overall \(O(n^2)\) time. [web:31][web:33]

- **Space Complexity:**  
  - Uses only a few integer variables (`temp`, `count`, `lucky`).  
  - Overall \(O(1)\) extra space. [web:31]

- **Example/Dry Run:**

Example input: `arr = [2, 2, 3, 4]` [web:2][web:40]  

- Step 1: `i = 0`, `temp = 2`  
  - Count frequency of `2` by scanning entire array → `count = 2`.  
  - Check `count == temp` → `2 == 2` → lucky candidate = 2, `lucky = 2`.  

- Step 2: `i = 1`, `temp = 2` again  
  - Frequency still 2, `count == temp` → `lucky` remains 2.  

- Step 3: `i = 2`, `temp = 3`  
  - Count frequency of `3` → `count = 1`, `count != temp`, ignore.  

- Step 4: `i = 3`, `temp = 4`  
  - Count frequency of `4` → `count = 1`, `count != temp`, ignore.  

Output: `2`.

---

### 2️⃣ Optimized Approach

- **Explanation:**  
  - Instead of recounting each value with nested loops, use a **frequency map/array**.  
  - First pass: build `freq[x] = frequency of x` for all elements in `arr`.  
  - Second pass: iterate over possible values and check where `value == freq[value]`.  
  - Track the **maximum** value that satisfies this condition. [web:16][web:4][web:40]

  Because constraints are small (`arr[i] <= 500`), a simple integer array of size `501` is enough for frequencies. [web:2][web:16]

- **Time Complexity:**  
  - Count frequencies in \(O(n)\).  
  - Scan possible values (at most 500) in \(O(K)\) where `K = 500`.  
  - Total \(O(n + K)\), effectively \(O(n)\) for given constraints. [web:16][web:40]

- **Space Complexity:**  
  - Frequency array of fixed size `501`.  
  - Overall \(O(K)\), which is \(O(1)\) relative to `n` (because K is bounded by constraints). [web:16][web:46]

- **Example/Dry Run:**

Example input: `arr = [1, 2, 2, 3, 3, 3]` [web:2][web:40]

- Step 1: Count frequencies:  
  - `freq[1] = 1`, `freq[2] = 2`, `freq[3] = 3`, all others 0.  
- Step 2: Check values from high to low:  
  - `i = 6, 5, 4` → `freq[i]` not equal to `i`.  
  - `i = 3` → `freq[3] = 3` → lucky, candidate = 3.  
  - `i = 2` → `freq[2] = 2` → also lucky, but smaller than 3.  
  - `i = 1` → `freq[1] = 1` → also lucky, but smaller than 3.  
- Step 3: Return the largest lucky integer seen → `3`.

Output: `3`.

---

### 3️⃣ Best / Final Optimized Approach (if applicable)

For this problem, the **counting array or hashmap frequency solution** is already optimal in both time and space under the given constraints. [web:16][web:4][web:10]

- **Explanation:**  
  - Use a hash map or fixed-size array to count all frequencies in a single pass.  
  - Then either:
    - Scan from largest possible value to smallest (guarantees the first match is the answer), or
    - Collect all lucky integers and take their maximum.  
  - This approach is simple, fast, and directly encodes the problem definition `value == frequency`. [web:16][web:46]

- **Time Complexity:**  
  - \(O(n)\) to build frequencies + \(O(K)\) to scan, where `K` is bounded (≤ 500).  
  - Overall \(O(n)\) for practical purposes. [web:16][web:40]

- **Space Complexity:**  
  - \(O(K)\) for the frequency structure, effectively constant. [web:16][web:46]

- **Example/Dry Run:**

Example input: `arr = [2, 2, 2, 3, 3]` [web:2][web:40]

- Step 1: Build frequency:  
  - `freq[2] = 3`, `freq[3] = 2`.  
- Step 2: Scan from high to low:  
  - `i = 5, 4` → `freq[i] = 0`, not equal to `i`.  
  - `i = 3` → `freq[3] = 2`, `2 != 3` → not lucky.  
  - `i = 2` → `freq[2] = 3`, `3 != 2` → not lucky.  
  - `i = 1` → `freq[1] = 0`, not lucky.  
- No lucky integer found → return `-1`.

Output: `-1`.

---

## 📊 Complexity Analysis

| Approach      | Time Complexity   | Space Complexity |
| ------------- | -----------------| ---------------- |
| Brute Force   | O(n²)            | O(1)             |
| Optimized     | O(n + K) ≈ O(n)  | O(K) (K ≤ 500)   |
| Best Approach | O(n + K) ≈ O(n)  | O(K) (K ≤ 500)   | [web:16][web:46]

---

## 📉 Optimization Ideas

- Because `arr[i]` is at most 500, using a **fixed-size array** is more cache-friendly and simpler than a generic hash map. [web:2][web:16]  
- Scanning from the **maximum possible value downwards** allows early exit as soon as the largest lucky integer is found. [web:16][web:46]  
- In languages with built-in frequency utilities (like `Counter` in Python), code can be both concise and efficient while still following the same logic. [web:16]

---

## 📌 Example Walkthroughs & Dry Runs
```
Example 1:
Input:​

Frequencies:
2 -> 2 times
3 -> 1 time
4 -> 1 time

Lucky check:
2: value 2, frequency 2 -> lucky
3: value 3, frequency 1 -> not lucky
4: value 4, frequency 1 -> not lucky

Largest lucky integer = 2
Output: 2

Example 2:
Input:​

Frequencies:
1 -> 1 time
2 -> 2 times
3 -> 3 times

Lucky integers: 1, 2, 3 (all satisfy value == frequency)
Largest lucky integer = 3
Output: 3
```

---

## 🔗 Additional Resources

- [LeetCode Problem 1394 – Find Lucky Integer in an Array](https://leetcode.com/problems/find-lucky-integer-in-an-array/)  
- [In-depth explanation with frequency map and code examples](https://algo.monster/liteproblems/1394)  
- [Alternative editorial and multi-language solutions](https://progiez.com/1394-find-lucky-integer-in-an-array-leetcode-solution)  
- [Another clean solution write-up](https://walkccc.me/LeetCode/problems/1394/)

---

Author: *Samuel Joseph S*  
Date: *01/12/2025*