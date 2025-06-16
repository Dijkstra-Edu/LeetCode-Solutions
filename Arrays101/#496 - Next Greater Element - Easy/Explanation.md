# Problem Title

**Difficulty:** *Easy*  
**Category:** *Arrays, Stack, Monotonic Stack*  
**Leetcode Link:** [Problem Link](https://leetcode.com/problems/next-greater-element-i/description/)

---

## 📝 Introduction

*Given two arrays nums1 and nums2 where nums1 is a subset of nums2, the task is to find the next greater element for each element of nums1 in nums2. <br>
The next greater element for an element x in nums2 is the first element to the right of x in nums2 that is greater than x. If it doesn’t exist, return -1 for that element.*

---

## 💡 Approach & Key Insights

*A brute-force approach would involve searching for each nums1[i] in nums2, and then scanning the rest of nums2 to find the next greater number.
However, this can be optimized using a monotonic stack and a hash map to preprocess the nums2 list and determine the next greater element for each number in one pass.*

*<b>Key observations:</b><br>
We can scan nums2 from left to right.<br>
Use a stack to keep track of decreasing elements.<br>
Whenever we find a greater number, we pop from the stack and set the mapping for the popped element.*

---

## 🛠️ Breakdown of Approaches

### 1️⃣ Brute Force / Naive Approach

- **Explanation:** *For each element in nums1, find its position in nums2, then iterate to the right of that position to find the first greater number. If none found, return -1.*
- **Time Complexity:** *O(n * m) - Where n is the length of nums1 and m is the length of nums2.*
- **Space Complexity:** *O(1) - No extra space beyond output list.*
- **Example/Dry Run:**

```plaintext
nums1 = [4, 1, 2]
nums2 = [1, 3, 4, 2]

For 4 → search in nums2 → found at index 2 → no greater number → -1
For 1 → search in nums2 → found at index 0 → 3 is greater → 3
For 2 → found at index 3 → no greater number → -1
Output: [-1, 3, -1]
```


### 2️⃣ Optimized Approach

- **Explanation:** *Use a monotonic stack to process nums2. While traversing, keep popping from the stack until the current number is greater than the stack top. Map each popped element to the current number. At the end, use the map to lookup results for nums1.*
- **Time Complexity:** *O(n + m) - We process each element of nums2 only once.*
- **Space Complexity:** *O(m) - For the hashmap and stack used to store next greater mappings.*
- **Example/Dry Run:**

```plaintext
nums1 = [4, 1, 2]
nums2 = [1, 3, 4, 2]

Stack = []
next_greater = {}

Process 1 → stack: [1]
Process 3 → 3 > 1 → pop 1 → map[1] = 3 → stack: [3]
Process 4 → 4 > 3 → pop 3 → map[3] = 4 → stack: [4]
Process 2 → 2 < 4 → stack: [4, 2]

Remaining in stack: 4, 2 → no next greater → map[4] = -1, map[2] = -1

Now build result for nums1 using map:
4 → -1
1 → 3
2 → -1

Output: [-1, 3, -1]
```

---

## 📊 Complexity Analysis

| Approach      | Time Complexity | Space Complexity |
| ------------- | --------------- | ---------------- |
| Brute Force   | O(n * m)            | O(1)             |
| Optimized     | O(n + m)            | O(m)             |

---

## 📉 Optimization Ideas

*If multiple queries need to be answered for different nums1 but the same nums2, we can reuse the precomputed next_greater mapping.<br>
This solution generalizes to "Next Greater Element II" with a circular array if needed.*

---

## 📌 Example Walkthroughs & Dry Runs


```plaintext
Input:
nums1 = [2, 4]
nums2 = [1, 2, 3, 4]

Stack trace:
1 → push
2 → push
3 > 2 → pop 2 → map[2] = 3
3 > 1 → pop 1 → map[1] = 3
→ push 3
4 > 3 → pop 3 → map[3] = 4
→ push 4

Remaining in stack → 4 → map[4] = -1

Final map: {2: 3, 1: 3, 3: 4, 4: -1}
Result for nums1 = [2, 4] → [3, -1]
```

---

## 🔗 Additional Resources

- [Resource 1](https://www.youtube.com/watch?v=68a1Dc_qVq4)
- [Resource 2](https://www.geeksforgeeks.org/dsa/stack-data-structure/)

---

Author: Daniel Nallapalli <br>
Date: 16/06/2025