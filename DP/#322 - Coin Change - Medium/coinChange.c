//Plain Recursion
#include <stdio.h>
#include <limits.h>

int recur(int ind, int amount, int coins[]) {
    if (ind == 0) {
        if (amount % coins[0] == 0) return amount / coins[0];
        else return INT_MAX/2; // to avoid overflow
    }
    int take = INT_MAX/2;
    if (amount >= coins[ind]) {
        take = recur(ind, amount - coins[ind], coins) + 1;
    }
    int notTake = recur(ind - 1, amount, coins);
    return take < notTake ? take : notTake;
}

int coinChange(int coins[], int n, int amount) {
    int minCoins = recur(n - 1, amount, coins);
    return minCoins >= INT_MAX/2 ? -1 : minCoins;
}
//Time Limit Exceeded (TLE) for large inputs

//Recursion with Memoization
#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

int **dp;

int recurMemo(int ind, int amount, int coins[]) {
    if (ind == 0) {
        return (amount % coins[0] == 0) ? amount / coins[0] : INT_MAX/2;
    }
    if (dp[ind][amount] != -1) return dp[ind][amount];

    int take = INT_MAX/2;
    if (amount >= coins[ind])
        take = 1 + recurMemo(ind, amount - coins[ind], coins);

    int notTake = recurMemo(ind-1, amount, coins);
    dp[ind][amount] = take < notTake ? take : notTake;
    return dp[ind][amount];
}

int coinChange(int coins[], int n, int amount) {
    dp = malloc(n * sizeof(int*));
    for (int i = 0; i < n; i++) {
        dp[i] = malloc((amount+1)*sizeof(int));
        for (int j = 0; j <= amount; j++) dp[i][j] = -1;
        dp[i][0] = 0;
    }
    int minCoins = recurMemo(n-1, amount, coins);
    for (int i = 0; i < n; i++) free(dp[i]);
    free(dp);
    return minCoins >= INT_MAX/2 ? -1 : minCoins;
}
/*
    Runtime: 56 ms
    Memory Usage: 39.30 MB
    Time Complexity : O(n*t)
*/

//Tabulation
#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

int min(int a, int b) { return a < b ? a : b; }

int coinChange(int coins[], int n, int amount) {
    int **dp = malloc(n * sizeof(int*));
    for (int i = 0; i < n; i++) {
        dp[i] = malloc((amount+1)*sizeof(int));
        for (int j = 0; j <= amount; j++) dp[i][j] = INT_MAX/2;
    }

    for (int i = 0; i <= amount; i++)
        if (i % coins[0] == 0) dp[0][i] = i / coins[0];
    for (int i = 0; i < n; i++) dp[i][0] = 0;

    for (int i = 1; i < n; i++) {
        for (int j = 1; j <= amount; j++) {
            int notTake = dp[i-1][j];
            int take = (coins[i] <= j) ? 1 + dp[i][j-coins[i]] : INT_MAX/2;
            dp[i][j] = min(take, notTake);
        }
    }

    int ans = dp[n-1][amount] >= INT_MAX/2 ? -1 : dp[n-1][amount];
    for (int i = 0; i < n; i++) free(dp[i]);
    free(dp);
    return ans;
}
/*
    Runtime: 55 ms
    Memory Usage: 38.93 MB
    Time Complexity : O(n*t)
*/

//Space Optimized Tabulation
#include <stdio.h>
#include <limits.h>

int min(int a, int b) { return a < b ? a : b; }

int coinChange(int coins[], int n, int amount) {
    int prev[amount+1], curr[amount+1];
    for (int i = 0; i <= amount; i++) prev[i] = INT_MAX/2;
    for (int i = 0; i <= amount; i++)
        if (i % coins[0] == 0) prev[i] = i / coins[0];
    prev[0] = 0;

    for (int i = 1; i < n; i++) {
        curr[0] = 0;
        for (int j = 1; j <= amount; j++) {
            int notTake = prev[j];
            int take = (coins[i] <= j) ? 1 + curr[j-coins[i]] : INT_MAX/2;
            curr[j] = min(take, notTake);
        }
        for (int k = 0; k <= amount; k++) prev[k] = curr[k];
    }
    return prev[amount] >= INT_MAX/2 ? -1 : prev[amount];
}
/*
    Runtime: 32 ms
    Memory Usage: 8.04 MB
    Time Complexity : O(n*t)
*/

//1D Tabulation
#include <stdio.h>
#include <limits.h>

int min(int a, int b) { return a < b ? a : b; }

int coinChange(int coins[], int n, int amount) {
    int dp[amount+1];
    for(int i=0;i<=amount;i++) dp[i] = INT_MAX/2;
    dp[0] = 0;

    for (int i = 1; i <= amount; i++) {
        for (int c = 0; c < n; c++) {
            if (coins[c] > i) continue;
            dp[i] = min(dp[i], dp[i - coins[c]] + 1);
        }
    }
    return dp[amount] >= INT_MAX/2 ? -1 : dp[amount];
}
/*
    Runtime: 28 ms
    Memory Usage: 8.16 MB
    Time Complexity : O(n*t)
*/