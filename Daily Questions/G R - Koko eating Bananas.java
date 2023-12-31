class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // Arrays.sort(piles); //O(nlogn)

        if (piles.length == 1)
            return (piles[0] / h) + 1;

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for (int x : piles) {
            low = Math.min(low, x);
            high = Math.max(high, x);
        }

        while (low <= high) {
            int mid = (high + low) / 2;
            int x = helper(piles, mid, h);
            // System.out.println(mid + " " + x);

            if (x > h)
                low = mid + 1;
            else
                high = mid - 1;
        }
        // System.out.println();
        // System.out.println(low + " " + high);

        return low;
    }

    public static int helper(int[] piles, int value, int h) {
        int count = 0;
        for (int pile : piles) {
            count += (pile - 1) / value + 1; // calculate the time required to eat this pile

            if (count > h) {
                break; // if the total time is greater than h, break the loop
            }
        }
        return count;
    }
}

/*
 * 11/123 test cases passed
 */

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();

        while (left < right) {
            int mid = (left + right) / 2;
            int time = 0;
            for (int pile : piles) {
                time += (pile - 1) / mid + 1; // calculate the time required to eat this pile

                if (time > h) {
                    break; // if the total time is greater than h, break the loop
                }
            }
            System.out.println(time + " " + mid);
            if (time > h) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}

/*
 * Runtime
 * 32 ms
 * Beats
 * 59.78%
 * Memory
 * 44.1 MB
 * Beats
 * 18.45%
 */

//Another Attempt - 20mins

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int result = Integer.MAX_VALUE;
    	
        int low = 1;
        int high = Arrays.stream(piles).max().getAsInt();
        //System.out.println(high);

        while (low <= high) {
            int mid = low + (high - low)/2;
            //System.out.println(" ITERATION " + low + " " + mid + " " + high);
            int time = 0;

            for(int pile : piles) {
                double val = (double)pile/(double)mid;
                time += Math.ceil(val);
                //System.out.println(time + " time" );
                if(time>h) break;
            }

            if(time > h) low = mid+1;
            else {
                result = Math.min(mid, result);
                high = mid-1;
            };
        }

        return result==Integer.MAX_VALUE ? -1 : result;
    }
}

//https://www.youtube.com/watch?v=U2SozAs9RzA

/*
Runtime
42 ms
Beats
20.59%
Memory
44.6 MB
Beats
5.15%
 */