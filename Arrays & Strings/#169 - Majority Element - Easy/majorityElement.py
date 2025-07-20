class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        n = len(nums)
        cnt = 0
        el = None

        # Boyer-Moore Voting Algorithm
        for i in range(n):
            if cnt == 0:
                cnt = 1
                el = nums[i]
            elif nums[i] == el:
                cnt += 1
            else:
                cnt -= 1

        # Optional: Verify if el is actually the majority element.
        cnt1 = 0
        for i in range(n):
            if nums[i] == el:
                cnt1 += 1
        if cnt1 > n // 2:
            return el
        return -1