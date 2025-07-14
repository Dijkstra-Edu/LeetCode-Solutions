# 151. Reverse Words in a String

**Difficulty:** *Easy*  
**Category:** *Strings, Stack, Two Pointers*  
**Leetcode Link:** [Problem Link](https://leetcode.com/problems/reverse-words-in-a-string/)

---

## 📝 Introduction

Given a string `s`, reverse the order of words in it. A word is defined as a sequence of non-space characters. The words in `s` are separated by one or more spaces. The output string should only contain a single space separating the words, and no leading or trailing spaces.

---

## 💡 Approach & Key Insights

The main idea is to reverse the order of the words, not the characters within them. We explore multiple approaches starting from brute force using a stack to a space-optimized method that constructs the result while traversing the string from the end.

---

## 🛠️ Breakdown of Approaches

### 1️⃣ Brute Force / Naive Approach

- **Explanation:**  
  Push each word onto a stack while traversing the string. This reverses the order naturally. Then pop from the stack and build the output string. Stack ensures LIFO behavior to reverse the word order.
  
- **Time Complexity:** *O(N)* - We traverse the entire string once and then build the result string from the stack.  
- **Space Complexity:** *O(N)* - Additional space for the stack and the answer string.

- **Example/Dry Run:**

```plaintext
Input: "TUF is great for interview preparation"

Step 1 → Push each word into a stack:
Stack = ["TUF", "is", "great", "for", "interview", "preparation"]

Step 2 → Pop and build answer:
"preparation interview for great is TUF"

Output: "preparation interview for great is TUF"
```

---

### 2️⃣ Optimized Approach

- **Explanation:**  
  Traverse the string from the end, constructing each word in reverse. Append each complete word to the result as we detect spaces. This eliminates the need for a stack. We carefully manage whether a space is needed before appending each word.

- **Time Complexity:** *O(N)* - Single traversal of the string.  
- **Space Complexity:** *O(1)* - We only use a few extra variables (not counting the output string).

- **Example/Dry Run:**

```plaintext
Input: "TUF is great for interview preparation"

Step 1 → Start from end:
"preparation" → add to result  
"interview" → prepend to result  
"for" → prepend  
"great" → prepend  
"is" → prepend  
"TUF" → prepend

Final Output: "preparation interview for great is TUF"
```

---

### 3️⃣ Best / Final Optimized Approach (if applicable)

- **Explanation:**  
  The two-pointer approach traverses from end to start, building words and appending them to the result string efficiently. It avoids stack overhead and minimizes space usage.

- **Time Complexity:** *O(N)*  
- **Space Complexity:** *O(1)* (excluding result string)

- **Example/Dry Run:**

```plaintext
Input: "  Hello   World  "

Trim extra spaces  
Traverse from the end  
Build each word and append  
Final Output: "World Hello"
```

---

## 📊 Complexity Analysis

| Approach      | Time Complexity | Space Complexity |
| ------------- | --------------- | ---------------- |
| Brute Force   | O(N)            | O(N)             |
| Optimized     | O(N)            | O(1)             |
| Best Approach | O(N)            | O(1)             |

---

## 📉 Optimization Ideas

- Modify the input string in-place if mutable (e.g., using character arrays in C++).
- Skip multiple spaces early using regex or manual trimming.

---

## 📌 Example Walkthroughs & Dry Runs

```plaintext
Example:
Input: "TUF is great for interview preparation"
Process:
1. Extract words: ["TUF", "is", "great", "for", "interview", "preparation"]
2. Reverse order: ["preparation", "interview", "for", "great", "is", "TUF"]
3. Join with single spaces
Output: "preparation interview for great is TUF"
```

---

## 🔗 Additional Resources


- [C++ String Functions](https://cplusplus.com/reference/string/string/)

---

Author: Abdul Wahab  
Date: 19/07/2025
