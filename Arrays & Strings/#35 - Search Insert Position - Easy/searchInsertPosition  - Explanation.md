# Problem Title

**Difficulty:** Easy  
**Category:** Binary Search, Arrays  
**Leetcode Link:** [35. Search Insert Position](https://leetcode.com/problems/search-insert-position/)

---

## 📝 Introduction

Given a sorted array of **distinct integers** and a target value, the task is to return the **index** if the target is found. If not, return the index where it **would be inserted** in order.

This is a **classic binary search** problem with a small twist — instead of just finding the element, we also handle where it would fit in if it’s not present.

---

## 💡 Approach & Key Insights

- The array is sorted — so binary search is the best tool here (O(log n) time).  
- We look for the **first position** where `nums[i] >= target`.
- If the target is greater than all elements, it should be inserted at the **end** (index = `len(nums)`).
- This ensures correct placement whether or not the target exists in the array.

---

## 🛠️ Breakdown of Approaches

### 1️⃣ Brute Force / Naive Approach

- **Explanation:**
  - Iterate through the array.
  - Return the index where `nums[i] >= target`.
  - If target is larger than all elements, return `len(nums)`.
- **Time Complexity:** O(n) — linear scan through the array.
- **Space Complexity:** O(1) — no extra memory.
- **Example/Dry Run:**

Example input: `nums = [1, 3, 5, 6], target = 2`

```
Index 0: 1 < 2 → continue
Index 1: 3 >= 2 → return 1
Output: 1
```

---

### 2️⃣ Optimized Approach

- **Explanation:**
  - Use binary search to narrow down where the element should be.
  - Maintain `left` and `right` pointers.
  - If `nums[mid] == target`, return `mid`.
  - If `nums[mid] < target`, move `left = mid + 1`.
  - Else move `right = mid - 1`.
  - When loop ends, `left` will represent the **insert position**.
- **Time Complexity:** O(log n) — binary search.
- **Space Complexity:** O(1) — constant space.
- **Example/Dry Run:**

Example input: `nums = [1, 3, 5, 6], target = 5`

```
left = 0, right = 3
mid = 1 (value = 3) → 3 < 5 → left = 2
mid = 2 (value = 5) → match → return 2
```

Output: 2

---

## 📊 Complexity Analysis

| Approach      | Time Complexity | Space Complexity |
| ------------- | --------------- | ---------------- |
| Brute Force   | O(n)            | O(1)             |
| Optimized     | O(log n)        | O(1)             |

---

## 📉 Optimization Ideas

- Using **binary search built-ins** like `bisect_left` in Python can reduce boilerplate.
- For small arrays (n < 10), linear scan may be equally efficient — but binary search is best for scalability.

---

## 📌 Example Walkthroughs & Dry Runs

```plaintext
Example 1:
nums = [1,3,5,6], target = 5
→ Found at index 2

Example 2:
nums = [1,3,5,6], target = 2
→ Insert before 3 → index 1

Example 3:
nums = [1,3,5,6], target = 7
→ Beyond all → insert at end → index 4
```

---

## 🔗 Additional Resources

- [Binary Search (GeeksforGeeks)](https://www.geeksforgeeks.org/binary-search/)
- [Python bisect module](https://docs.python.org/3/library/bisect.html)
- [Leetcode Binary Search Patterns](https://leetcode.com/explore/learn/card/binary-search/)

---

Author:   
Date: 11/11/2025

