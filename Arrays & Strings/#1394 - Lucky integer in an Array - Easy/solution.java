class Solution {
    public int findLucky(int[] arr)
    {
      int temp=0,lucky=-1,count=0;
      for(int i=0;i<arr.length;i++)
      {
       count=0;
       temp=arr[i];
       for(int j=0;j<arr.length;j++)
       {
        if(arr[j]==temp)
        count++;
       }
       if(count==temp&&temp>lucky)
       lucky=temp;
      }  
      return lucky;
    }
}