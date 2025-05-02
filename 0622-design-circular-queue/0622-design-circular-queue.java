class MyCircularQueue {

    class ListNode {
        int val;
        ListNode next;
        ListNode prev;

        ListNode(int val) { this.val = val; }
    }

    int k;
    int size = 0;
    ListNode dummyHead;
    ListNode dummyTail;


    public MyCircularQueue(int k) {
        this.k = k;

        dummyHead = new ListNode(-1);
        dummyTail = new ListNode(-1);
        dummyHead.prev = dummyTail;
        dummyTail.next = dummyHead;
    }
    
    public boolean enQueue(int value) {
        if (size == k) return false;
        
        ListNode node = new ListNode(value);
        node.next = dummyTail.next;
        dummyTail.next = node;

        node.next.prev = node;
        node.prev = dummyTail;
        size += 1;
        return true;
    }
    
    public boolean deQueue() {
        if (size == 0) return false;
        ListNode node = dummyHead.prev;

        dummyHead.prev = node.prev;
        node.prev.next = dummyHead;

        size -= 1;
        return true;
    }
    
    public int Front() {
        return dummyHead.prev != null ? dummyHead.prev.val : -1;
    }
    
    public int Rear() {
        return dummyTail.next != null ? dummyTail.next.val : -1;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == k;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */