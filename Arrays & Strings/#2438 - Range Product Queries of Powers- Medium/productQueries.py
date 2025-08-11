class Solution:
    MOD = 10**9 + 7

    def productQueries(self, n: int, queries: list[list[int]]) -> list[int]:
        p2 = []
        i = k = 0

        while n:
            if n & 1:
                p2.append(i)
                if k > 0:
                    p2[k] += p2[k - 1]  # prefix sum of exponents
                k += 1
            n >>= 1
            i += 1

        res = []
        for q in queries:
            p = p2[q[1]] - (p2[q[0] - 1] if q[0] > 0 else 0)
            res.append(self.fastPow(2, p))
        return res

    def fastPow(self, base: int, exp: int) -> int:
        result = 1
        while exp:
            if exp & 1:
                result = (result * base) % self.MOD
            base = (base * base) % self.MOD
            exp >>= 1
        return result
