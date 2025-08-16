# Comprehensive Explanations of Programs

---

## **Program 1: Longest Nice Subarray**

### **Objective**
The goal of the program is to find the length of the longest "nice" subarray within the input array `nums`. A subarray is considered "nice" if the bitwise AND operation between every pair of elements in the subarray results in `0`. The program efficiently calculates this using a sliding window approach.

---

### **Step-by-Step Explanation**

#### **1. Initialize Variables**
int maxLength = 1, left = 0, usedBits = 0;

#### **2. Iterate Over the Array**
for (int right = 0; right < nums.length; right++) {
    while ((usedBits & nums[right]) != 0) {
        usedBits ^= nums[left++];
    }
    usedBits |= nums[right];
    maxLength = Math.max(maxLength, right - left + 1);
}
Outer Loop (for): Iterates through each element of the array using the right pointer, which represents the end of the current window.

Inner Loop (while):
(usedBits & nums[right]) != 0: Checks if adding the current element (nums[right]) to the subarray would result in a bitwise AND operation that is non-zero, which violates the "nice" condition.

usedBits ^= nums[left++]: Removes the element at the left pointer from the subarray by performing a bitwise XOR, effectively shrinking the window from the left until the subarray is "nice" again.

Update Subarray:
usedBits |= nums[right]: Adds the current element (nums[right]) to the subarray by updating the usedBits variable using a bitwise OR operation.

maxLength = Math.max(maxLength, right - left + 1): Updates the maximum length of the "nice" subarray encountered so far.

Make DSU of size n by using edges vector.After thet we will have each node parent as if nodes are in same component then parent will be same else parent will be different.

After that we will precompute AND for all nodes and store it in ands vector.
One crucial thing is that we will store AND of component at component's main node(parent) index in ands vector.

Final step: If parent of both query node is same then store AND of that component in ans vector.else store -1.

Complexity
Time complexity: O(E+Q)
E : Size of edges vector
Q : Size of query vector

Space complexity:O(N)
N : No. of nodes