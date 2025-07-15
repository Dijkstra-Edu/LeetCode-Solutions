//Attempt #1 - 10mins
//Link: https://leetcode.com/problems/combination-sum/description/

class Solution {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        helper(candidates, target, new ArrayList<Integer>(), 0, 0);
        return ans;
    }

    public void helper(int[] arr, int target, List<Integer> temp, int start, int sum) {
        if(sum == target) {
            ans.add(new ArrayList<Integer>(temp));
            return;
        }

        if (sum>target) return;

        for(int i=start; i<arr.length; i++) {
            temp.add(arr[i]);
            helper(arr, target, temp, i, sum+arr[i]);
            temp.remove(temp.size()-1);
        }
    }
}

/*
Runtime
2 ms
Beats
79.96%
Memory
44 MB
Beats
6.1%

TC - O(2^n)
 */