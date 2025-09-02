# Longest Happy Prefix

**Difficulty:** Hard  
**Category:** String, KMP, Rolling Hash  
**Leetcode Link:** [Problem Link](https://leetcode.com/problems/longest-happy-prefix/)  

---

## 📝 Introduction

We are given a string `s`.  
We need to find the **longest prefix** which is also a **suffix** (excluding the entire string itself).  
This is sometimes referred to as a **happy prefix**.  

Example:
s = "level"
Happy prefix = "l" (prefix "l", suffix "l")


If no happy prefix exists, return the empty string `""`.

---

## 💡 Approach & Key Insights

1. **Brute Force (Naive)**  
   - Try all prefix lengths and check if equal to suffix.  
   - Very slow: O(n²).

2. **KMP Prefix Function (Optimal)**  
   - Use the prefix-function (a.k.a. failure function in KMP).  
   - It gives us the longest border of the string (prefix = suffix).  
   - Time: O(n), Space: O(n).

3. **Rolling Hash (Alternative)**  
   - Maintain hash of prefix and suffix.  
   - Compare hashes for each possible length.  
   - Time: O(n), Space: O(1).

👉 In interviews, **KMP prefix-function** is the cleanest and most accepted solution.

---

## 🛠️ Breakdown of Approaches

### 1️⃣ Brute Force
- Generate all prefixes and check with suffix.
- Time: O(n²).

### 2️⃣ KMP Prefix Function
- Compute LPS array (`lps[i]` = longest border for substring `s[0..i]`).
- Final value gives the happy prefix length.
- Time: O(n).

### 3️⃣ Rolling Hash
- Compute rolling hash from left and right.
- Compare prefix-hash and suffix-hash at each step.
- Time: O(n).

---

## 📊 Complexity Analysis

| Approach        | Time Complexity | Space Complexity |
|-----------------|-----------------|------------------|
| Brute Force     | O(n²)           | O(1)             |
| KMP (Optimal)   | O(n)            | O(n)             |
| Rolling Hash    | O(n)            | O(1)             |

---

## 📌 Example Walkthroughs

Example 1:
Input: s = "level"
Prefixes: ["l", "le", "lev", "leve"]
Suffixes: ["evel", "vel", "el", "l"]
Longest common = "l"

Output: "l"

Example 2:

---

## 🔗 Additional Resources
- [Prefix Function Explanation (CP-Algorithms)](https://cp-algorithms.com/string/prefix-function.html)  

---

Author: Aman Deol  
Date: 02/09/2025  
