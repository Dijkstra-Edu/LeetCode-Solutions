//Plain Recursion
class Solution {
    private int recur(int ind, int amount, int[] coins) {
        if (ind == 0) {
            if (amount % coins[0] == 0) return amount / coins[0];
            else return (int)1e9;
        }
        int take = (int)1e9;
        if (amount >= coins[ind]) {
            take = recur(ind, amount - coins[ind], coins) + 1;
        }
        int notTake = recur(ind - 1, amount, coins);
        return Math.min(take, notTake);
    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int minCoins = recur(n - 1, amount, coins);
        return minCoins == (int)1e9 ? -1 : minCoins;
    }
}
//Time Limit Exceeded (TLE) for large inputs

//Recursion with Memoization
class Solution {
    int[][] dp;

    private int recur(int ind, int amount, int[] coins) {
        if (ind == 0) {
            return (amount % coins[0] == 0) ? amount / coins[0] : (int)1e9;
        }
        if (dp[ind][amount] != -1) return dp[ind][amount];

        int take = (int)1e9;
        if (amount >= coins[ind]) {
            take = 1 + recur(ind, amount - coins[ind], coins);
        }
        int notTake = recur(ind - 1, amount, coins);

        return dp[ind][amount] = Math.min(take, notTake);
    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        dp = new int[n][amount + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        for (int i = 0; i < n; i++) dp[i][0] = 0;

        int minCoins = recur(n - 1, amount, coins);
        return minCoins == (int)1e9 ? -1 : minCoins;
    }
}
/*
    Runtime: 27 ms
    Memory Usage: 45.80 MB
    Time Complexity : O(n*t)
*/

//Tabulation
class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for (int[] row : dp) Arrays.fill(row, (int)1e9);

        for (int i = 0; i <= amount; i++) 
            if (i % coins[0] == 0) dp[0][i] = i / coins[0];
        for (int i = 0; i < n; i++) dp[i][0] = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= amount; j++) {
                int notTake = dp[i-1][j];
                int take = (coins[i] <= j) ? 1 + dp[i][j - coins[i]] : (int)1e9;
                dp[i][j] = Math.min(take, notTake);
            }
        }
        return dp[n-1][amount] == (int)1e9 ? -1 : dp[n-1][amount];
    }
}

/*
    Runtime: 18 ms
    Memory Usage: 45.63 MB
    Time Complexity : O(n*t)
*/

//Space Optimizzed Tabulation
class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] prev = new int[amount+1];
        int[] curr = new int[amount+1];
        Arrays.fill(prev, (int)1e9);
        Arrays.fill(curr, (int)1e9);

        for (int i = 0; i <= amount; i++) 
            if (i % coins[0] == 0) prev[i] = i / coins[0];
        prev[0] = 0;

        for (int i = 1; i < n; i++) {
            curr[0] = 0;
            for (int j = 1; j <= amount; j++) {
                int notTake = prev[j];
                int take = (coins[i] <= j) ? 1 + curr[j - coins[i]] : (int)1e9;
                curr[j] = Math.min(take, notTake);
            }
            prev = curr.clone();
        }
        return prev[amount] == (int)1e9 ? -1 : prev[amount];
    }
}
/*
    Runtime: 17 ms
    Memory Usage: 45.14 MB
    Time Complexity : O(n*t)
*/

//1D Tabulation
class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] dp = new int[amount+1];
        Arrays.fill(dp, (int)1e9);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int c : coins) {
                if (c > i) break;
                dp[i] = Math.min(dp[i], dp[i-c] + 1);
            }
        }
        return dp[amount] == (int)1e9 ? -1 : dp[amount];
    }
}
/*
    Runtime: 15 ms
    Memory Usage: 44.35 MB
    Time Complexity : O(n*t)
*/


