#Plain Recursion
class Solution:
    def recur(self, ind, amount, coins):
        if ind == 0:
            return amount // coins[0] if amount % coins[0] == 0 else int(1e9)
        take = int(1e9)
        if amount >= coins[ind]:
            take = 1 + self.recur(ind, amount - coins[ind], coins)
        notTake = self.recur(ind - 1, amount, coins)
        return min(take, notTake)

    def coinChange(self, coins, amount):
        n = len(coins)
        minCoins = self.recur(n-1, amount, coins)
        return -1 if minCoins == int(1e9) else minCoins
#Time Limit Exceeded (TLE) for large inputs

#Recursion with Memoization
class Solution:
    def coinChange(self, coins, amount):
        n = len(coins)
        dp = [[-1]*(amount+1) for _ in range(n)]
        for i in range(n):
            dp[i][0] = 0

        def recur(ind, amt):
            if ind == 0:
                return amt // coins[0] if amt % coins[0] == 0 else int(1e9)
            if dp[ind][amt] != -1:
                return dp[ind][amt]
            take = int(1e9)
            if coins[ind] <= amt:
                take = 1 + recur(ind, amt - coins[ind])
            notTake = recur(ind-1, amt)
            dp[ind][amt] = min(take, notTake)
            return dp[ind][amt]

        res = recur(n-1, amount)
        return -1 if res == int(1e9) else res
'''
    Runtime: 965 ms
    Memory Usage: 46.32 MB
    Time Complexity : O(n*t)
'''

#Tabulation
class Solution:
    def coinChange(self, coins, amount):
        n = len(coins)
        dp = [[int(1e9)]*(amount+1) for _ in range(n)]

        for i in range(amount+1):
            if i % coins[0] == 0:
                dp[0][i] = i // coins[0]
        for i in range(n):
            dp[i][0] = 0

        for i in range(1, n):
            for j in range(1, amount+1):
                notTake = dp[i-1][j]
                take = 1 + dp[i][j-coins[i]] if coins[i] <= j else int(1e9)
                dp[i][j] = min(take, notTake)

        return -1 if dp[n-1][amount] == int(1e9) else dp[n-1][amount]
'''
    Runtime: 878 ms
    Memory Usage: 19.55 MB
    Time Complexity : O(n*t)
'''

#Space Optimized Tabulation
class Solution:
    def coinChange(self, coins, amount):
        n = len(coins)
        prev = [int(1e9)]*(amount+1)
        curr = [int(1e9)]*(amount+1)

        for i in range(amount+1):
            if i % coins[0] == 0:
                prev[i] = i // coins[0]
        prev[0] = 0

        for i in range(1, n):
            curr[0] = 0
            for j in range(1, amount+1):
                notTake = prev[j]
                take = 1 + curr[j-coins[i]] if coins[i] <= j else int(1e9)
                curr[j] = min(take, notTake)
            prev = curr[:]

        return -1 if prev[amount] == int(1e9) else prev[amount]
'''
    Runtime: 754 ms
    Memory Usage: 18.34 MB
    Time Complexity : O(n*t)
'''

#1D Tabulation
class Solution:
    def coinChange(self, coins, amount):
        coins.sort()
        dp = [int(1e9)]*(amount+1)
        dp[0] = 0

        for i in range(1, amount+1):
            for c in coins:
                if c > i:
                    break
                dp[i] = min(dp[i], dp[i-c]+1)

        return -1 if dp[amount] == int(1e9) else dp[amount]
'''
    Runtime: 679 ms
    Memory Usage: 17.98 MB
    Time Complexity : O(n*t)
'''


