class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int j = -1;
        int n = nums.size();
        
        // Place the pointer j at the first zero
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                j = i;
                break;
            }
        }
        
        // No zeros found, return early
        if (j == -1) {
            return;
        }
        
        // Move the pointers i and j and swap accordingly
        for (int i = j + 1; i < n; i++) {
            if (nums[i] != 0) {
                swap(nums[i], nums[j]);
                j++;
            }
        }
    }
};
