# 383. Ransom Note

**Difficulty:** *Easy*  
**Category:** *Hash Table, String, Counting*  
**Leetcode Link:** https://leetcode.com/problems/ransom-note/description/

---

## 📝 Introduction

*In this problem, we are given two strings ransomNote and magazine, and we have to return 'true' if ransomNote can be constructed by using the letters from magazine and 'false' otherwise.*

*Note: Each letter in magazine can only be used once in ransomNote.*

---

## 💡 Approach & Key Insights

*Step 1: Count characters in ransomNote. <br>
Step 2: Count characters in magazine. <br>
Step 3: Check if each character in ransomNote is available in magazine. <br>
Step 4: Compare required count with available count. <br>
Step 5: If all characters are sufficiently available, return True, else False.*

---

## 🛠️ Breakdown of Approache Used

### Optimized Approach

- **Explanation:** *Here we use Python's Counter (a hash map / dictionary) to count frequencies in O(n + m) time. Then we check for each character in ransomNote whether there are enough occurrences in magazine.*
- **Time Complexity:** *O(n+m) - Linear time based on the input sizes.*
- **Space Complexity:** *O(1) - Constant space if the alphabet is limited (lowercase letters).*
- **Example/Dry Run:** 
![alt text](Submissions.png)

Example Input: a, b. <br>
Output: false



---

Author: Daniel Nallapalli <br>
Date: 9th June 2025