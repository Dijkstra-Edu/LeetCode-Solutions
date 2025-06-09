# 506. Relative Ranks

**Difficulty:** *Easy*  
**Category:** *Array, Sorting, Heap (Priority Queue)*  
**Leetcode Link:** https://leetcode.com/problems/relative-ranks/description/

---

## 📝 Introduction

*In this problem, we are given an integer array score of size n, where score[i] is the score of the ith athlete in a competition. All the scores are guaranteed to be unique.*

*The athletes are placed based on their scores, where the 1st place athlete has the highest score, the 2nd place athlete has the 2nd highest score, and so on. The placement of each athlete determines their rank:*

*The 1st place athlete's rank is "Gold Medal". <br>
The 2nd place athlete's rank is "Silver Medal". <br>
The 3rd place athlete's rank is "Bronze Medal". <br>
For the 4th place to the nth place athlete, their rank is their placement number (i.e., the xth place athlete's rank is "x").*

*We have to return an array answer of size n where answer[i] is the rank of the ith athlete.*

---

## 💡 Approach & Key Insights

*Step 1: Pair each score with its index. <br>
Step 2: Prepare a result list. <br>
Step 3: Assign ranks and medals. <br>
Step 4: Set the correct rank string in the result. <br>
Step 5: Return the final result.*

---

## 🛠️ Breakdown of Approach Used

### Optimized Approach

- **Explanation:** *Uses a single sort operation to get rankings → O(n log n). <br>
Maintains original indices to efficiently assign ranks without reshuffling. <br>
Clean, one-pass ranking assignment after sorting.*
- **Time Complexity:** * O(n×k) — Fast and scalable for large input.*
- **Space Complexity:** *O(1) - Constant auxiliary space.*
- **Example/Dry Run:** 
![alt text](Submissions.png)

Example Input: ["Hello","Alaska","Dad","Peace"] <br>
Output: ["Alaska","Dad"]



---

Author: Daniel Nallapalli <br>
Date: 9th June 2025