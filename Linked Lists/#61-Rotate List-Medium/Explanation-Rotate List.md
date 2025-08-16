Rotate a list by k elements.

Very straightforward by connecting tail node to the head.

Find k mod n rotations by moving the head pointer, and then finally disconnecting the tail from the current head.

Time Complexity: O(n)
Space Complexity: O(1)
