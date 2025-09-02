# Approach 1: Brute Force
class SolutionBruteForce:
    def longestPalindrome(self, s: str) -> str:
        def is_palindrome(sub):
            return sub == sub[::-1]
        res = ""
        n = len(s)
        for i in range(n):
            for j in range(i, n):
                if is_palindrome(s[i:j+1]) and len(s[i:j+1]) > len(res):
                    res = s[i:j+1]
        return res


# Approach 2: Expand Around Center
class SolutionExpand:
    def longestPalindrome(self, s: str) -> str:
        def expand(l, r):
            while l >= 0 and r < len(s) and s[l] == s[r]:
                l -= 1
                r += 1
            return s[l+1:r]
        
        res = ""
        for i in range(len(s)):
            odd = expand(i, i)
            if len(odd) > len(res): res = odd
            even = expand(i, i+1)
            if len(even) > len(res): res = even
        return res


# Approach 3: Dynamic Programming
class SolutionDP:
    def longestPalindrome(self, s: str) -> str:
        n = len(s)
        dp = [[False] * n for _ in range(n)]
        res = ""
        
        for i in range(n-1, -1, -1):
            for j in range(i, n):
                if s[i] == s[j] and (j - i < 3 or dp[i+1][j-1]):
                    dp[i][j] = True
                if dp[i][j] and (j - i + 1) > len(res):
                    res = s[i:j+1]
        return res
