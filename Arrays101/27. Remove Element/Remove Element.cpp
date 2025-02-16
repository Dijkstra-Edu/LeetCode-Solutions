class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        nums.erase(
            std::remove(
                nums.begin(),
                nums.end(),
                val),
            nums.end());
        return nums.size();
    }
};

/*
TC - O(n + k)
SC - O(1)
*/