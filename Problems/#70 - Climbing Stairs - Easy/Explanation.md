# Explanation of the `climbStairs` Code

This Java class provides a solution to the classic "Climbing Stairs" problem using dynamic programming. The goal is to determine the number of distinct ways to climb a staircase with `n` steps, where you can take either 1 step or 2 steps at a time.

---

## Class: `Solution`

### Method: `climbStairs(int n)`

#### **Purpose**
This method calculates the number of ways to climb a staircase with `n` steps.

#### **Parameters**
- `n`: An integer representing the total number of steps in the staircase.

#### **Logic**
1. **Base Cases**:
   - If `n == 1`, return `1` since there is only one way to climb a single step.
   - If `n == 2`, return `2` since there are two ways to climb two steps: either `1+1` or `2`.

2. **Dynamic Programming Array**:
   - Create an integer array `a` of size `n`.
   - Initialize the first two elements:
     - `a[0] = 1` (1 way to climb 1 step).
     - `a[1] = 2` (2 ways to climb 2 steps).

3. **Iterative Calculation**:
   - Use a loop from `i = 2` to `n - 1`:
     - For each step `i`, calculate the number of ways to reach it as the sum of the ways to reach the previous two steps:
       

\[
       a[i] = a[i - 1] + a[i - 2]
       \]


   - This is based on the observation that to reach step `i`, you can either:
     - Take one step from `i - 1` (contributing `a[i - 1]` ways).
     - Take two steps from `i - 2` (contributing `a[i - 2]` ways).

4. **Return Result**:
   - Return `a[n - 1]`, which contains the total number of ways to climb `n` steps.

---

### Example Execution
#### Input:
```java
int n = 5;

Time Complexity: O(n)
Space Complexity: O(n)