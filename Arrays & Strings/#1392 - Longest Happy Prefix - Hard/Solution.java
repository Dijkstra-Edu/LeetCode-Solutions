// Approach 1: Brute Force
class SolutionBruteForce {
    public String longestPrefix(String s) {
        int n = s.length();
        for (int i = n-1; i > 0; i--) {
            if (s.substring(0,i).equals(s.substring(n-i))) {
                return s.substring(0,i);
            }
        }
        return "";
    }
}

// Approach 2: KMP Prefix Function
class SolutionKMP {
    public String longestPrefix(String s) {
        int n = s.length();
        int[] lps = new int[n];
        int j = 0;
        for (int i = 1; i < n; i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = lps[j-1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                lps[i] = ++j;
            }
        }
        return s.substring(0, lps[n-1]);
    }
}

// Approach 3: Rolling Hash
class SolutionRollingHash {
    public String longestPrefix(String s) {
        int n = s.length();
        long mod = 1000000007, base = 31;
        long prefix = 0, suffix = 0, power = 1;
        int res = 0;
        for (int i = 0; i < n-1; i++) {
            prefix = (prefix * base + (s.charAt(i)-'a'+1)) % mod;
            suffix = (suffix + (s.charAt(n-1-i)-'a'+1) * power) % mod;
            power = (power * base) % mod;
            if (prefix == suffix) res = i+1;
        }
        return s.substring(0, res);
    }
}
