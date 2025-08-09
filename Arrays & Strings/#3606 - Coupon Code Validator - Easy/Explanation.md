# Coupon Code Validator

**Difficulty:** Easy  
**Category:** String, Sorting, Simulation  
**Leetcode Link:** [Problem Link](https://leetcode.com/problems/coupon-code-validator/)  

---

## 📝 Introduction

We are given three arrays of length `n` describing the properties of `n` coupons:
- `code[i]`: A string representing the coupon identifier.
- `businessLine[i]`: A string denoting the business category of the coupon.
- `isActive[i]`: A boolean indicating whether the coupon is active.

A coupon is valid if:
1. `code[i]` is non-empty and contains only **alphanumeric characters** (`a-z, A-Z, 0-9`) and underscores (`_`).
2. `businessLine[i]` is one of the following: `"electronics"`, `"grocery"`, `"pharmacy"`, `"restaurant"`.
3. `isActive[i] == true`.

We must return an array of valid coupon codes, **sorted first by businessLine** in the order:
```
electronics → grocery → pharmacy → restaurant
```
and then by `code` in lexicographical ascending order **within the same category**.

---

## 💡 Approach & Key Insights

1. **Validation**:
   - Ensure `code[i]` is not empty and contains only `[a-zA-Z0-9_]`.
   - Ensure `businessLine[i]` is in the allowed categories set.
   - Ensure `isActive[i]` is `true`.

2. **Sorting**:
   - Create a custom order mapping for categories:
     ```
     electronics → 0, grocery → 1, pharmacy → 2, restaurant → 3
     ```
   - Sort first by category order, then lexicographically by code.

3. **Output**:
   - Extract and return only the coupon codes from the valid list after sorting.

---

## 🛠️ Breakdown of Approaches

### 1️⃣ Brute Force / Naive Approach

- **Explanation:**  
  Loop over all coupons, validate each one, and store valid ones in a list. Sort using default string sorting and then reorder by category.
- **Time Complexity:** O(n log n) — due to sorting.
- **Space Complexity:** O(n) — storing valid coupons.

---

### 2️⃣ Optimized Approach

- **Explanation:**  
  While validating, store valid coupons as pairs `(businessLine, code)`.  
  Sort using a custom comparator that compares category order first, then `code`.
- **Time Complexity:** O(n log n) — sorting dominates.
- **Space Complexity:** O(n) — storing valid coupons.

Example:
```
code         = ["SAVE20", "", "PHARMA5", "SAVE@20"]
businessLine = ["restaurant", "grocery", "pharmacy", "restaurant"]
isActive     = [true, true, true, true]

Valid coupons after filtering:
[("restaurant", "SAVE20"), ("pharmacy", "PHARMA5")]

After sorting by category order then code:
[("pharmacy", "PHARMA5"), ("restaurant", "SAVE20")]

Output: ["PHARMA5", "SAVE20"]
```

---

## 📊 Complexity Analysis

| Approach   | Time Complexity | Space Complexity |
| ---------- | --------------- | ---------------- |
| Validation | O(n)            | O(n)             |
| Sorting    | O(n log n)      | O(n)             |

---

## 📌 Example Walkthroughs & Dry Runs

Example 1:
```
Input:
code         = ["SAVE20", "", "PHARMA5", "SAVE@20"]
businessLine = ["restaurant", "grocery", "pharmacy", "restaurant"]
isActive     = [true, true, true, true]

Valid after filtering:
[("restaurant", "SAVE20"), ("pharmacy", "PHARMA5")]

Sorted:
[("pharmacy", "PHARMA5"), ("restaurant", "SAVE20")]

Output:
["PHARMA5", "SAVE20"]
```

Example 2:
```
Input:
code         = ["GROCERY15", "ELECTRONICS_50", "DISCOUNT10"]
businessLine = ["grocery", "electronics", "invalid"]
isActive     = [false, true, true]

Valid after filtering:
[("electronics", "ELECTRONICS_50")]

Output:
["ELECTRONICS_50"]
```

---

## 🔗 Additional Resources

- [Regular Expressions in Java](https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html)
- [Python: all() function](https://docs.python.org/3/library/functions.html#all)
- [C++ isalnum function](https://www.cplusplus.com/reference/cctype/isalnum/)

---

Author: Kailash Senthilkumar  
Date: 09/08/2025  
