class CustomStack {

    private int[] arr;
    private int index;
    private int maxSize;

    public CustomStack(int maxSize) {
        arr = new int[maxSize];
        this.maxSize = maxSize;
        index = 0;
    }
    
    public void push(int x) {
        if (index == maxSize) return;

        arr[index] = x;
        index += 1;
    }
    
    public int pop() {
        if (index == 0) return -1;
        
        
        return arr[--index];
    }
    
    public void increment(int k, int val) {
        for (int i=0; i<Math.min(k, index); i++)
        {
            arr[i] += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */