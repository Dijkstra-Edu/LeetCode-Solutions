# Second Smallest and Largest Elements Finder

Three approaches to find the second smallest and second largest elements in an array:

## Approaches

1. **Brute Force (Sorting)**
   - Sort the array and directly access the elements at index `1` (second smallest) and `n-2` (second largest).
   - **Time Complexity:** O(n log n)

2. **Better (Two Traversals)**
   - First pass: Find smallest and largest elements.
   - Second pass: Find second smallest and second largest by excluding the extremes.
   - **Time Complexity:** O(2n) → O(n)

3. **Optimal (Single Traversal)**
   - Track smallest, second smallest, largest, and second largest in a single pass.
   - **Time Complexity:** O(n)

## Test Cases

- **Case 1:** `[1, 2, 4, 6, 7, 5]` → Second smallest: `2`, Second largest: `6`
- **Case 2:** `[10, 10, 10]` → All elements same, returns `-1` for both.
- **Case 3:** `[5]` (Single element) → Returns `-1` for both.

Run the script to see outputs for all approaches.