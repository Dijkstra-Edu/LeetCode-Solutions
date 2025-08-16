class Solution {
    public:
        double myPow(double x, int n) {
            double res = 1;
            if(n < 0) x = 1/x;
            long nums = labs(n);
            while(nums){
                if(nums & 1){
                    res *= x;
                }
    
                x *= x;
                nums >>= 1;
            }
            return res;
        }
    };