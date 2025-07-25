# Invert Binary Tree

**Difficulty**: Easy  
**Category**: Trees, Recursion, Binary Tree  
**Leetcode Link**: [https://leetcode.com/problems/invert-binary-tree/](https://leetcode.com/problems/invert-binary-tree/)

---

## 📝 Introduction

The **Invert Binary Tree** problem asks us to take a binary tree and **invert** it. 

Given the `root` of a binary tree, our goal is to return the **root of the inverted tree**.

**Expected Output**: Return the root of the new inverted tree (mirror image of the original).

---

## 💡 Approach & Key Insights

The key insight is that at each node in the binary tree, we need to **swap** the left and right child. We can do this using:
- **Recursion** (Depth-First Traversal)
- **Iteration** using a Queue (Breadth-First Traversal)

It's essentially a tree traversal problem and the recursive solution felt like the intuitive approach.

---

## 🛠️ Breakdown of Approaches

### 1️⃣ Brute Force / Naive Approach

#### Explanation:
- Traverse the tree using any traversal (preorder/inorder/postorder).
- For each node, store left and right subtrees separately.
- Reconstruct the tree manually by reassigning children in inverted order.
- This is impractical and complex for a simple task.

#### Time Complexity:
`O(n)` – We still visit every node once.

#### Space Complexity:
`O(n)` – We use space to store and reconstruct the tree.

#### Example/Dry Run:

> ⚠️ Skipping detailed dry run as this approach is rarely used in practice for this problem.

---

### 2️⃣ Optimized Approach (Recursive DFS)

#### Explanation:
- If the root is `NULL`, return `NULL`.
- Recursively invert the left and right subtrees.
- Swap the left and right pointers at the current node.
- Return the node.

```c
struct TreeNode* invertTree(struct TreeNode* root) {
    if (root == NULL)
        return NULL;

    struct TreeNode* temp = root->right;
    root->right = root->left;
    root->left = temp;

    invertTree(root->right);
    invertTree(root->left);

    return root;
}
```

#### Time Complexity:
`O(n)` – Every node is visited exactly once.

#### Space Complexity:
`O(h)` – Due to the recursion stack. *h* is the height of the tree (O(log n) for balanced, O(n) for skewed).

#### Example/Dry Run:

Example Input (Tree):
```
    1
   / \
  2   3
 / \
4   5
```

Step-by-step:
- At node 1: swap 2 and 3.
- Recurse into 3 and 2.
- At node 2: swap 4 and 5.
- Final inverted tree:
```
    1
   / \
  3   2
     / \
    5   4
```

---

### 3️⃣ Best / Final Optimized Approach (Iterative BFS)

#### Explanation:
- Use a queue to traverse the tree level by level.
- At each node, swap the left and right children.
- Enqueue non-null children for further processing.

```c
struct TreeNode* invertTree(struct TreeNode* root) {
    if (root == NULL)
        return NULL;

    struct TreeNode* queue[100];
    int front = 0, rear = 0;
    queue[rear++] = root;

    while (front < rear) {
        struct TreeNode* node = queue[front++];

        struct TreeNode* temp = node->left;
        node->left = node->right;
        node->right = temp;

        if (node->left) queue[rear++] = node->left;
        if (node->right) queue[rear++] = node->right;
    }

    return root;
}
```

#### Time Complexity:
`O(n)` – Each node is visited once.

#### Space Complexity:
`O(n)` – In the worst case, all nodes may be in the queue (for a full binary tree).

#### Example/Dry Run:

Input Tree:
```
    1
   / \
  2   3
```

- Queue: [1]
- Process 1 → Swap 2 & 3
- Queue: [3, 2]
- Process 3 → Swap NULLs
- Process 2 → Swap NULLs

Final Tree:
```
    1
   / \
  3   2
```

---

## 📊 Complexity Analysis

| Approach         | Time Complexity | Space Complexity |
|------------------|------------------|-------------------|
| Brute Force      | O(n)             | O(n)              |
| Optimized (DFS)  | O(n)             | O(h)              |
| Best (BFS)       | O(n)             | O(n)              |

---

## 📉 Optimization Ideas

- For deep trees where recursion depth could cause stack overflow, use **iterative BFS**.
- If modifying the original tree is not allowed, we could clone and then invert, but that increases space usage.

---

## 📌 Example Walkthroughs & Dry Runs

### Input Tree:
```
    4
   / \
  2   7
 / \/ \
1  3 6  9
```

### Process:
- Swap 2 & 7 → Recurse
- Swap 1 & 3 in subtree of 2
- Swap 6 & 9 in subtree of 7

### Output Tree:
```
    4
   / \
  7   2
 / \/ \
9  6 3  1
```

---

## 🔗 Additional Resources

- [YouTube: NeetCode - Invert Binary Tree](https://www.youtube.com/watch?v=OnSn2XEQ4MY)
- [Binary Tree Traversal Explanation](https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/)

---

**Author**: hanzel-sc  
**Date**: 25/07/2025