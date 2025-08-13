class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n - 1;
        int ans = n;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] >= target) {
                ans = mid;
                high = mid - 1; // look for smaller index on the left
            } else {
                low = mid + 1;  // look on the right
            }
        }
        return ans;
    }
}
