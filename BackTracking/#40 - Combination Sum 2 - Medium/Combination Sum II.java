//Attempt #1 - 11mins
//Link: https://leetcode.com/problems/combination-sum-ii/description/

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>>ans=new ArrayList<>();
        solve(0,target,candidates,ans,new ArrayList<>());
        return ans;
    }
    public void solve(int ind,int target,int[]candidates,List<List<Integer>>ans,ArrayList<Integer>temp){
        if(target==0){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i=ind;i<candidates.length;i++){
            if(i!=ind && candidates[i]==candidates[i-1]) continue;
            if(candidates[i]>target) break;

            temp.add(candidates[i]);
            solve(i+1,target-candidates[i],candidates,ans,temp);
            temp.remove(temp.size()-1);
        }
    }    
}

/*
TC - O(2^n)
 */

//Idk why this one didn't work
class Solution {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(0, 0, new ArrayList<Integer>(), target, candidates);
        return ans;    
    }

    public void helper(int cur, int sum, ArrayList<Integer> temp, int target, int[] arr) {
        if(sum == target) {
            Collections.sort(temp);
            if(ans.contains(temp)) return;
            ans.add(new ArrayList<Integer>(temp));
        } else {
            for(int i=cur; i<arr.length; i++) {
                if(i!=cur && arr[i]==arr[i-1]) continue;

                temp.add(arr[i]);
                helper(i+1,sum+arr[i], temp, target, arr);
                temp.remove(temp.size()-1);
            }
        }

    }
}
//TLE - 124/175