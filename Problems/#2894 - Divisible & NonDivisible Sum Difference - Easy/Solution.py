class Solution(object):
    def differenceOfSums(self, n, m):
        total_sum = n * (n + 1) // 2
        count_div_m = n // m
        sum_div_m = m * count_div_m * (count_div_m + 1) // 2
        return total_sum - 2 * sum_div_m
