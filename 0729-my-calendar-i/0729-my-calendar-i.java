class MyCalendar {

    STN root;

    public MyCalendar() {
        root = new STN(0, 1000_000_000, false);
    }
    
    public boolean book(int startTime, int endTime) {
        if (conflict(startTime, endTime - 1, root))
        {
            return false;
        } else {
            insert(startTime, endTime - 1, root, true);
            return true;
        }
    }

    private boolean conflict(int left, int right, STN node)
    {
        if (node.leftChild == null) return node.val;

        if (node.left == left && node.right == right)
        {
            return true;
        }

        int mid = node.left + (node.right - node.left) / 2;
        if (right <= mid)
        {
            return conflict(left, right, node.leftChild);
        } else if (left >= mid+1)
        {
            return conflict(left, right, node.rightChild);
        } else {
            return conflict(left, mid, node.leftChild)
                || conflict(mid+1, right, node.rightChild);
        }

    }

    private void insert(int left, int right, STN node, boolean val)
    {
        if (node.left == left && node.right == right)
        {
            node.val = val;
            node.leftChild = node.rightChild = null;
            return;
        }

        int mid = node.left + (node.right - node.left) / 2;

        if (node.leftChild == null)
        {
            node.leftChild = new STN(node.left, mid, node.val);
            node.rightChild = new STN(mid+1, node.right, node.val);
        }

        if (right <= mid)
        {
            insert(left, right, node.leftChild, val);
        } else if (left >= mid+1)
        {
            insert(left, right, node.rightChild, val);
        } else {
            insert(left, mid, node.leftChild, val);
            insert(mid+1, right, node.rightChild, val);
        }

        node.val = node.leftChild.val && node.rightChild.val;

    }

    class STN {
        STN leftChild;
        STN rightChild;

        int left;
        int right;
        boolean val;

        STN(int left, int right, boolean val)
        {
            this.left = left;
            this.right = right;
            this.val = val;
        }
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */