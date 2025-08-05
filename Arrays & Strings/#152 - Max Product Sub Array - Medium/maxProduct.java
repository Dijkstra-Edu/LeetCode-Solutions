class Solution {
    public int maxProduct(int[] nums) {
        int prod1 = nums[0];  // max product ending here
        int prod2 = nums[0];  // min product ending here
        int result = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int temp = Math.max(nums[i], Math.max(prod1 * nums[i], prod2 * nums[i]));
            prod2 = Math.min(nums[i], Math.min(prod1 * nums[i], prod2 * nums[i]));
            prod1 = temp;
            
            result = Math.max(result, prod1);
        }
        
        return result;
    }
}
