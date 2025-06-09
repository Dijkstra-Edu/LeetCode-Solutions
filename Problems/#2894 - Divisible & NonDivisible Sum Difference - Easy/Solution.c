int differenceOfSums(int n, int m) {
    int total_sum = n * (n + 1) / 2;
    int count_div_m = n / m;
    int sum_div_m = m * count_div_m * (count_div_m + 1) / 2;
    return total_sum - 2 * sum_div_m;
}