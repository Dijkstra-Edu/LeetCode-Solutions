# 35. Search Insert Position

**Difficulty:** Easy  
**Category:** Arrays, Binary Search  
**Leetcode Link:** [Problem Link](https://leetcode.com/problems/search-insert-position/)

---

## 📝 Introduction

Given a sorted array of distinct integers `arr[]` and a target value `x`, determine the index of `x` in the array.  
If `x` is not present, return the index at which it should be inserted to maintain the sorted order.

---

## 💡 Approach & Key Insights

The key insight is to use Binary Search to find the index of the target element. If the element is not found, Binary Search can also help determine the correct insertion position — this is known as the “lower bound” of the target value.

- If `arr[mid] == x`, return mid.
- If `arr[mid] < x`, discard the left half.
- If `arr[mid] > x`, it could be a possible answer; store mid and continue to the left half.

This ensures an efficient O(logN) solution instead of scanning the entire array.

---

## 🛠️ Breakdown of Approaches

### 1️⃣ Brute Force / Naive Approach

- **Explanation:**  
  Linearly scan the array from the beginning. If `arr[i] >= x`, return index `i`. If no such element is found, return `n` (length of the array) — meaning `x` should be inserted at the end.

- **Time Complexity:** O(N) - May require scanning the entire array in the worst case.  
- **Space Complexity:** O(1) - No extra space used.

- **Example/Dry Run:**

```plaintext
Input: arr[] = [1, 2, 4, 7], x = 6

Step 1: Check 1 < 6 → continue  
Step 2: Check 2 < 6 → continue  
Step 3: Check 4 < 6 → continue  
Step 4: Check 7 >= 6 → return index 3

Output: 3
```

---

### 2️⃣ Optimized Approach

- **Explanation:**  
  Use Binary Search to efficiently find the first element that is greater than or equal to `x`. If such an element is found, return its index. Otherwise, return the array's length (insert at the end).

- **Time Complexity:** O(logN) - Binary search halves the search space each iteration.  
- **Space Complexity:** O(1) - Only a few pointers and variables used.

- **Example/Dry Run:**

```plaintext
Input: arr[] = [1, 2, 4, 7], x = 6

low = 0, high = 3, ans = 4

1st Iteration:
mid = 1 → arr[1] = 2 < 6 → low = 2

2nd Iteration:
mid = 2 → arr[2] = 4 < 6 → low = 3

3rd Iteration:
mid = 3 → arr[3] = 7 >= 6 → ans = 3, high = 2

Terminate → return ans = 3

Output: 3
```

---

### 3️⃣ Best / Final Optimized Approach

- **Explanation:**  
  The best solution uses the lower bound logic through binary search. This guarantees both correctness and efficiency.

- **Time Complexity:** O(logN) - Each step cuts the array in half.  
- **Space Complexity:** O(1) - No extra data structures used.

- **Example/Dry Run:**

```plaintext
Input: arr[] = [1, 2, 4, 7], x = 2

low = 0, high = 3, ans = 4

1st Iteration:
mid = 1 → arr[1] = 2 >= 2 → ans = 1, high = 0

2nd Iteration:
mid = 0 → arr[0] = 1 < 2 → low = 1

Terminate → return ans = 1

Output: 1
```

---

## 📊 Complexity Analysis

| Approach      | Time Complexity | Space Complexity |
| ------------- | --------------- | ---------------- |
| Brute Force   | O(N)            | O(1)             |
| Optimized     | O(logN)         | O(1)             |
| Best Approach | O(logN)         | O(1)             |

---

## 📉 Optimization Ideas

- The solution is already optimal using binary search.
- In languages like C++ or Python, the `lower_bound()` function from STL or `bisect.bisect_left()` from the `bisect` module can be used directly.

---

## 📌 Example Walkthroughs & Dry Runs

```plaintext
Example 1:
Input: arr[] = [1, 2, 4, 7], x = 6

Step 1 → mid = 1 → arr[1] = 2 < 6 → search right
Step 2 → mid = 2 → arr[2] = 4 < 6 → search right
Step 3 → mid = 3 → arr[3] = 7 >= 6 → candidate → search left
Output: 3

Example 2:
Input: arr[] = [1, 2, 4, 7], x = 2

Step 1 → mid = 1 → arr[1] = 2 == 2 → candidate → search left
Step 2 → mid = 0 → arr[0] = 1 < 2 → search right
Output: 1
```

---

## 🔗 Additional Resources

- [Lower Bound Explained](https://www.geeksforgeeks.org/dsa/lower-and-upper-bound-theory/)
- [Binary Search - GeeksForGeeks](https://www.geeksforgeeks.org/binary-search/)

---

Author: Abdul Wahab  
Date: 19/07/2025
