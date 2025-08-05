class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        ind = -1
        # Step 1: Find the break point
        for i in range(n-2, -1, -1):
            if nums[i] < nums[i + 1]:
                ind = i
                break
        # If break point does not exist, reverse the whole array
        if ind == -1:
            nums.reverse()
            return
        # Step 2: Find the next greater element and swap
        for i in range(n - 1, ind, -1):
            if nums[i] > nums[ind]:
                nums[i], nums[ind] = nums[ind], nums[i]
                break
        # Step 3: Reverse the right half
        nums[ind+1:] = reversed(nums[ind+1:])
