import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//Attempt #1 - roughly 40 mins
class Solution {
    public int arrayPairSum(int[] nums) {
        if(nums.length%2 != 0)
            return 0;
        ArrayList<Integer> ans = new ArrayList<Integer>(nums.length - 1);
        
        func(nums, ans);
        
        for(int i=0; i<nums.length; i++)
        {
            for(int j=i+1; j<nums.length-1; j++)
            {
                if(nums[i]>nums[j])
                {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        //System.out.println(Arrays.toString(nums));
        
        func(nums, ans);
        
        for(int i=0; i<nums.length; i++)
        {
            for(int j=i+1; j<nums.length-1; j++)
            {
                if(nums[i]<nums[j])
                {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        
        func(nums, ans);
        //System.out.println(ans);
        
        return (Collections.max(ans));
    }
    
    public static void func(int nums[], ArrayList<Integer> x) {
        for(int i=0; i<nums.length; i++)//Rotate Array by one each time loop
        {
            int sum = 0;
            for(int j=0; j<nums.length-1; j+=2) 
            {
                //System.out.println(nums[j]+" "+nums[j+1]);
                sum+=((nums[j] < nums[j+1]) ? nums[j] : nums[j+1]);
                //System.out.println(sum);
            }
            //System.out.println(Arrays.toString(nums));
            x.add(sum);
            rotate(nums,nums.length);
        }
    }
    
    public static void rotate(int array[], int n) {
        int i, temp;
        // temporary array to store the newly created array
        temp = array[n - 1];
        for (i = n - 1; i > 0; i--)
            // shifts array element to the left by 1
            array[i] = array[i - 1];
        array[0] = temp;
    }
}
/*
35 Test Cases out of 83
Good Time Complexity tho
 */

//Solution:
/*
We are given a list of 2N2N integers. We need to group these integers into NN pairs such that 
the sum of minimum elements in all pairs is the maximum possible.

The key observation here is that if we have a pair like (a, b)(a,b) such that a \leq ba≤b, 
then we will add aa to the answer and bb cannot be used anymore. Therefore, in each such pair,
 we will add the value of the smaller element but the greater element will not contribute to 
 the answer.

Suppose xx is the smallest possible element in the given list. This means that the contribution 
to the answer for any pair that includes xx must be xx, irrespective of the paired element. The 
other element will essentially be wasted. Hence to minimize our losses, we would like to pair 
xx with the smallest element other than xx.

The number paired with xx will be the second smallest element in the given list. Hence, we will 
pair each element with the closest unpaired number in ascending sorted order. After sorting the 
given list, the first element can be paired with the second element, the third element can be 
paired with the fourth, and so on.
 */

class Solution2 {
    public int arrayPairSum(int[] nums) {
        // Sort the list in ascending order
        Arrays.sort(nums);
        // Initialize sum to zero
        int maxSum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            // Add every element at even positions (0-indexed)
            maxSum += nums[i];
        }
        return maxSum;
    }
}

/*
Runtime: 19 ms
Memory Usage: 54.4 MB
 */

//Attempt 2
class Solution3 {
    public int arrayPairSum(int[] nums) {
        if(nums.length%2 != 0)
            return 0;
        ArrayList<Integer> ans = new ArrayList<Integer>(nums.length - 1);
        
        func(nums, ans);
        
        for(int i=0; i<nums.length; i++)
        {
            for(int j=i+1; j<nums.length; j++)
            {
                if(nums[i]>nums[j])
                {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        //System.out.println(Arrays.toString(nums));
        
        func(nums, ans);

        //System.out.println(ans);
        
        return (Collections.max(ans));
    }
    
    public static void func(int nums[], ArrayList<Integer> x) {
        for(int i=0; i<nums.length; i++)//Rotate Array by one each time loop
        {
            int sum = 0;
            for(int j=0; j<nums.length-1; j+=2) 
            {
                //System.out.println(nums[j]+" "+nums[j+1]);
                sum+=((nums[j] < nums[j+1]) ? nums[j] : nums[j+1]);
                //System.out.println(sum);
            }
            //System.out.println(Arrays.toString(nums));
            x.add(sum);
            rotate(nums,nums.length);
        }
    }
    
    public static void rotate(int array[], int n) {
        int i, temp;
        // temporary array to store the newly created array
        temp = array[n - 1];
        for (i = n - 1; i > 0; i--)
            // shifts array element to the left by 1
            array[i] = array[i - 1];
        array[0] = temp;
    }
}

/*
71 Test Cases out of 83
Time exceeded - changing sorting algo

-- Fixed Ascending sort, removed descending sort --
 */ 

//Attempt 3 - with better sorting algo
class Solution4 {
    public int arrayPairSum(int[] nums) {
        if(nums.length%2 != 0)
            return 0;
        ArrayList<Integer> ans = new ArrayList<Integer>(nums.length - 1);
        
        //func(nums, ans);
        
        // for(int i=0; i<nums.length; i++)
        // {
        //     for(int j=i+1; j<nums.length; j++)
        //     {
        //         if(nums[i]>nums[j])
        //         {
        //             int temp = nums[i];
        //             nums[i] = nums[j];
        //             nums[j] = temp;
        //         }
        //     }
        // }
        //System.out.println(Arrays.toString(nums));
        
        Arrays.sort(nums);
        
        func(nums, ans);

        //System.out.println(ans);
        
        return (Collections.max(ans));
    }
    
    public static void func(int nums[], ArrayList<Integer> x) {
        for(int i=0; i<nums.length; i++)//Rotate Array by one each time loop
        {
            int sum = 0;
            for(int j=0; j<nums.length-1; j+=2) 
            {
                //System.out.println(nums[j]+" "+nums[j+1]);
                sum+=((nums[j] < nums[j+1]) ? nums[j] : nums[j+1]);
                //System.out.println(sum);
            }
            //System.out.println(Arrays.toString(nums));
            x.add(sum);
            rotate(nums,nums.length);
        }
    }
    
    public static void rotate(int array[], int n) {
        int i, temp;
        // temporary array to store the newly created array
        temp = array[n - 1];
        for (i = n - 1; i > 0; i--)
            // shifts array element to the left by 1
            array[i] = array[i - 1];
        array[0] = temp;
    }
}

/*
77 Test Cases out of 83
Time exceeded - changing sorting algo - O(nlogn)
 */ 

 //TAKE AWAY: Arrays.sort() - done in nlogn complexity, which is the best