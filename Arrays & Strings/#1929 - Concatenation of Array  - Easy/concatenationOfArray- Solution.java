class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n * 2];
        for(int i = 0; i < n; i++){
            ans[i] = nums[i];
            ans[i + n] = nums[i];
        }

        return ans;
    }
}