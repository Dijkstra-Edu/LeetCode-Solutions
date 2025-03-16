Relatively simple problem, to find the longest common prefix among an array of strings.

Approach implemented involves:

1. Lexicographically sorting the array
2. Comparing the first and last of the sorted array for prefix.
3. Iteratively, go through the characters to check when corresponding characters don't match
4. Return the prefix.

Time Complexity: O(nlogn)
Space Complexity: O(m)

Another possible approach could be:

1. Declare the prefix string to be the first string.
2. Compare with the immediate next string to find the prefix, by reducing the prefix string correspondingly.
3. Continue comparing strings till the end
4. Return the prefix

Time Complexity: O(m\*n)
Space Complexity: O(len(array[0]))
