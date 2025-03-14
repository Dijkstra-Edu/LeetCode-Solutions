Goal was to create a deep copy of a linked list with a random pointer along with the next pointer.

Initial approach was to create a vector of the linked list to be able to map indices to each of the nodes.
Then a hashmap to map the Node to its corresponding index.
Then a vector to store the new nodes.
Then a hashmap to map the indices of the new nodes to their indices.
Finally the random pointer of each node would be mapped to the corresponding index of the prev list, using both hashmaps.

Optimal approach is to use a single hashmap to just
map old node to new node in the first traversal.
Second traversal to find the next and random pointers of the new nodes based on the values of the old node keys.

Interweaved approach creates new nodes and inserts them in the new list.
By traversing the interweaved list, we can assign the next node of the old node's random pointer to the new node's random pointer. One more traversal would be required to separate the two. However, I haven't implemented that approach here.
