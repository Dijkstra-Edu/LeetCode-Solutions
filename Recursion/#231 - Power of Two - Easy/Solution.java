class Solution {
    public boolean isPowerOfTwo(int n) {
        // A power of two has exactly one bit set in binary representation
        return n > 0 && (n & (n - 1)) == 0;
    }
}