# Merge K Sorted Arrays Solution

## Overview

The goal of this solution is to merge k sorted arrays into a single sorted array.

## Possible Approaches

### 1. Sorting

- Create result array
- Append all elements of all k lists to the array
- Sort the array

#### Time Complexity

O((N*K)*log(N\*K)), K is number of arrays and N is average number of elements in the array

#### Space Complexity

O(N\*K)

Traversing all k lists, sorting the final list

### 2. Merge Sort

- Create a helper function that performs merge sort on two arrays using two pointers

- Call the function in pairs to effectively half the number of arrays every iteration.

- Return the output array

#### Time Complexity

O((N*K)*log(K))

Log(k) levels of recursion calls, and at each level, K arrays are traversed for merging.

#### Space Complexity

O((N*K)*log(K))

Log(k) levels and O(N\*K) space is required to store the answer every call.

### 3. Min Heap

- Most straightforward approach so far and the one implemented.
- Iterate through all of the k arrays and append to a min heap implemented by a priority queue.
- At each pass, append a single element from each array.
- Pop the min element and insert the next element from which the element is extracted. If empty, array is merged.
- Traverse the priority queue to store in a vector.
- Return the vector

#### Time Complexity

O((N*K)*log(k))

Min-heap of size k used. For insertion and removal of elements, the time complexity is N \* Klog(K).

#### Space Complexity

O(N\*K)

Min-heap of size K used, for arrays averaging N elements.
