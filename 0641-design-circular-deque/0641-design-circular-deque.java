    class MyCircularDeque {

        Node head = null;
        Node tail = null;
        int size = 0;
        int maxSize;

        public MyCircularDeque(int k) {
            maxSize = k;
        }

        public boolean insertFront(int value) {
            System.out.printf("insert front %s \n", value);
            if (size == maxSize) return false;

            if (head == null)
            {
                head = new Node(value, null, null);
                tail = head;
            } else {
                Node newHead = new Node(value, null, head);
                head.prev = newHead;
                head = newHead;
            }

            size += 1;
            return true;
        }

        public boolean insertLast(int value) {
            System.out.printf("insert last %s \n", value);
            if (size == maxSize) return false;

            if (tail == null)
            {
                tail = new Node(value, null, null);
                head = tail;
            } else {
                Node newTail = new Node(value, tail, null);
                tail.next = newTail;
                tail = newTail;
            }

            size += 1;
            return true;
        }

        public boolean deleteFront() {
            System.out.println("delete front");
            if (size == 0) return false;

            if (size == 1)
            {
                head = null;
                tail = null;
            } else {
                Node oldHead = head;
                head = head.next;
                head.prev = null;
                oldHead.next = null;
            }

            size -= 1;
            return true;
        }

        public boolean deleteLast() {
            System.out.println("delete front");
            if (size == 0) return false;

            if (size == 1)
            {
                head = null;
                tail = null;
            } else {
                Node oldTail = tail;
                tail = tail.prev;
                tail.next = null;
                oldTail.prev = null;
            }

            size -= 1;
            return true;
        }

        public int getFront() {
            System.out.println("get front");
            if (head == null) return -1;
            return head.val;
        }

        public int getRear() {
            System.out.println("get rear");
            if (tail == null) return -1;
            return tail.val;
        }

        public boolean isEmpty() {
            System.out.println("is empty");
            return size == 0;
        }

        public boolean isFull() {
            System.out.println("is full");
            return size == maxSize;
        }


    }

    class Node {
        int val;
        Node prev;
        Node next;

        Node (int val, Node prev, Node next)
        {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }