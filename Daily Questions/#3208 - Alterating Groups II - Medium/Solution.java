class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int window = 1;
        int res = 0;
        int n = colors.length;
        int i = 0;
        int j = 1;
        while(i < colors.length) {
            if(colors[(j-1) % n] != colors[j%n]) {
                window++;
                j++;
            }else {
                i = j;
                j = i + 1;
                window = 1;
                continue;
            }
            
            if(window == k) {
                res++;
                if(colors[(j-1) % n] != colors[j%n]) {
                    i++;
                    window -= 1;
                }else {
                    i = j;
                    j = i + 1;
                    window = 1;
                }   
            }
        }

        return res;
    }
}