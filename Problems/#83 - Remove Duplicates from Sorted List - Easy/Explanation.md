# Explanation of the `deleteDuplicates` Code

This Java class provides a solution to remove duplicate values from a sorted singly linked list. It ensures that each value appears only once in the resulting list.

---

## Class: `Solution`

### Method: `deleteDuplicates(ListNode head)`

#### **Purpose**
The method removes consecutive duplicate values from a sorted linked list.

#### **Parameters**
- `head`: The head node of the input linked list.

#### **Logic**
1. **Initialization**:
   - A pointer `current` is initialized to point to the `head` of the linked list.

2. **Iterative Traversal**:
   - While `current` is not `null` and `current.next` is not `null`:
     1. Check if the current node's value `current.val` is equal to the next node's value `current.next.val`:
        - If true, skip the next node by updating `current.next` to `current.next.next` (removing the duplicate).
        - If false, move the `current` pointer to the next node (`current = current.next`).

3. **Return the Updated List**:
   - Once all duplicates are removed, return the modified `head` of the linked list.

---

### Example Execution
#### Input:
A sorted linked list: `1 -> 1 -> 2 -> 3 -> 3`

#### Output:
The updated linked list: `1 -> 2 -> 3`

---

### Complexity Analysis
1. **Time Complexity**:
   - \(O(n)\): The list is traversed once, where \(n\) is the number of nodes.

2. **Space Complexity**:
   - \(O(1)\): No additional data structures are used. The operation modifies the list in place.

---

### Key Points
- This solution works only for **sorted linked lists**. If the input list is unsorted, the duplicates will not be removed correctly.
- The approach uses in-place modification, making it efficient in terms of space.

---

### Summary
The `deleteDuplicates` method is a simple yet efficient way to clean up a sorted linked list by removing consecutive duplicate nodes, preserving only unique values.

Time Complexity: O(n)
Space Complexity: O(1)