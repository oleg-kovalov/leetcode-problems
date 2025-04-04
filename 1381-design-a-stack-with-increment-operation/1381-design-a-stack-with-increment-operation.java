class CustomStack {

    private int[] arr;
    private int[] incr;
    private int index;


    public CustomStack(int maxSize) {
        arr = new int[maxSize];
        incr = new int[maxSize];
        index = 0;
    }
    
    public void push(int x) {
        if (index == arr.length) return;

        arr[index] = x;
        index += 1;
    }


    //"CustomStack","pop","pop","pop","pop","pop","pop","pop","pop","increment","push","increment","pop","pop","increment","pop","pop","increment","increment","pop","pop","pop","increment","pop","increment","increment","pop","increment","push","pop"

    public int pop() {
        if (index == 0) return -1;

        index -= 1;
        int inc = incr[index];
        incr[index] = 0;
        if (index > 0)
        {
            incr[index - 1] += inc;
        }

        return arr[index] + inc;
    }
    
    public void increment(int k, int val) {
        if (index == 0) return;

        incr[Math.min(k, index) - 1] += val;
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */