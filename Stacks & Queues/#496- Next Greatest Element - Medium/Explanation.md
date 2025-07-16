# 496. Next Greater Element I

**Difficulty:** Easy  
**Category:** Stack, Hash Map, Arrays  
**Leetcode Link:** [Problem Link](https://leetcode.com/problems/next-greater-element-i/description/)

---

## 📝 Introduction

Given two arrays `nums1` and `nums2` where `nums1` is a subset of `nums2`, for each element in `nums1`, find the next greater element in `nums2`.  
The next greater element of x in `nums2` is the first greater element to the right of x in the same array. If it doesn’t exist, return -1.

---

## 💡 Approach & Key Insights

- Use a stack to find the next greater element for every number in `nums2` efficiently.
- Store the result in a hash map so we can answer each query from `nums1` in constant time.
- This problem leverages the monotonic decreasing stack pattern.

---

## 🛠️ Breakdown of Approaches

### 1️⃣ Brute Force / Naive Approach

- **Explanation:** For each element in `nums1`, search for its index in `nums2` and iterate to the right to find the next greater element.
- **Time Complexity:** O(m * n) - where m = length of nums1, n = length of nums2
- **Space Complexity:** O(1) - no extra space used
- **Example/Dry Run:**

Example input: nums1 = [4,1,2], nums2 = [1,3,4,2]  
→ 4: found at index 2, no greater element → -1  
→ 1: index 0 → next greater is 3  
→ 2: index 3 → no greater → -1  
Output: [-1, 3, -1]

### 2️⃣ Optimized Approach

- **Explanation:**  
  1. Iterate over nums2 in reverse.  
  2. Use a stack to keep track of next greater elements.  
  3. Store each number’s NGE in a hashmap.  
  4. Lookup each element in nums1 using the hashmap.
- **Time Complexity:** O(n + m) - where n = len(nums2), m = len(nums1)
- **Space Complexity:** O(n) - for stack and hashmap
- **Example/Dry Run:**

Example input: nums1 = [2,4], nums2 = [1,2,3,4]  
Stack build →  
→ 4 → stack: [] → map[4] = -1  
→ 3 → stack: [4] → map[3] = 4  
→ 2 → stack: [3] → map[2] = 3  
→ 1 → stack: [2] → map[1] = 2  
Now lookup:  
→ 2 → 3  
→ 4 → -1  
Output: [3, -1]

---

## 📊 Complexity Analysis

| Approach      | Time Complexity | Space Complexity |
| ------------- | --------------- | ---------------- |
| Brute Force   | O(m * n)        | O(1)             |
| Optimized     | O(n + m)        | O(n)             |

---

## 📉 Optimization Ideas

- The stack-based approach is already optimal.
- Further improvement is only possible if input constraints change.

---

## 📌 Example Walkthroughs & Dry Runs

```plaintext
Example:
nums1 = [2, 4]
nums2 = [1, 2, 3, 4]

Stack Process:
Start from right:  
- 4 → NGE = -1  
- 3 → NGE = 4  
- 2 → NGE = 3  
- 1 → NGE = 2

Hashmap: {1:2, 2:3, 3:4, 4:-1}

Result: [3, -1]
```

---

## 🔗 Additional Resources

- [Stack approach explained visually](https://www.youtube.com/watch?v=68a1Dc_qVq4)
- [Monotonic Stack Pattern](https://leetcode.com/tag/monotonic-stack/)

---

Author: Abdul Wahab  
Date: 19/07/2025
