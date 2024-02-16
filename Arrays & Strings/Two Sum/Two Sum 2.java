//Attempt #1 - roughly 12 mins
class Solution {
    public int[] twoSum(int[] n, int target) {
        //Need only two numbers
        int ans[] = new int[2];
        for(int i=0; i<n.length; i++)
        {
            for(int j=i+1; j<n.length; j++)
            {
                //System.out.println(n[i]+" "+i+"%%%%"+n[j]+" "+j);
                if((n[i]+n[j])==target)
                {
                    //System.out.println(i+" "+j);
                    ans[0]=i+1;
                    ans[1]=j+1;
                }
            }
        }
        return ans;
    }
}
/*
19 / 21 test cases passed.
Time Complexity not good enough, at n^2 currently.
 */

//Attempt #2 - roughly 5 mins
class Solution2 {
    public int[] twoSum(int[] n, int target) {
        //Need only two numbers
        int ans[] = new int[2];
        // for(int i=0; i<n.length; i++)
        // {
        //     for(int j=i+1; j<n.length; j++)
        //     {
        //         //System.out.println(n[i]+" "+i+"%%%%"+n[j]+" "+j);
        //         if((n[i]+n[j])==target)
        //         {
        //             //System.out.println(i+" "+j);
        //             ans[0]=i+1;
        //             ans[1]=j+1;
        //         }
        //     }
        // }
        int a = 0;
        int b = a+1;
        while(true)
        {
            if((n[a]+n[b])==target)
            {
                //System.out.println(i+" "+j);
                ans[0]=a+1;
                ans[1]=b+1;
                break;
            }
            else
            {
                b++;
            }
            
            if(b==n.length)
            {
                a++;
                b = a+1;
            }
        }
        return ans;
    }
}
/*
Same Result, not good enough time complexity - O(n^2)
 */

 //Solution - Using two pointers
 class Solution3 {
    public int[] twoSum(int[] numbers, int target) {
        int lo=0, hi=numbers.length-1;
        int ans[] = new int[2];
        while (numbers[lo]+numbers[hi]!=target){
            if (numbers[lo]+numbers[hi]<target){
                lo++;
            } else {
                hi--;
            }
        }
        ans[0]=lo+1; ans[1]=hi+1;
        return ans;
    }
}
/*
Runtime: 2 ms
Memory Usage: 50.1 MB
Time Complexity: O(n) 
 */

 //Soution 2 - Using Hashmaps
 class Solution4 {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < numbers.length; i++){
            if(map.containsKey(numbers[i])) return new int[]{map.get(numbers[i])+1, i+1};
            map.put(target-numbers[i], i);
        }
        throw null;
    }
}
/*
Runtime: 8 ms
Memory Usage: 49.9 MB
Time Complexity: O(n) 
 */

//Solution - 7mins

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int arr[] = new int[2];
        int i=0, j=numbers.length-1;
        while(i<j) {
            if(numbers[i]+numbers[j]>target) j--;
            if(numbers[i]+numbers[j]<target) i++;
            if(numbers[i]+numbers[j]==target) {
                    arr[0] = i+1; arr[1] = j+1;
                    break;
                }
        }

        return arr;
    }
}

/*
Runtime
2 ms
Beats
36.67%
Memory
45.7 MB
Beats
6.97%

TC - O(log n)
SC - O(1)
 */