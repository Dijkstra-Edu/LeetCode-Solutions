public class #27-Remove Element-Easy {
    class Solution {
        public int removeElement(int[] nums, int val) {
        int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == val) {
                count++;
                }   
            }
            return count;
        }
    }
}

