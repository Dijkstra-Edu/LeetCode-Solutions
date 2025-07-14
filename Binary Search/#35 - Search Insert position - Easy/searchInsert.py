class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        n = len(nums)
        low = 0
        high = n - 1
        ans = n
        
        while low <= high:
            mid = (low + high) // 2
            if nums[mid] >= target:
                ans = mid
                high = mid - 1   # look for smaller index on the left
            else:
                low = mid + 1    # look on the right
                
        return ans