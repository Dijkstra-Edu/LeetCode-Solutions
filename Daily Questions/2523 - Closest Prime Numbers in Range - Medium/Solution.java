import java.util.*;

class Solution {
    private static boolean[] isPrime = new boolean[1000001];

    static {
        Arrays.fill(isPrime, true);
        precompute();
    }

    private static void precompute() {
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= 1000000; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= 1000000; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }

    public int[] closestPrimes(int left, int right) {
        int prev = -1, minDiff = Integer.MAX_VALUE;
        int num1 = -1, num2 = -1;

        for (int i = left; i <= right; i++) {
            if (isPrime[i]) {
                if (prev != -1 && (i - prev < minDiff)) {
                    minDiff = i - prev;
                    num1 = prev;
                    num2 = i;
                }
                prev = i;
            }
        }

        return (num1 == -1) ? new int[]{-1, -1} : new int[]{num1, num2};
    }
}