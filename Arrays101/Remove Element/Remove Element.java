class Solution {
    public int removeElement(int[] nums, int val) {
//         ArrayList<Integer> ans = new ArrayList<Integer>(nums.length);
//         int count = 0;
//         for(int i=0; i<nums.length; i++)
//         {
//             if(nums[i]==val)
//             {
//                 count++;
//                 continue;
//             }
//             else
//             {
//                 ans.add(nums[i]);
//             }
//         }
//         System.out.println(ans);
//         for(int i=0; i<ans.size(); i++)
//         {
//             nums[i]=ans.get(i);
//             System.out.print(nums[i]+" ");
//         }
        
//         return nums.length-count;
// Runtime (my soln): 30 ms 
        int i = 0;
        for (int elem: nums){
            if (elem != val){
                nums[i] = elem;                
                i++;
            }
        }
        return i;
        //Runtime: 1ms
    }
}