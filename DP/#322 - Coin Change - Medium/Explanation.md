# 494. Target Sum

**Difficulty:** Medium  
**Category:** Arrays, Dynamic Programming, Recursion  
**Leetcode Link:** [Problem Link](https://leetcode.com/problems/coin-change)

---

## 📝 Introduction

You are given an integer array coins representing `coins` of different denominations and an integer `amount` representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return `-1.`

You may assume that you have an infinite number of each kind of coin.

---

## 💡 Approach & Key Insights

This problem can be solved by generating all possible combinations using recursion. However, recursion without memoization can severely impact the time complexity of the problem and can exceed the time limit for most of the cases.

---

## 🛠️ Breakdown of Approaches

### 1️⃣ Recursion with memoization

- **Explanation:**  
  For every coin in the array, there are two choices:
  - either pick the coin, which will reduce the amount by the coin's denomination. Since the coin can be picked multiple times, we will continue this process until the amount becomes smaller than the coin's denomination. 
  - or don't pick the coin, in this case the amount remains the same but we move on to the next coin without considering the current coin. 
  The minimum possible coin would be minimum of `pick + 1` and `notPick`. There are certain base cases to be noted, if amount is 0, then 0 is returned, and if amount is not attainable, infinity (or a very large number) is returned.
  The returned values are stored in a 2D table for memoization, with the rows representing the coins and the columns representing amount from `0` to `amount`.  

- **Time Complexity:** O(N * T)  
  Where `N` is the number of coins and `T` is the amount to be obtained.

- **Space Complexity:** O(N * T) + O(N)  
  For storing 2D DP memoization and for the auxiliary stack space.


---

### 2️⃣ Tabulation

- **Explanation:**  
  In order to remove the auxiliary stack space and the unecessary backtracking, we can use a top-down approach using tabulation. The first column of the 2D array is enumerated with `0`'s and the first row filled with `amount/coins[0]` where amount is divisible by coins[0] valid otherwise it is filled with infinity. The rest of the cells can be filled with the minimum vakue between `dp[i][j-coins[i]] + 1` and `dp[i-1][j]` where dp is the 2D tabulation, i is the row of the cell and j is the column of the cell.

- **Time Complexity:** O(N * T)  
  For iterating for every row and column of the table.

- **Space Complexity:** O(N * T)  
  For storing the table.

---

### 3️⃣ Space Optimized Tabulation

- **Explanation:**  
  Since at a time only two rows are utilized for the tabulation code, we can use just two rows for the storage of the tabulation data, First initialize a `prev` array to store the initial values for 1 coin, and a `curr` array to be filled. After `curr` is filled, it is swapped with `prev`. The final value is stored at the end of the `prev` array after iterating for all the coins.

- **Time Complexity:** O(N * T)  
  For iterating over N coins for T amount.

- **Space Complexity:** O(T)  
  For using a 1D array to store values.


---

### 4️⃣ 1D Tabulation

- **Explanation:**  
  The problem can be solved by using a single 1D tabulation array where `dp[i]` stores the minimum number of coins to attain `i` amount. For each `i` in `dp`, `dp[i]` is the minimum `dp[i-1]` and `dp[i-coins[j]+1` for `j` represent the index of the coin in `coins` array for all coins in the array. The last element of the array holds the final answer.

- **Time Complexity:** O(N * T)  
  To iterate over all coins for all amounts in the given range.

- **Space Complexity:** O(T)  
  To store 1D tabulation.


---

## 📊 Complexity Analysis

| Approach                | Time Complexity           | Space Complexity       |
| ----------------------- | ------------------------- | ---------------------- |
| Memoization             | O(N * T) + O(N)           | O(N * T)               |
| Tabulation              | O(N * T)                  | O(N * T)               |
| Optimized Tabulation    | O(N* T)                   | O(T)                   |
| 1D Tabulation           | O(N * T)                  | O(T)                   |

---

## 📉 Optimization Ideas

- Go for a top-down approach instead of a top dowon one.
- Prefer 1D tabulation over 2D table.

---

## 📌 Example Walkthroughs & Dry Runs

plaintext
Example:
Input: coins = [1,2,5], amount = 11
Iterating for all elements of the dp array where dp[i] repressents minimum number of coins to attain i amount
- dp = [0,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1]
- dp = [0,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1]
- dp = [0,1,2,-1,-1,-1,-1,-1,-1,-1,-1,-1]
- dp = [0,1,2,2,-1,-1,-1,-1,-1,-1,-1,-1]
- dp = [0,1,1,2,2,-1,-1,-1,-1,-1,-1,-1]
- dp = [0,1,1,2,2,1,-1,-1,-1,-1,-1,-1]
- dp = [0,1,1,2,2,1,2,-1,-1,-1,-1,-1]
- dp = [0,1,1,2,2,1,2,2,-1,-1,-1,-1]
- dp = [0,1,1,2,2,1,2,2,3,-1,-1,-1]
- dp = [0,1,1,2,2,1,2,2,3,3,-1,-1]
- dp = [0,1,1,2,2,1,2,2,3,3,2,-1]
- dp = [0,1,1,2,2,1,2,2,3,3,2,3]


Output: 3

---

## 🔗 Additional Resources

- [GeeksForGeeks Explanation](https://www.geeksforgeeks.org/dsa/coin-change-dp-7/)

---

Author: Vatsal Ojha 
Date: 27/07/2025
