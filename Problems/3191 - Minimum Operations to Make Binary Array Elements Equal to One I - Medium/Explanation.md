# Explanation of the Code

## **Objective**
The program aims to count the minimum number of operations required to transform a binary array `nums` into a specific format where every element equals `1`. Each operation flips the value of three consecutive elements in the array (from `0` to `1` or vice versa).

---

## **Step-by-Step Explanation**

### **1. Initialize Variables**
```java
int n = nums.length;
int count = 0;

for (int i = 0; i <= n - 3; i++) {
    if (nums[i] == 0) {
        nums[i] = 1 - nums[i];
        nums[i + 1] = 1 - nums[i + 1];
        nums[i + 2] = 1 - nums[i + 2];
        count++;
    }
}
This loop checks each element nums[i] in the array until n - 3 (ensuring there are at least three consecutive elements remaining).

Condition (nums[i] == 0):

If the current element is 0, it is flipped, along with the next two consecutive elements.

This transformation ensures the first position of the current window becomes 1.

count is incremented to record the operation.

for (int i = n - 2; i < n; i++) {
    if (nums[i] != 1) {
        return -1;
    }
}
After completing transformations for three-element windows, the final two elements are checked:

If either of them is not 1, it means the target format cannot be achieved, and the function returns -1.

return count;
If all elements are transformed into 1, the function returns the total number of operations required.

Time Complexity
First Loop (for i = 0 to n - 3):

Iterates up to n - 3 elements, performing constant-time operations for each. Time Complexity: O(n)

Second Loop (for i = n - 2 to n):

Iterates over the last two elements of the array. Time Complexity: O(1)

Overall Time Complexity: O(n)

Space Complexity
The program modifies the input array nums in-place and uses only a few integer variables (n, count, i). No additional data structures are required.

Overall Space Complexity: O(1)