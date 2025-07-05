Explanation (C solution):

## Two Sum II - Input Array is Sorted

### Difficulty : Easy
### Category : Arrays, Two pointer

Leetcode Link : https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

### Introduction 

Two Sum II, a slightly modified version of Two Sum I where we get a sorted array and a target. We need to find two numbers in the array such that they add up to the target and return their indices in 1-based indexing. 

### Intuition and Naive Approach/Brute Force

At first glance it seems simple. We could use two loops and check all the pairs and return the pair whose sum matches the target.

for(int i=0; i < n; i++) {
    for(int j=i+1; j < n; j++){
        if (num[i] + num[j] == target)
        return [i+1, j+1]
    }
}

While this would give us the result it would totally negate any advantage we have with the array being sorted and furthermore it would result in a time complexity of O(n^2)

Space complexity: O(1)

### Optimized Solution
The solution's optimized with the utilization of two pointers - at the start and end of the array respectively, let's say l and r.
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
Space complexity: O(1)

### Example
Numbers = [2, 7, 11, 15], target = 9

The working :

l = 0, r = 3 → 2 + 15 = 17 → sum larger than target, reduce right pointer

l = 0, r = 2 → 2 + 11 = 13 → sum larger than target, reduce right pointer

l = 0, r = 1 → 2 + 7 = 9 → sum equal → return [1, 2]

Output: [1, 2]