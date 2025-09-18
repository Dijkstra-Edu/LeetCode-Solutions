# Approach 1: Brute Force
class SolutionBruteForce:
    def longestPrefix(self, s: str) -> str:
        for i in range(len(s)-1, 0, -1):
            if s[:i] == s[-i:]:
                return s[:i]
        return ""


# Approach 2: KMP Prefix Function
class SolutionKMP:
    def longestPrefix(self, s: str) -> str:
        n = len(s)
        lps = [0] * n
        j = 0
        for i in range(1, n):
            while j > 0 and s[i] != s[j]:
                j = lps[j-1]
            if s[i] == s[j]:
                j += 1
                lps[i] = j
        return s[:lps[-1]]


# Approach 3: Rolling Hash
class SolutionRollingHash:
    def longestPrefix(self, s: str) -> str:
        n = len(s)
        mod, base = 10**9 + 7, 31
        prefix_hash, suffix_hash = 0, 0
        power = 1
        res = 0
        for i in range(n-1):
            prefix_hash = (prefix_hash * base + ord(s[i]) - ord('a') + 1) % mod
            suffix_hash = (suffix_hash + (ord(s[n-1-i]) - ord('a') + 1) * power) % mod
            power = (power * base) % mod
            if prefix_hash == suffix_hash:
                res = i+1
        return s[:res]
