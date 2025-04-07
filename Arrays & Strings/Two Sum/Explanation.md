Explanation (C solution):

Two Sum II, a slightly modified version of Two Sum I where we get a sorted array. 
The solution's straightforward with the utilization of two pointers - at the start and end of the array respectively, let's say l and r.
We move inwards into the array until our start and end pointers don't cross over i.e left > right.
We check if the value at array[l] + array[r] (which is our sum) == target.

Since it's a sorted array. If: 
1. Sum is greater than Target
-Then we know we need a smaller value to match or get close to the target, hence we decrease the end pointer , pointing to a smaller value (second largest value and so on..).
2. Sum is lesser than Target
-Then we need a larger value to match or get close to the target, hence we increase the start pointer, pointing to a larger value(second smallest value and so on..).

If Sum is equal to our target:
-Store the indexes of the two values in the malloced array (dynamic array since we can't directly return two values from a function in C)
-We've increased the index by 1 to facilitate 1-based indexing as given in the problem.
-Return the malloced array.

Time Complexity: O(n)