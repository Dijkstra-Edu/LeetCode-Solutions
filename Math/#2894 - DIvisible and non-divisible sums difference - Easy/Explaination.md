# Problem Title

**Difficulty:** Easy   
**Category:** Math  
**Leetcode Link:** [Problem Link](https://leetcode.com/problems/divisible-and-non-divisible-sums-difference/)

---

## 📝 Introduction

You're given two integers, n and m. Your task is to calculate the difference between:

num1: the sum of all numbers from 1 to n not divisible by m.

num2: the sum of all numbers from 1 to n divisible by m.

Return the value of num1 - num2.

---

## 💡 Approach & Key Insights

The total sum of numbers from 1 to n is known via the formula: n(n + 1) / 2.

The sum of numbers divisible by m is also a simple arithmetic series.

Subtracting 2 * (sum of numbers divisible by m) from the total sum gives us num1 - num2.



---

## 🛠️ Breakdown of Approaches

### 1️⃣ Brute Force / Naive Approach

-**Explanation:** Loop through all numbers from 1 to n. For each number:

If it is divisible by m, add to num2.

Else, add to num1.
Finally return num1 - num2.
- **Time Complexity:** *O(?) - because we loop from 1 to n.*
- **Space Complexity:** *O(?) - constant space for sums.*
- **Example/Dry Run:**

Example input: n = 10, m = 3

Loop from 1 to 10:

Not divisible by 3: 1 + 2 + 4 + 5 + 7 + 8 + 10 = 37

Divisible by 3: 3 + 6 + 9 = 18

Output: 37 - 18 = 19


### 2️⃣ Optimized Approach

- **Explanation:** Use math formulas to compute the total sum of numbers from 1 to n, and separately the sum of numbers divisible by m:

Total sum: n(n + 1) / 2

Sum divisible by m: m * k(k + 1) / 2 where k = n // m

Return: total_sum - 2 * divisible_sum
- **Time Complexity:** *O(1) - no loops, only arithmetic.*
- **Space Complexity:** *O(1) 
- **Example/Dry Run:**

Input: n = 10, m = 3

total_sum = 10 × 11 / 2 = 55

k = 10 // 3 = 3

divisible_sum = 3 × (3 × 4 / 2) = 3 × 6 = 18

Output = 55 - 2 × 18 = 19


### 3️⃣ Best / Final Optimized Approach (if applicable)

- **Explanation:** *Discuss the best possible solution.*
- **Time Complexity:** *O(?) - Explanation*
- **Space Complexity:** *O(?) - Explanation*
- **Example/Dry Run:**

Example input: [Insert example] Step 1 → Step 2 → Step 3 → Output

---

## 📊 Complexity Analysis

| Approach      | Time Complexity | Space Complexity |
| ------------- | --------------- | ---------------- |
| Brute Force   | O(n)            | O(1)             |
| Optimized     | O(1)            | O(1)             |
| Best Approach | O(?)            | O(?)             |

---

## 📉 Optimization Ideas

The optimized solution already achieves constant time and space using mathematical formulas. No further optimization is necessary unless extending to very large ranges, in which case care for integer overflow may be required.

---

## 📌 Example Walkthroughs & Dry Runs

Example:
Input: n = 5, m = 2
Total sum = 5 * 6 / 2 = 15
Divisible by 2: 2 + 4 = 6
Not divisible: 1 + 3 + 5 = 9
Answer: 9 - 6 = 3

Or:
Answer = 15 - 2 * 6 = 3
```

---

## 🔗 Additional Resources

- Arithmetic Series - Wikipedia
- Python Integer Arithmetic


---

Author: Andrew
Date: 07/06/2025