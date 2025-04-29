from typing import List
def Solution(nums: List[int]) -> List[int]:
        for i in range(len(nums)-1):
            if nums[i]==nums[i+1]:
                nums[i]*=2
                nums[i+1]=0
        j=0
        k=0
        while(k!=len(nums)): #Two pointer method to move the zeros to the end
            if nums[k]!=0:
                nums[k],nums[j]=nums[j],nums[k] #Swapping
                j+=1
            k+=1
        return nums

if __name__ == "__main__":
    num = Solution([1,1,1,2,2,3,4,5])
    print(num)