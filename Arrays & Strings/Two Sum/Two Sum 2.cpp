//Brute Force
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        for(int i = 0;i<nums.size();i++) {
            for(int j = i+1;j<nums.size();j++) {
                if(nums[i] + nums[j] == target) return {i,j};
            }
        }
        return {};
    }
};
/*
    Runtime: 2.2 ms
    Memory Usage: 12.69 MB
    Time Complexity : O(n^2)
*/


//One-Pass Hash Table
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> numMp;
        int n = nums.size();

        for(int i = 0; i < n; i++) {
            int complement = target - nums[i];
            if(numMp.count(complement)) {
                return {numMp[complement], i};
            }
            numMp[nums[i]] = i;
        }
        return {};
    }
};
/*
    Runtime: 3 ms
    Memory Usage: 14.12 MB
    Time Complexity : O(n)
*/


//Two-pass Hash Table
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> numMp;
        int n = nums.size();

        for(int i = 0;i < n; i++) {
            numMp[nums[i]] = i;
        }

        for(int i = 0; i < n; i++) {
            int complement = target - nums[i];
            if(numMp.count(complement) && numMp[complement] != i) {
                return {i, numMp[complement]};
            }
        }
        return {};
    }
};
/*
    Runtime: 11 ms
    Memory Usage: 15.69 MB
    Time Complexity : O(n)
*/