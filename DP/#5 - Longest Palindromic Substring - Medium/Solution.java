// Approach 1: Brute Force
class SolutionBruteForce {
    private boolean isPalindrome(String str) {
        int l = 0, r = str.length() - 1;
        while (l < r) {
            if (str.charAt(l++) != str.charAt(r--)) return false;
        }
        return true;
    }

    public String longestPalindrome(String s) {
        String res = "";
        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                String sub = s.substring(i, j + 1);
                if (isPalindrome(sub) && sub.length() > res.length()) {
                    res = sub;
                }
            }
        }
        return res;
    }
}

// Approach 2: Expand Around Center
class SolutionExpand {
    private String expand(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--; r++;
        }
        return s.substring(l+1, r);
    }

    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String odd = expand(s, i, i);
            if (odd.length() > res.length()) res = odd;
            String even = expand(s, i, i+1);
            if (even.length() > res.length()) res = even;
        }
        return res;
    }
}

// Approach 3: Dynamic Programming
class SolutionDP {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String res = "";
        
        for (int i = n-1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i+1][j-1])) {
                    dp[i][j] = true;
                }
                if (dp[i][j] && (j - i + 1) > res.length()) {
                    res = s.substring(i, j+1);
                }
            }
        }
        return res;
    }
}
