# 2894. Divisible And Non-divisible Sums Difference

**Difficulty:** *Easy*  
**Category:** *Math*  
**Leetcode Link:** https://leetcode.com/problems/divisible-and-non-divisible-sums-difference/description/

---

## 📝 Introduction

*In this problem, we are given two integers (n,m).
Then, we are asked to define the two integers as follows:*

*num1: The sum of all integers in the range [1, n] (both inclusive) that are not divisible by m. <br> 
num2: The sum of all integers in the range [1, n] (both inclusive) that are divisible by m.*

*Finally, we are asked to return the integer obtained after calculating (num1 - num2).*

---

## 💡 Approach & Key Insights

*Step 1: Create a function that takes two positive integers. <br>
Step 2: Compute the total sum from 1 to n. <br>
Step 3: Count how many numbers from 1 to n are divisible by m. <br>
Step 4: Calculate the sum of numbers divisible by m. <br>
Step 5: Return the difference.*

---

## 🛠️ Breakdown of Approach Used

### Optimized Approach

- **Explanation:** *Here, we use mathematical formulas and avoid loops completely.*
- **Time Complexity:** *O(1) - Constant time regardless of input size.*
- **Space Complexity:** *O(1) - Constant space regardless of input size.*
- **Example/Dry Run:** 
![alt text](Submissions.png)

Example Input: 10, 3. <br>
Output: 19



---

Author: Daniel Nallapalli <br>
Date: 9th June 2025