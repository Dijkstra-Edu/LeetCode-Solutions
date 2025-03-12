Simple question of finding an element whose frequency is greater than half of the size of the array.

Three possible methods:

1. Sorting:

- Time Complexity: O(nlogn)
- Space Complexity: O(1)

Simply sort the array and the middle element should always be the majority element.

2. Hashmap:

- Time Complexity: O(n)
- Space Complexity: O(n)

Map the frequencies of the elements to a hashmap and return the element with the highest frequency.

3. Moore's Voting Algorithm:

- Time Complexity: O(n)
- Space Complexity: O(1)

Initialise count and candidate element. If the element is the candidate element, increment count. Else if count is 0, change the candidate element to be the current element, else decrement the count.

Works on the principle that upon complete iteration of the array, the majority element should always have the highest count and therefore end up being the candidate element all the time.
