import java.util.HashMap;

class Solution {
    public boolean divideArray(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();

        int n = nums.length;

        for(int i = 0;i<n;i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        if(n%2!=0) return false;

        for(int val:map.values()){
            if(val%2!=0) return false;
        }

        return true;
    }
}