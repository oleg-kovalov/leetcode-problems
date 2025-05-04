class LRUCache {

    class ListNode {
        int val;
        ListNode next;
        ListNode prev;

        ListNode(int val) { this.val = val; }
    }

    ListNode dummyHead = new ListNode(-1);
    ListNode dummyTail = new ListNode(-1);

    HashMap<Integer, ListNode> nodes = new HashMap<>();
    HashMap<Integer, Integer> values = new HashMap<>();
    int capacity;
 
    public LRUCache(int capacity) {
        this.capacity = capacity;

        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }
    
    public int get(int key) {
        int value = values.getOrDefault(key, -1);
        if (value == -1) return -1;

        moveToHead(nodes.get(key));

        return value;
    }
    
    public void put(int key, int value) {
        if (nodes.containsKey(key))
        {
            moveToHead(nodes.get(key));
            values.put(key, value);
        }
        else
        {
            if (nodes.size() == capacity)
            {
                evict();
            }

            ListNode added = new ListNode(key);
            addToHead(added);

            nodes.put(key, added);
            values.put(key, value);
        } 
    }

    private void evict() 
    {
        // evict least recently used node from tail
        ListNode evicted = dummyTail.prev;
        evicted.prev.next = dummyTail;
        dummyTail.prev = evicted.prev;

        nodes.remove(evicted.val);
        values.remove(evicted.val);
    }

    private void moveToHead(ListNode node)
    {
        // unbind node and put it at head
        node.prev.next = node.next;
        node.next.prev = node.prev;
        addToHead(node);
    }

    private void addToHead(ListNode node)
    {
        // put unbounded node at head
        node.next = dummyHead.next;
        dummyHead.next.prev = node;

        dummyHead.next = node;
        node.prev = dummyHead;
    }
}




/**
 * Your LRUCache object will ifbe instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */