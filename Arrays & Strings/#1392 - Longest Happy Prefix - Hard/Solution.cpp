#include <bits/stdc++.h>
using namespace std;

// Approach 1: Brute Force
class SolutionBruteForce {
public:
    string longestPrefix(string s) {
        int n = s.size();
        for (int i = n-1; i > 0; i--) {
            if (s.substr(0,i) == s.substr(n-i,i)) {
                return s.substr(0,i);
            }
        }
        return "";
    }
};

// Approach 2: KMP Prefix Function
class SolutionKMP {
public:
    string longestPrefix(string s) {
        int n = s.size();
        vector<int> lps(n, 0);
        int j = 0;
        for (int i = 1; i < n; i++) {
            while (j > 0 && s[i] != s[j]) j = lps[j-1];
            if (s[i] == s[j]) lps[i] = ++j;
        }
        return s.substr(0, lps[n-1]);
    }
};

// Approach 3: Rolling Hash
class SolutionRollingHash {
public:
    string longestPrefix(string s) {
        int n = s.size();
        long long mod = 1e9+7, base = 31;
        long long prefix = 0, suffix = 0, power = 1;
        int res = 0;
        for (int i = 0; i < n-1; i++) {
            prefix = (prefix * base + (s[i]-'a'+1)) % mod;
            suffix = (suffix + (s[n-1-i]-'a'+1) * power) % mod;
            power = (power * base) % mod;
            if (prefix == suffix) res = i+1;
        }
        return s.substr(0, res);
    }
};
