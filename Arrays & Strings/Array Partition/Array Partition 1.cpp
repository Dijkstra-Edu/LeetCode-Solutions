class Solution {
public:
    int arrayPairSum(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        int sum = 0;
        for(int i=0;i<nums.size();i+=2) {
            sum += nums[i];
        }
        return sum;
    }
};
/*
    Runtime: 35 ms
    Memory Usage: 31.69 MB
    Time Complexity : O(n log n)
*/