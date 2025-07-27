//Memoziation
class Solution {
public:
    vector<vector<int>> dp;
    int recur(int ind, int amount, vector<int>& coins){
        if (ind == 0) {
            if (amount % coins[0] == 0) return amount / coins[0];
            else return 1e9;
        }
        if(dp[ind][amount]!=-1) return dp[ind][amount];
        int take = 1e9;
        if(amount>=coins[ind]){
            take = recur(ind,amount-coins[ind],coins)+1;
        }
        int notTake = recur(ind-1,amount,coins);
        dp[ind][amount] = min(take,notTake);
        return dp[ind][amount];
    }

    int coinChange(vector<int>& coins, int amount) {
        int n=coins.size();
        dp = vector<vector<int>>(n,vector<int>(amount+1,-1));
        for(int i=0;i<n;i++) dp[i][0]=0;
        int minCoins = recur(n-1,amount,coins);
        return minCoins==1e9 ? -1 :minCoins;
    }
};
/*
    Runtime: 45 ms
    Memory Usage: 49.02 MB
    Time Complexity : O(n*t)
*/


//Tabulation
class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        int n=coins.size();
        vector<vector<int>> dp(n,vector<int>(amount+1,1e9));
        for(int i=0;i<=amount;i++) if(i%coins[0]==0) dp[0][i]=i/coins[0];
        for(int i=0;i<n;i++) dp[i][0]=0;
        for(int i=1;i<n;i++){
            for(int j=1;j<=amount;j++){
                int nottake = dp[i-1][j];
                int take = 1e9;
                if(coins[i]<=j) take = 1+dp[i][j-coins[i]];
                dp[i][j]=min(take,nottake);
            }
        }
        return dp[n-1][amount]==1e9 ? -1 : dp[n-1][amount];
    }
};
/*
    Runtime: 44 ms
    Memory Usage: 48.88 MB
    Time Complexity : O(n*t)
*/


//Optimized Tabulation
class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        int n=coins.size();
        vector<int> curr(amount+1,1e9);
        vector<int> prev(amount+1,1e9);
        for(int i=0;i<=amount;i++) if(i%coins[0]==0) prev[i]=i/coins[0];
        prev[0]=0;
        for(int i=1;i<n;i++){
            curr[0]=0;
            for(int j=1;j<=amount;j++){
                int nottake = prev[j];
                int take = 1e9;
                if(coins[i]<=j) take = 1+curr[j-coins[i]];
                curr[j]=min(take,nottake);
            }
            prev=curr;
        }
        return prev[amount]==1e9 ? -1 : prev[amount];
    }
};
/*
    Runtime: 23 ms
    Memory Usage: 21.97 MB
    Time Complexity : O(n*t)
*/

// 1D Tabulation
class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        int n=coins.size();
        vector<int> dp(amount+1,1e9);
        sort(coins.begin(),coins.end());
        dp[0]=0;
        for(int i=1;i<=amount;i++){
            for (int c:coins){
                if(c>i) break;
                dp[i] = min(dp[i],dp[i-c]+1);
            }
        }
        return dp[amount]==1e9 ? -1 :dp[amount];
    }
};
/*
    Runtime: 23 ms
    Memory Usage: 15.69 MB
    Time Complexity : O(n*t)
*/