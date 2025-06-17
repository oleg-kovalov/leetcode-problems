class NumArray {
    
    class SegTreeNode {
        SegTreeNode leftChild;
        SegTreeNode rightChild;

        int left;
        int right;
        int sum;

        SegTreeNode (int left, int right)
        {
            this.left = left;
            this.right = right;
        }
    }

    SegTreeNode root;

    public NumArray(int[] nums) {
        root = buildSegTree(0, nums.length-1, nums);
    }

    private SegTreeNode buildSegTree(int left, int right, int[] nums)
    {
        if (left == right)
        {
            SegTreeNode node = new SegTreeNode(left, right);
            node.sum = nums[left];
            return node;
        }

        int mid = (left + right) / 2;

        SegTreeNode node = new SegTreeNode(left, right);        
        node.leftChild = buildSegTree(left, mid, nums);
        node.rightChild = buildSegTree(mid+1, right, nums);
        node.sum = node.leftChild.sum + node.rightChild.sum;
        
        return node;
    }


    
    public void update(int index, int val) {
        update(index, val, root);
    }
    
    private void update(int index, int val, SegTreeNode node)
    {
        if (node.left == node.right)
        {
            node.sum = val;
            return;
        }

        int mid = (node.left + node.right) / 2;
        if (index <= mid)
        {
            update(index, val, node.leftChild);
        } else {
            update(index, val, node.rightChild);
        }

        node.sum = node.leftChild.sum + node.rightChild.sum;
    }


    
    public int sumRange(int left, int right) {
        return sumRange(left, right, root);
    }

    private int sumRange(int left, int right, SegTreeNode node)
    {
        if (left == node.left && right == node.right) return node.sum;

        int mid = (node.left + node.right) / 2;
     
        if (right <= mid)
        {
            return sumRange(left, right, node.leftChild);
        } else if (left >= mid + 1)
        {
            return sumRange(left, right, node.rightChild);
        } else {
            return sumRange(left, mid, node.leftChild) 
                + sumRange(mid + 1, right, node.rightChild);
        }
    }

}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */