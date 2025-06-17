class Solution(object):
    def differenceOfSums(self, n, m):
        
        totalsum = n * (n+1) // 2

        
        k = n // m

        
        sum_divisible_by_m = m * k * (k + 1) // 2

        # num1 - num2 = (sum of numbers not divisible by m) - (sum of numbers divisible by m)
        result = totalsum - 2 * sum_divisible_by_m
        return result

    
   

    
   

    
    
    


        