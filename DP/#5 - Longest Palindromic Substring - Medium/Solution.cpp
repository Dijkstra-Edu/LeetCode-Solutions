#include <bits/stdc++.h>
using namespace std;

// Approach 1: Brute Force
class SolutionBruteForce {
public:
    string longestPalindrome(string s) {
        string res = "";
        int n = s.size();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                string sub = s.substr(i, j - i + 1);
                string rev = sub;
                reverse(rev.begin(), rev.end());
                if (sub == rev && sub.size() > res.size()) {
                    res = sub;
                }
            }
        }
        return res;
    }
};

// Approach 2: Expand Around Center
class SolutionExpand {
public:
    string expand(string& s, int l, int r) {
        while (l >= 0 && r < s.size() && s[l] == s[r]) {
            l--; r++;
        }
        return s.substr(l+1, r-l-1);
    }

    string longestPalindrome(string s) {
        string res = "";
        for (int i = 0; i < s.size(); i++) {
            string odd = expand(s, i, i);
            if (odd.size() > res.size()) res = odd;
            string even = expand(s, i, i+1);
            if (even.size() > res.size()) res = even;
        }
        return res;
    }
};

// Approach 3: Dynamic Programming
class SolutionDP {
public:
    string longestPalindrome(string s) {
        int n = s.size();
        vector<vector<bool>> dp(n, vector<bool>(n, false));
        string res = "";
        
        for (int i = n-1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s[i] == s[j] && (j - i < 3 || dp[i+1][j-1])) {
                    dp[i][j] = true;
                }
                if (dp[i][j] && (j - i + 1) > res.size()) {
                    res = s.substr(i, j - i + 1);
                }
            }
        }
        return res;
    }
};
