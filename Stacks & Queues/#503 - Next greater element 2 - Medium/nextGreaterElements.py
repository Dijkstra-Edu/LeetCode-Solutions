class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        n = len(nums)
        stack = []
        ans = [0] * n
        # Preload stack with reversed nums for circular behavior
        for i in range(n - 1, -1, -1):
            stack.append(nums[i])
        for i in range(n - 1, -1, -1):
            while stack and nums[i] >= stack[-1]:
                stack.pop()
            if not stack:
                ans[i] = -1
            else:
                ans[i] = stack[-1]
            stack.append(nums[i])
        return ans
