class Solution {
    public int sumSubarrayMins(int[] arr) {
        Stack<int[]> stack = new Stack<>();
        long[] res = new long[arr.length]; 
        final long MOD = 1000000007L;
        
        for (int i = 0; i < arr.length; i++) {
            // use ">=" to deal with duplicate elements
            while (!stack.isEmpty() && stack.peek()[0] >= arr[i]) {
                stack.pop();
            }
            
            int j = stack.isEmpty() ? -1 : stack.peek()[1];
            res[i] = stack.isEmpty() ? 
                     ((long) arr[i] * (i + 1)) % MOD : 
                     (res[j] + (long) arr[i] * (i - j)) % MOD;
            
            stack.push(new int[]{arr[i], i});
        }
        
        long ans = 0;
        
        for (int i = 0; i < arr.length; i++) {
            ans = (ans + res[i]) % MOD;
        }
        
        return (int) ans;
    }
}
