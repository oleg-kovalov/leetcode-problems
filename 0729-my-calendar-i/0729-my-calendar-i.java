class MyCalendar {

    STN root;

    public MyCalendar() {
        root = new STN(0, 1000_000_000);
    }
    
    public boolean book(int startTime, int endTime) {
        if (conflict(startTime, endTime - 1, root))
        {
            return false;
        } else {
            insert(startTime, endTime - 1, root);
            return true;
        }
    }

    private boolean conflict(int left, int right, STN node)
    {
        if (node == null) return false;

        // if this is leaf node, then we have inserted interval earlier
        // now we have conflict with current interval that is same or smaller than existing 
        // this shortcut allows to pass TLE 
        if (node.leftChild == null && node.rightChild == null) 
            return node.val;


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

    private void insert(int left, int right, STN node)
    {
        // we don't break interval to smallest possible parts but try to insert it as is
        // if it fits current tree structure, only breaking if necessary
        // this shortcut allows to pass TLE 
        if (node.left == left && node.right == right)
        {
            node.val = true;
            return;
        }

        int mid = node.left + (node.right - node.left) / 2;

        if (right <= mid)
        {
            if (node.leftChild == null) node.leftChild = new STN(node.left, mid);
            insert(left, right, node.leftChild);
        } else if (left >= mid+1)
        {
            if (node.rightChild == null) node.rightChild = new STN(mid+1, node.right);
            insert(left, right, node.rightChild);
        } else {
            if (node.leftChild == null) node.leftChild = new STN(node.left, mid);
            insert(left, mid, node.leftChild);
            if (node.rightChild == null) node.rightChild = new STN(mid+1, node.right);
            insert(mid+1, right, node.rightChild);
        }

        node.val = (node.leftChild == null ? false : node.leftChild.val) 
            || (node.rightChild == null ? false: node.rightChild.val);

    }

    class STN {
        STN leftChild;
        STN rightChild;

        int left;
        int right;
        boolean val;

        STN(int left, int right)
        {
            this.left = left;
            this.right = right;
        }
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */