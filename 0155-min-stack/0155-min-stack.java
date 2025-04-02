class MinStack {
    int[][] stack;
    int idx = -1;

    public MinStack() {
        stack = new int[30000][2];
    }
    
    public void push(int val) {
        int min = val;
        if (idx >= 0 && stack[idx][1] < min) min = stack[idx][1];

        idx += 1;
        stack[idx][0] = val;
        stack[idx][1] = min;
    }
    
    public void pop() {
        idx -= 1;
    }
    
    public int top() {
        return stack[idx][0];
    }
    
    public int getMin() {
        return stack[idx][1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */