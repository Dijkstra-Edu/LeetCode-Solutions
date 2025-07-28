class LRUCache:
    class Node:
        def __init__(self, key=0, val=0):
            self.key = key
            self.val = val
            self.next = None
            self.prev = None

    def __init__(self, capacity: int):
        self.cap = capacity
        self.cache = {}  # key -> node
        
        # Create dummy head and tail nodes
        self.head = self.Node(-1, -1)
        self.tail = self.Node(-1, -1)
        self.head.next = self.tail
        self.tail.prev = self.head

    def add_node(self, new_node):
        """Add node right after head"""
        temp = self.head.next
        new_node.next = temp
        new_node.prev = self.head
        self.head.next = new_node
        temp.prev = new_node

    def delete_node(self, del_node):
        """Remove node from the list"""
        del_prev = del_node.prev
        del_next = del_node.next
        del_prev.next = del_next
        del_next.prev = del_prev

    def get(self, key: int) -> int:
        if key in self.cache:
            res_node = self.cache[key]
            result = res_node.val
            
            # Move to head (mark as recently used)
            del self.cache[key]
            self.delete_node(res_node)
            self.add_node(res_node)
            self.cache[key] = self.head.next
            
            return result
        return -1

    def put(self, key: int, value: int) -> None:
        if key in self.cache:
            # Update existing key
            existing_node = self.cache[key]
            del self.cache[key]
            self.delete_node(existing_node)
        
        if len(self.cache) == self.cap:
            # Remove LRU (tail.prev)
            lru_node = self.tail.prev
            del self.cache[lru_node.key]
            self.delete_node(lru_node)
        
        # Add new node
        new_node = self.Node(key, value)
        self.add_node(new_node)
        self.cache[key] = self.head.next
