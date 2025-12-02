class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int tempMax = 0;
        for(int i = 0 ; i< nums.length; i++){
            if(nums[i] == 1) max++;
            if(nums[i] == 0){
                tempMax = Math.max(tempMax, max);
                max = 0;
            }
        }
        return Math.max(tempMax, max);
    }
}