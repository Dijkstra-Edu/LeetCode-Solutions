class Solution {
    //quickselect: the average of time:o(n), it depends on the pivot we choose.
//space:o(logn)
public int findKthLargest(int[] nums, int k) {
        return quickselect(nums, 0, nums.length - 1, k);
    }
public int quickselect(int[] nums, int start, int end, int k){
        if(start >= end) return nums[start];
        int i = start;
        int j = end;
        int pivot = nums[(end - start) / 2 + start];
        while(i <= j){
            while(i <= j && nums[i] < pivot){ //Change for smallest
                i++;
            }
            while(i <= j && nums[j] > pivot){
                j--;
            }
            if(i <= j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }
        //start,...,j,i,...,end
        if(start + k - 1 <= j){
            return quickselect(nums, start, j, k);
        }
        if(start + k - 1 >= i){
            return quickselect(nums, i, end, k - i + start);
        }
        return nums[j + 1];
    }
}