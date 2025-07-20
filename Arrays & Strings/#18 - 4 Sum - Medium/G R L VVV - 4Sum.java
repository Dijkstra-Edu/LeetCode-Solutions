//Attempt #1 -
//Link: https://leetcode.com/problems/4sum/description/

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> quadruplets = new ArrayList<>();
        int n = nums.length;
        // Sorting the array
        Arrays.sort(nums);
        for (int i = 0; i < n - 3; i++) {
            // Skip duplicates
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < n - 2; j++) {
                // Skip duplicates
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = n - 1;
                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    } else {
                        quadruplets.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        // Skip duplicates
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    }
                }
            }
        }
        return quadruplets;
    }
}

/*
Sort the input array in non-decreasing order.
Traverse the array from 0 to n-3 and use a variable i to keep track of the first element in the quadruplet.
If the current element is the same as the previous element, skip it to avoid duplicates.
Traverse the array from i+1 to n-2 and use a variable j to keep track of the second element in the quadruplet.
If the current element is the same as the previous element, skip it to avoid duplicates.
Use two pointers, left = j+1 and right = n-1, to find the other two elements in the quadruplet whose sum equals the target value.
If the sum of the four elements is less than the target value, increment left pointer.
If the sum of the four elements is greater than the target value, decrement right pointer.
If the sum of the four elements is equal to the target value, add the quadruplet to the result and increment left and decrement right pointers.
Skip duplicate values of left and right pointers to avoid duplicate quadruplets.
Return the result.
*/