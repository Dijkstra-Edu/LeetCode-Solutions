# 1021. Remove Outermost Parentheses

**Difficulty:** *Easy*  
**Category:** *Strings, Stack, Greedy*  
**Leetcode Link:** [Problem Link](https://leetcode.com/problems/remove-outermost-parentheses/)

---

## 📝 Introduction

*Given a valid parentheses string, the task is to remove the outermost parentheses of every primitive substring. A primitive string is a non-empty valid parentheses string that cannot be split further into valid parts.*

---

## 💡 Approach & Key Insights

*Each primitive parentheses string is balanced and starts/ends with outermost parentheses. If we track the nesting level using a counter, we can easily identify the start and end of each primitive and skip appending the outermost layer.*

---

## 🛠️ Breakdown of Approaches

### 1️⃣ Brute Force / Naive Approach

- **Explanation:** *Use a stack to build substrings for each primitive, detect primitives by ensuring stack becomes empty, then remove the first and last characters.*
- **Time Complexity:** *O(n²) - Substring operations inside loop.*
- **Space Complexity:** *O(n) - For temporary stack and result string.*
- **Example/Dry Run:**

Example input: "(()())(())"  
Step 1 → Extract primitives: "(()())", "(())"  
Step 2 → Remove outermost: "()()", "()"  
Step 3 → Output: "()()()"

### 2️⃣ Optimized Approach

- **Explanation:** *Use a counter to track the nesting depth. While iterating, append characters only if they’re not the outermost (i.e., depth > 1 before ‘)’ or after ‘(’).*
- **Time Complexity:** *O(n) - Single pass over string.*
- **Space Complexity:** *O(n) - For output string.*
- **Example/Dry Run:**

Example input: "(()())(())"  
Step 1 → Traverse:
- ‘(’: depth becomes 1 → don’t add  
- ‘(’: depth becomes 2 → add ‘(’  
- ‘)’: depth becomes 1 → add ‘)’  
- ‘)’: depth becomes 0 → don’t add  
... and so on  
Output: "()()()"

---

## 📊 Complexity Analysis

| Approach      | Time Complexity | Space Complexity |
| ------------- | --------------- | ---------------- |
| Brute Force   | O(n²)           | O(n)             |
| Optimized     | O(n)            | O(n)             |

---

## 📉 Optimization Ideas

*The optimized solution is already linear in time and space. Further improvement would require in-place modification or custom output building if language permits.*

---

## 📌 Example Walkthroughs & Dry Runs

```plaintext
Example:
Input: "(()())(())(()(()))"
Process:
Primitive 1: "(()())" → Output: "()()"
Primitive 2: "(())" → Output: "()"
Primitive 3: "(()(()))" → Output: "()(())"
Final Output: "()()()()(())"
```

---

## 🔗 Additional Resources

- [Stack Data Structure](https://en.wikipedia.org/wiki/Stack_(abstract_data_type))
- [Valid Parentheses Leetcode](https://leetcode.com/problems/valid-parentheses/)

---

Author: Abdul Wahab  
Date: 19/07/2025
