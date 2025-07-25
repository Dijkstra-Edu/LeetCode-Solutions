# Problem Title

**Difficulty:** Easy   
**Category:** Strings,Hash table
**Leetcode Link:** [Problem Link]https://leetcode.com/problems/ransom-note/

---

## 📝 Introduction

You are given two strings: ransomNote and magazine.
You need to determine if you can construct the ransomNote using the letters from magazine.

Each letter in magazine can only be used once in ransomNote.
Return true if possible, otherwise return false.

Constraints:

1 <= ransomNote.length, magazine.length <= 10⁵

ransomNote and magazine consist of lowercase English letters

---

## 💡 Approach & Key Insights

The key idea is to count the frequency of each character in both ransomNote and magazine.
Then, ensure that for each character required by the ransom note, the magazine has at least that many occurrences.

A brute force approach would be inefficient.
Instead, we can use a hash map (or Python’s collections.Counter) to store and compare character frequencies efficiently.

---

## 🛠️ Breakdown of Approaches

### 1️⃣ Brute Force / Naive Approach

-**Explanation:** For every character in ransomNote, loop through magazine and find a match, removing used characters.
This leads to nested iterations and repeated string operations.

- **Time Complexity:** *O(n^2) -  nested loops for character comparisons*
- **Space Complexity:** *O(1) - no additional data structures used*
- **Example/Dry Run:**

Example input: ransomNote = "aa", magazine = "aab"
Step 1 → Check for 'a' in magazine → Found
Step 2 → Remove 'a' → magazine = "ab"
Step 3 → Check for 'a' again → Found
Step 4 → Return true


### 2️⃣ Optimized Approach

- **Explanation:** Use a hash map to count how many times each letter appears in magazine.
Then, for each letter in ransomNote, check if it exists in the map with sufficient count. Decrease the count as we go

- **Time Complexity:** *O(m + n) - where m = len(magazine), n = len(ransomNote)*
- **Space Complexity:** *O(1)-because character set is fixed (26 lowercase letters)

- **Example/Dry Run:**

ransomNote = "aa", magazine = "aab"
Step 1 → magazine_counter = {'a': 2, 'b': 1}
Step 2 → Check 'a' in ransomNote → Yes (2 available) → decrement to 1
Step 3 → Check 'a' again → Yes (1 available) → decrement to 0
Step 4 → Return true


### 3️⃣ Best / Final Optimized Approach (if applicable)

- **Explanation:** * Use a hash map to count how many times each letter appears in magazine.
Then, for each letter in ransomNote, check if it exists in the map with sufficient count. Decrease the count as we go*
- **Time Complexity:** *O(m + n) - where m = len(magazine), n = len(ransomNote)*
- **Space Complexity:** *O(1) - because character set is fixed (26 lowercase letters)*
- **Example/Dry Run:**

Example input: 
ransomNote = "aa", magazine = "aab"
Step 1 → magazine_counter = {'a': 2, 'b': 1}
Step 2 → Check 'a' in ransomNote → Yes (2 available) → decrement to 1
Step 3 → Check 'a' again → Yes (1 available) → decrement to 0
Step 4 → Return true
---

## 📊 Complexity Analysis

| Approach      | Time Complexity | Space Complexity |
| ------------- | --------------- | ---------------- |
| Brute Force   | O(n^2)          | O(1)             |
| Optimized     | O(m + n)        | O(1)             |
| Best Approach | O(m + n)        | O(1)             |

---

## 📉 Optimization Ideas

Use collections.Counter in Python for cleaner syntax and built-in methods for frequency counting and subtraction.

Early exit: if len(ransomNote) > len(magazine), return False immediately.

---

## 📌 Example Walkthroughs & Dry Runs

Example:
Input: ransomNote = "abc", magazine = "aabbcc"
Process:
1 → Count magazine: {'a': 2, 'b': 2, 'c': 2}
2 → 'a' needed → OK
3 → 'b' needed → OK
4 → 'c' needed → OK
Output: true

Input: ransomNote = "aab", magazine = "abc"
Process:
1 → Count magazine: {'a': 1, 'b': 1, 'c': 1}
2 → 'a' needed → Only 1 'a' available
Output: false

---

## 🔗 Additional Resources

- collections.Counter docs
- Pythonic Solution Discussion


---

Author: Andrew
Date: 13/06/2025