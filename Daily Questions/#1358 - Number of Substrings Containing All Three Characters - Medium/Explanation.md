# Solution Explanation

## Purpose
The code is designed to count the number of substrings that contain all three characters 'a', 'b', and 'c' at least once.

## Code Breakdown

### Initialization
```java
HashMap<Character, Integer> freq = new HashMap<>();
int left = 0, cnt = 0;

Time complexity: O(n)
Space complexity: O(n)