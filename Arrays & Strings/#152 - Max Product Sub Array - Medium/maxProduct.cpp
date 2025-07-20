class Solution {
public:
    int maxProduct(vector<int>& nums) {
        int prod1 = nums[0];  // max product ending here
        int prod2 = nums[0];  // min product ending here
        int result = nums[0];
        
        for (int i = 1; i < nums.size(); i++) {
            int temp = max({nums[i], prod1 * nums[i], prod2 * nums[i]});
            prod2 = min({nums[i], prod1 * nums[i], prod2 * nums[i]});
            prod1 = temp;
            
            result = max(result, prod1);
        }
        
        return result;
    }
};
