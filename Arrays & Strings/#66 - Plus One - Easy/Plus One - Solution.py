from typing import List

#SOLUTION
class Solution:
    def plusOne(self, digits: List[int]) -> List[int]: 
        for i in range(len(digits)-1,-1,-1): #iterating the list from the end to beginning
            if digits[i] < 9: 
                digits[i]+=1
                return digits # if digit is less than 9 we add one and return
            else:
                digits[i]=0 #else make it zero and continue iterating
        return [1] + digits # if all are 0 (i.e all 9's), we add one at the start and return
    
if __name__ == "__main__":
    print(Solution().plusOne([9,9,9,9,9])) # Example input

#Time Complexity : O(n)
