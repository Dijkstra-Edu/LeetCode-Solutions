class LRUCache {
    class Node {
        int key;
        int val;
        Node next;
        Node prev;
        
        Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }
    
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    int cap;
    HashMap<Integer, Node> cache;

    public LRUCache(int capacity) {
        cap = capacity;
        cache = new HashMap<>();
        head.next = tail;
        tail.prev = head;
    }
    
    private void addNode(Node newNode) {
        Node temp = head.next;
        newNode.next = temp;
        newNode.prev = head;
        head.next = newNode;
        temp.prev = newNode;
    }
    
    private void deleteNode(Node delNode) {
        Node delPrev = delNode.prev;
        Node delNext = delNode.next;
        delPrev.next = delNext;
        delNext.prev = delPrev;
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            Node resNode = cache.get(key);
            int result = resNode.val;
            cache.remove(key);
            deleteNode(resNode);
            addNode(resNode);
            cache.put(key, head.next);
            return result;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node existingNode = cache.get(key);
            cache.remove(key);
            deleteNode(existingNode);
        }
        if (cache.size() == cap) {
            Node lruNode = tail.prev;
            cache.remove(lruNode.key);
            deleteNode(lruNode);
        }
        addNode(new Node(key, value));
        cache.put(key, head.next);
    }
}
