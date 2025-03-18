class Solution {
    public:
        int majorityElement(vector<int>& nums) {
    
            //Sorting method
    
            // Hashmap method
            unordered_map<int, int> umap;
            for(int x: nums){
                umap[x]++;
            }
            for(auto i: umap){
                if(i.second >= ((double)nums.size()/2)){
                    return i.first;
                }
            }
            return 0;
    
            // Moore's voting method
            int count = 0, candidate = nums[0];
            for(int i=1; i<nums.size(); i++){
                if(candidate == nums[i]){
                    count++;
                }
                else{
                    if(count == 0){
                        candidate = nums[i];
                    }
                    else{
                        count--;
                    }
                }
            }
            return candidate;
        }
    };