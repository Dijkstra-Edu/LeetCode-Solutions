# 🚀 Problem 50: Power (x, n)

**Difficulty:** Medium  
**Category:** Math  
**Leetcode Link:** [https://leetcode.com/problems/powx-n/](https://leetcode.com/problems/powx-n/)

---

### 📝 Introduction

Implement the function `pow(x, n)`, which computes `x` raised to the power `n` (i.e., `xⁿ`) without using built-in functions like `pow()`.  
Constraints include:
- The exponent `n` can be negative.
- You must handle large powers efficiently.
- Result should be a double.

---

### 💡 Approach & Key Insights

At first, this seems straightforward — just multiply `x` by itself `n` times. However, such a naive approach fails on large values of `n` due to time constraints.  

The optimized solution uses **Binary Exponentiation**, which brings the time complexity down to **O(log n)** by reducing the number of multiplications required.

We also need to handle edge cases like:
- Any number to the power of 0 is 1.
- 1 raised to any power is 1.
- Negative exponents require us to take the reciprocal (`x^-n = 1 / x^n`).

---

### 🛠️ Breakdown of Approaches

---

#### 1️⃣ Brute Force / Naive Approach

**Explanation:**  
Multiply `x` by itself `n` times using a loop.

```c
double myPow(double x, int n) {
    double result = 1;
    for (int i = 0; i < n; i++) {
        result *= x;
    }
    return result;
}
```

**Time Complexity:** O(n) — Each multiplication is done one by one.  
**Space Complexity:** O(1) — No extra space except result variable.

**Example / Dry Run:**

Input: `x = 2`, `n = 4`  
Steps:  
2 × 2 = 4 → 4 × 2 = 8 → 8 × 2 = 16  
**Output:** `16`

*⚠️ This approach fails for large `n` due to TLE on LeetCode.*

---

#### 2️⃣ Optimized Approach — Binary Exponentiation

**Explanation:**  
We use the property of powers:

- If `n` is even:  
  `xⁿ = (x^(n/2))²`
- If `n` is odd:  
  `xⁿ = x × xⁿ⁻¹`

We convert `n` to a **positive long long** if it's negative and take the **reciprocal** at the end for negative exponents.

**Edge Cases to Handle:**
- `x^0 = 1`
- `1^n = 1`
- `x^-n = 1 / x^n`

**C Code Snippet:**

```c
double myPow(double x, int n) {
    long long z = n;
    double result = 1.0;

    if (z < 0) {
        x = 1 / x;
        z = -z;
    }

    while (z > 0) {
        if (z % 2 == 1) {
            result *= x;
            z--;
        } else {
            x *= x;
            z /= 2;
        }
    }

    return result;
}
```

**Time Complexity:** O(log n) — At each step, we reduce the exponent by half.  
**Space Complexity:** O(1) — Just a few variables.

**Example / Dry Run:**

Input: `x = 2`, `n = 8`  
Steps:
- 2^8 = (2^4)^2  
- 2^4 = (2^2)^2  
- 2^2 = (2^1)^2  
- 2^1 = 2  

So:  
2 → 4 → 16 → 256  
**Output:** `256`

---

### 📊 Complexity Analysis

| Approach         | Time Complexity | Space Complexity |
|------------------|------------------|-------------------|
| Brute Force      | O(n)             | O(1)              |
| Optimized        | O(log n)         | O(1)              |

---

### 📉 Optimization Ideas

- Ensure you're casting `n` to `long long` when handling `INT_MIN`, since `-INT_MIN` would overflow in 32-bit int.
- Use **bit manipulation** if desired (e.g., `z >> 1` instead of `z / 2`) for micro-optimizations.

---

### 📌 Example Walkthroughs & Dry Runs

**Example 1:**
```
Input: x = 2, n = 5

Step 1: 2^5 = 2 * 2^4
Step 2: 2^4 = (2^2)^2 = (4)^2 = 16
Step 3: Result = 2 * 16 = 32
Output: 32
```

**Example 2:**
```
Input: x = 2.0, n = -3

Step 1: Invert x → x = 1 / 2.0 = 0.5, n = 3
Step 2: 0.5^3 = 0.5 * 0.5^2
Step 3: 0.5^2 = (0.5)^2 = 0.25
Step 4: 0.5 * 0.25 = 0.125
Output: 0.125
```

---

### 🔗 Additional Resources

- [Power(x, n) - NeetCode Video](https://www.youtube.com/watch?v=l0YC3876qxg)
- [Binary Exponentiation - CP Algorithms](https://cp-algorithms.com/algebra/binary-exp.html)
- [Understanding Power Function - GeeksForGeeks](https://www.geeksforgeeks.org/write-a-c-program-to-calculate-powxn/)

---

**Author:** hanzel-sc

**Date:** 07/07/2025
