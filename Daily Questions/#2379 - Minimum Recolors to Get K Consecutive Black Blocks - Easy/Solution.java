class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length(), b = 0, Max;

        for(int i = 0; i < k; i++){
            if(blocks.charAt(i) == 'B'){
                b++;
            }
        }

        Max = b;

        for(int i = 0; i < n - k; i++){
            if(blocks.charAt(i) == 'B'){
                b--;
            }
            if(blocks.charAt(i + k) == 'B'){
                b++;
            }

            Max = Math.max(Max, b);

            if(Max >= k){
                return 0;
            }
        }

        return k - Max;
    }
}