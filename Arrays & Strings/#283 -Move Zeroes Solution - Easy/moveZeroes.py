class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        j = -1
        n = len(nums)

        # Place the pointer j at the first zero
        for i in range(n):
            if nums[i] == 0:
                j = i
                break

        # No zeros found, return early
        if j == -1:
            return

        # Move the pointers i and j and swap accordingly
        for i in range(j + 1, n):
            if nums[i] != 0:
                nums[i], nums[j] = nums[j], nums[i]
                j += 1