To solve this question,

1. We find the first decreasing element from the right calling it the pivot.
2. We check if that element does not exist, which means that the array is sorted in non-ascending order, hence we just return a reversed array.
3. If the element exists, we find the smallest element greater than the pivot element which is to the right of it.
4. We swap the two elements.
5. We reverse the suffix of the pivot element to obtain the answer.
