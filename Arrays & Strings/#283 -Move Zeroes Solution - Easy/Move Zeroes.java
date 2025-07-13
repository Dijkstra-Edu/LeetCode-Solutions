class Solution {
    public void moveZeroes(int[] nums) {
//         int l = nums.length;
//         int count = 0;
//         for(int i=0; i<l; i++)
//         {
//             //System.out.println(nums[i]+" "+i);
//             if(nums[i]==0)
//             {
//                 count++;
//                 for (int j = i+1; j < l; j++) {
//                     // Shift each element one position to the left
//                     // int temp = nums[j-1];
//                     // nums[j-1] = nums[l-1];
//                     // nums[l-1]=temp;
//                     nums[j - 1] = nums[j];
//                 }
//                 //System.out.println(nums[l-count]);
//                 //System.out.println(Arrays.toString(nums));
//                 nums[l-1] = 0;
//             }
            
//         }
        
        if (nums == null || nums.length == 0) return;        

        int insertPos = 0;
        for (int num: nums) {
            if (num != 0) nums[insertPos++] = num;
        }        

        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }
}

/*
 Runtime: 1ms
 Memory: 54.5

 Very efficient - Idea is to push all numbers as forward as possible, and then fill the rest with zeroes.
 */