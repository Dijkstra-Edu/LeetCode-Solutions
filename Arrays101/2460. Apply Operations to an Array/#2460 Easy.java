class Solution {
    public int[] applyOperations(int[] nums) {
        int ans[] = new int[nums.length];
        int idx = 0;
        for(int i=0; i<nums.length-1; i++) {
            if(nums[i] == nums[i+1] && nums[i] != 0) {
                ans[idx] = nums[i] * 2;
                nums[i+1] = 0;
                idx++;
            }
            else if(nums[i] != 0) {
                ans[idx] = nums[i];
                idx++;
            }
        }
        ans[idx] = nums[nums.length-1];
        
        return ans;
    }
}