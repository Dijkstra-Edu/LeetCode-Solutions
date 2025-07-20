# 152. Maximum Product Subarray

**Difficulty:** Medium  
**Category:** Arrays, Dynamic Programming  
**Leetcode Link:** [Problem Link](https://leetcode.com/problems/maximum-product-subarray/)

---

## 📝 Introduction

Given an integer array `nums`, find a contiguous non-empty subarray within the array that has the largest product, and return the product.

The problem requires handling negative numbers and zeros, which can disrupt the product and reset subarrays. A subarray must be contiguous, and the result must be the largest product among all possible subarrays.

Constraints:
- 1 <= nums.length <= 2 * 10⁴  
- -10 ≤ nums[i] ≤ 10  
- The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

---

## 💡 Approach & Key Insights

To solve this problem, we evaluate various approaches:

- Brute-force: Try all subarrays and compute their products.
- Optimized: Observe properties of negative numbers and zeros.
- Best: Use a modified version of Kadane’s algorithm that tracks both max and min products to handle sign flips.

Key observations:
- Positive product → Keep multiplying.
- Negative product → Might become maximum when multiplied with another negative.
- Zeros → Break the subarray and reset.

---

## 🛠️ Breakdown of Approaches

### 1️⃣ Brute Force / Naive Approach

- **Explanation:**  
  Generate all possible subarrays using two nested loops. For each subarray, calculate the product of its elements. Keep track of the maximum product seen so far.

- **Time Complexity:** O(N²) - N starting points and N subarray lengths  
- **Space Complexity:** O(1) - No extra space used beyond variables

- **Example/Dry Run:**

Example input: [2, 3, -2, 4]  
Subarrays:
- [2] → 2
- [2, 3] → 6
- [2, 3, -2] → -12
- [3, -2] → -6
- [-2, 4] → -8  
Max = 6

---

### 2️⃣ Optimized Approach

- **Explanation:**  
  Based on the number of negative elements:
  - If all positives → result is the product of entire array.
  - If even number of negatives → product of entire array is positive.
  - If odd number of negatives → remove one negative (either from start or end) to make the product positive.

  Handle 0s by splitting the array into subarrays and applying the above logic on each.

- **Algorithm:**
  - Loop through the array, tracking prefix and suffix products.
  - Reset the prefix/suffix product to 1 when hitting zero.
  - Track the maximum of all such segment products.

- **Time Complexity:** O(N) - Single pass  
- **Space Complexity:** O(1) - Only scalar variables used

- **Example/Dry Run:**

Input: [-2, 3, 4, -1, 0, -2, 3, 1, 4, 0, 4, 6, -1, 4]  
Break on zeros → {[−2,3,4,−1], [−2,3,1,4], [4,6,−1,4]}  
Apply logic on each subarray  
Answer = max of all segment max products

---

### 3️⃣ Best / Final Optimized Approach (Kadane-style)

- **Explanation:**  
  Track the maximum and minimum product ending at the current index. Negative numbers can flip max to min and vice versa. This ensures handling of alternating signs.

- **Algorithm:**
  - Initialize prod1 = prod2 = result = nums[0]
  - Traverse the array from index 1:
    - temp = max(current, current × prod1, current × prod2)
    - prod2 = min(current, current × prod1, current × prod2)
    - prod1 = temp
    - result = max(result, prod1)

- **Time Complexity:** O(N) - Single loop  
- **Space Complexity:** O(1) - Constant number of variables

- **Example/Dry Run:**

Input: [1, 2, -3, 0, -4, -5]  
Step 1: prod1 = prod2 = result = 1  
i = 1: nums[i] = 2 → temp = max(2, 2×1, 2×1) = 2  
→ prod1 = 2, prod2 = 2, result = 2  
i = 2: nums[i] = -3 → temp = max(-3, -6, -6) = -3  
→ prod1 = -3, prod2 = -6, result = 2  
i = 3: nums[i] = 0 → temp = 0 → reset  
i = 4: nums[i] = -4 → etc.  
Final result: 20

---

## 📊 Complexity Analysis

| Approach      | Time Complexity | Space Complexity |
| ------------- | --------------- | ---------------- |
| Brute Force   | O(N²)           | O(1)             |
| Optimized     | O(N)            | O(1)             |
| Best Approach | O(N)            | O(1)             |

---

## 📉 Optimization Ideas

- Use rolling variables instead of arrays to track max/min products.
- Restart subarray product after encountering 0 to ensure correct segmentation.
- Can further optimize by using prefix/suffix scans with early exits.

---

## 📌 Example Walkthroughs & Dry Runs

plaintext
Example:
Input: [2, 3, -2, 4]
Process:
→ 2 → max = 2
→ 2×3 = 6 → max = 6
→ 6×(-2) = -12 → becomes min
→ restart with 4 → max = 6
Output: 6

Another:
Input: [1, 2, -3, 0, -4, -5]
→ Subarray after 0 = [-4, -5] → product = 20
Output: 20

---

## 🔗 Additional Resources

- [Kadane’s Algorithm for Maximum Sum](https://en.wikipedia.org/wiki/Maximum_subarray_problem)

---

Author: Abdul Wahab  
Date: 19/07/2025
