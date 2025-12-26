# Longest Common Prefix

## Overview

The goal is to find the longest common prefix among an array of strings.

## Possible Approaches:

### 1. Lexicographic Sorting

1. Lexicographically sorting the array
2. Comparing the first and last of the sorted array for prefix.
3. Create an empty string called prefix.
4. Iteratively, go through the characters to add matching characters to the prefix string.
5. When there is a mismatch, end the loop and return the prefix string.

- Since we are lexicographically sorting the array, the first and last string are the most different. Finding the common prefix between the two, would be the longest common prefix for all the strings in the array between them.

#### Time Complexity

O(nlogn) because we sort the array, traversing the two strings will be done in O(n) time which is overshadowed by the worser time complexity O(nlogn).

#### Space Complexity

O(m) because we need to store a string of length m, where m is the length of the longest common prefix.

### 2. Iterative String Matching

1. Declare the prefix string to be the first string.
2. Compare the prefix string with the immediate next string to find the longest common prefix by removing elements from the prefix string.
3. Continue comparing with the next string with the reduced prefix string.
4. Ideally, the prefix string will keep reducing at each step, reducing the number of comparisons required at each step too.
5. Return the final prefix string.

#### Time Complexity:

O(m\*n) because we traverse n strings of average length m.

#### Space Complexity

O(m) where m is the length of the first string.
