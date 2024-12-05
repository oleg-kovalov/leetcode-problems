class LRUCache {

    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        public Node (int key, int val) {this.key = key; this.val = val; }
    }

    Node head;
    Node tail;

    int capacity;
    HashMap<Integer, Node> nodes;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        nodes = new HashMap<>(capacity);

        head = new Node(-10, -10);
        tail = new Node(-10, -10);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!nodes.containsKey(key)) return -1;

        Node node = nodes.get(key);
        // move node to the head
        moveToHead(node);

        return node.val;
    }
    
    public void put(int key, int value) {
        if (nodes.containsKey(key))
        {
            Node node = nodes.get(key);
            node.val = value;
            moveToHead(node);
        } else {
            if (nodes.size() == capacity)
            {
                Node evicted = tail.prev;
                evicted.prev.next = tail;
                tail.prev = evicted.prev;
                nodes.remove(evicted.key);
                System.out.println("removed " + evicted.key);
            }
            Node node = new Node(key, value);
            node.next = head.next;
            node.prev = head;

            head.next.prev = node;
            head.next = node;


            nodes.put(key, node);
        }
    }

    private void moveToHead(Node node)
    {
        node.prev.next = node.next;
        node.next.prev = node.prev;

        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */