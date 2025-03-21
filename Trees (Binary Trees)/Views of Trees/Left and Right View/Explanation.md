Left View of tree.

Brute Force Approach:

1. Perform a complete level order traversal of the tree and maintain a matrix of all nodes visited by level.
2. Choose only the first element for each level and return.

Time Complexity: O(n)
Space Complexity: O(n)

Optimal Approach:

1. Perform DFS traversal of the tree prioritising the left subtree each time.
2. Take the first element of each level and return.

For right view, repeat the same but take the last element of the matrix or perform DFS with the right subtree prioritised.
