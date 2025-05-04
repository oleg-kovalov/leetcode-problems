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

        // move used node to the head
        ListNode used = nodes.get(key);
        used.prev.next = used.next;
        used.next.prev = used.prev;

        used.next = dummyHead.next;
        dummyHead.next.prev = used;
        dummyHead.next = used;
        used.prev = dummyHead;

        return value;
    }
    
    public void put(int key, int value) {
        if (nodes.containsKey(key))
        {
            values.put(key, value);
        }
        else
        {
            if (nodes.size() == capacity)
            {
                // evict least recently used node from tail
                ListNode evicted = dummyTail.prev;
                evicted.prev.next = dummyTail;
                dummyTail.prev = evicted.prev;

                nodes.remove(evicted.val);
                values.remove(evicted.val);
            }

            ListNode added = new ListNode(key);
            added.next = dummyHead.next;
            dummyHead.next.prev = added;

            dummyHead.next = added;
            added.prev = dummyHead;

            nodes.put(key, added);
            values.put(key, value);
        } 
    }
}




/**
 * Your LRUCache object will ifbe instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */