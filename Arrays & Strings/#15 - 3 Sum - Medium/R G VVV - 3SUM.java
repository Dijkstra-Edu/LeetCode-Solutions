//Attempt #1 - confusion - checked ans and then solved in 10mins
//Link: https://leetcode.com/problems/3sum/description/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> s = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        for(int i=0; i<nums.length; i++) {
            int j=i+1;
            int k=nums.length-1;
            while(j<k) {
                if(nums[i]+nums[j]+nums[k]==0) {
                    //System.out.println(nums[i]+" "+nums[j]+" "+nums[k]);
                    s.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++; k--;
                }
                else if((nums[i]+nums[j]+nums[k])<0) j++;
                else k--;
            }
        }

        ans.addAll(s);

        return ans;
    }
}

/*
Just like 2SUM - you need to fix a given number, and use 2 pointers within another loop to check all possible values that can satisfy the given conidition
*/

/*
Runtime
678 ms
Beats
10.10%
Memory
50.3 MB
Beats
41.57%

TC - O(nlogn) + O(n^2) Therefore O(n^2logn)
SC - O(n)
 */

//Optimal:

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set <List<Integer>>set =new HashSet<>();
        if(nums.length==0){
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        int sum=0;
        for (int i=0;i<nums.length-2;i++){
                int j=i+1;
                int k=nums.length-1;
                while (j<k){
                    sum= nums[i]+nums[j]+nums[k];
                    if (sum==0)
                    set.add(Arrays.asList(nums[i],nums[j++],nums[k--]));
                    if (sum<0)
                    j++;
                    else if (sum>0)
                    k--;
                }
        }
        return new ArrayList<>(set);
    }
}

/*
Not much difference 
 */