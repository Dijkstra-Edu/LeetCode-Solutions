class Solution {
    public int longestNiceSubarray(int[] nums) {
        int maxLength = 1, left = 0, usedBits = 0;
        for (int right = 0; right < nums.length; right++) {
            while ((usedBits & nums[right]) != 0) {
                usedBits ^= nums[left++];
            }
            usedBits |= nums[right];
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
