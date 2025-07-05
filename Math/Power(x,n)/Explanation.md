# Problem 50 : Power(x,n)
### Difficulty : Medium
### Category : Math
### Explanation (C implementation)

Leetcode Link : https://leetcode.com/problems/powx-n/

### Introduction
The goal is to implement pow(x, n), which calculates x raised to the power n (i.e., x^n), without using in-built functions

### Brute Force or Naive Approach

This is simple logic, we can just multiply x by itself n times, can't we?

double myPow(double x, int n) {

    double result = 1;
    for (int i = 0; i < n; i++)
    {
        result = result * x;
    }
    return result;
}

Time Complexity: O(n)
Space Complexity: O(1)

The logic is sound but it is inefficient for larger values of n and will lead to a Time Limit Exceeded Error in LeetCode

### Optimized Approach
1. Taking care of the base cases:
x^0 == 1 : any number raised to 0 is 1
1^n == 1 : 1 raised to any number is 0

2. Negative numbers
Convert them to a positive number by multiplying with -1
Take the reciprocal because x^-1 == 1/x^n

3. Binary Exponentiation
Multiplying x by itself (i.e x.x.x) n number of times would take O(n) time yielding nothing but a TimeLimitExceeded Error
Instead, we take a mathematical route.

If n is even: x^n=(x^n/2)^2 (in the code : z = z/2)

If n is odd: x^n= x.x^n−1 (in the code : z = z-1)

Example 1 : x^8. Instead of multiplying x by itself 8 times. We can do:
x^8=(x^4)^2
x^4=(x^2)^2
x^2=(x^1)^2

Example 2 : x^5.
x^5=x.(x^4) (notice the n-1)
x^4=(x^2)^2
x^2=(x^1)^2

#### Result:
Time Complexity : O(log n)
Space Complexity : O(1)

### Example:
x = 2 and n = 8

2^8 = (2^4)^2
2^4 = (2^2)^2
2^2 = (2^1)^2

Result = 256
