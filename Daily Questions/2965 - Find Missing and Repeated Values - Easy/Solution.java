class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        Map<Integer,Integer> map=new HashMap<>();
        int[] res=new int[2];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid.length;j++){
                if(map.containsKey(grid[i][j])){
                    map.put(grid[i][j],map.get(grid[i][j])+1);
                }
                else{
                    map.put(grid[i][j],1);
                }
            }
        }
        for(int i=1;i<=grid.length*grid.length;i++){
            if(!map.containsKey(i)){
                res[1]=i;
            }
            else{
                if(map.get(i)==2){
                    res[0]=i;
                }
            }
        }
        return res;
    }
}