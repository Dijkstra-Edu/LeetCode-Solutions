class Solution:
    def areAlmostEqual(self, s1: str, s2: str) -> bool:
        diff = [(a,b) for (a,b) in zip(s1,s2) if a!=b]
        if(len(diff)==0):
            return True
        if(len(diff)==2 and (diff[0][1]==diff[1][0] and diff[0][0]==diff[1][1])):
            return True
        else:
            return False
        
#Time complexity - O(n)
#Space complexity - O(1)