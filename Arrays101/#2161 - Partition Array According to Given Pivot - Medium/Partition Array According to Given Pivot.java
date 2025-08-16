class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int length = nums.length, index = 0;
        int[] result = new int[length];
        for (int num: nums)
            if (num < pivot) result[index++] = num;
        for (int num: nums) 
            if (num == pivot) result[index++] = num;
        for (int num: nums) 
            if (num > pivot) result[index++] = num;
        return result;
    }
}