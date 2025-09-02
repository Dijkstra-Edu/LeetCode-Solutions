# Longest Palindromic Substring

**Difficulty:** Medium  
**Category:** String, Dynamic Programming, Expand Around Center  
**Leetcode Link:** [Problem Link](https://leetcode.com/problems/longest-palindromic-substring/)  

---

## 📝 Introduction

We are given a string `s` and need to return the **longest palindromic substring** in `s`.  

A palindrome is a string that reads the same forward and backward (e.g., `"aba"`, `"abba"`).  
We want the **longest substring** (continuous segment) that satisfies this property.  

---

## 💡 Approach & Key Insights

1. **Brute Force**  
   - Generate all substrings and check if each is a palindrome.  
   - Too slow: O(n³) (substring generation + palindrome check).  

2. **Expand Around Center (Optimal for interview)**  
   - A palindrome mirrors around its center.  
   - For each index in `s`, try to expand outwards for:
     - Odd length palindrome (center at one character).  
     - Even length palindrome (center between two characters).  
   - Keep track of the longest one.  
   - Time: O(n²), Space: O(1).  

3. **Dynamic Programming**  
   - Use a DP table where `dp[i][j] = true` if substring `s[i..j]` is a palindrome.  
   - Build up from length 1 → n.  
   - Time: O(n²), Space: O(n²).  

4. **Manacher’s Algorithm (Advanced)**  
   - Linear time O(n). Rarely required in interviews.  
   - Uses transformed string with separators (`#`) to handle even/odd uniformly.  

👉 For coding interviews, **Expand Around Center** is the most elegant and accepted solution.  

---

## 🛠️ Breakdown of Approaches

### 1️⃣ Expand Around Center

- For each index `i` in `s`, expand outward to find:
  - Longest odd palindrome centered at `i`.  
  - Longest even palindrome centered between `i` and `i+1`.  
- Track the maximum length found.  

**Time Complexity:** O(n²)  
**Space Complexity:** O(1)  

---

### 2️⃣ Dynamic Programming

- Fill a DP table `dp[i][j]`.  
- Base cases:
  - Single characters are palindromes.  
  - Two equal characters form a palindrome of length 2.  
- For longer substrings, use relation:  
  ```
  dp[i][j] = (s[i] == s[j]) && dp[i+1][j-1]
  ```  
- Track longest palindrome.  

**Time Complexity:** O(n²)  
**Space Complexity:** O(n²)  

---

## 📊 Complexity Analysis

| Approach              | Time Complexity | Space Complexity |
| --------------------- | --------------- | ---------------- |
| Brute Force           | O(n³)           | O(1)             |
| Expand Around Center  | O(n²)           | O(1)             |
| Dynamic Programming   | O(n²)           | O(n²)            |
| Manacher’s Algorithm  | O(n)            | O(n)             |

---

## 📌 Example Walkthroughs & Dry Runs

Example 1:
```
Input: s = "babad"

Centers:
- Expand at 'b' → "bab"
- Expand at 'a' → "aba"
Longest found = "bab" (or "aba")

Output: "bab"
```

Example 2:
```
Input: s = "cbbd"

Centers:
- Expand at 'c' → "c"
- Expand between "bb" → "bb"
Longest = "bb"

Output: "bb"
```

---


## 🔗 Additional Resources

- [Palindrome Explanation (Wikipedia)](https://en.wikipedia.org/wiki/Palindrome)  
- [Manacher’s Algorithm Explanation](https://cp-algorithms.com/string/manacher.html)  
- [Leetcode Discuss - Longest Palindromic Substring Solutions](https://leetcode.com/problems/longest-palindromic-substring/discuss/)  
- [Youtube Video Explanation](https://www.youtube.com/watch?v=UflHuQj6MVA)  

---

Author: Kailash Senthilkumar  
Date: 09/08/2025  