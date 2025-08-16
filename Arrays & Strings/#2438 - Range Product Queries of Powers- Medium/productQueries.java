import java.util.*;

class Solution {
    private final int mod = (int)1e9 + 7;

    public int[] productQueries(int n, int[][] queries) {
        List<Integer> p2 = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        int i = 0, k = 0;

        while (n > 0) {
            if ((n & 1) == 1) {
                p2.add(i);
                if (k > 0) {
                    p2.set(k, p2.get(k) + p2.get(k - 1)); // prefix sum of exponents
                }
                k++;
            }
            n >>= 1;
            i++;
        }

        for (int[] q : queries) {
            int p = p2.get(q[1]) - (q[0] > 0 ? p2.get(q[0] - 1) : 0);
            res.add(fastPow(2, p));
        }

        // Convert List<Integer> to int[]
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    private int fastPow(int base, int exp) {
        long result = 1;
        long b = base;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * b) % mod;
            }
            b = (b * b) % mod;
            exp >>= 1;
        }
        return (int) result;
    }
}
