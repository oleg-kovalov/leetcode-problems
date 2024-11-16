class MinStack {

    LinkedList<Integer> mainStack = new LinkedList<>();
    LinkedList<Integer> minStack = new LinkedList<>();

    public MinStack() {

    }

    public void push(int val) {
        mainStack.push(val);
        if (minStack.peek() == null || minStack.peek() >= val) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (mainStack.size() == 0)
            return;

        int popped = mainStack.pop();
        if (minStack.peek() == popped) {
            minStack.pop();
        }
    }

    public int top() {
        return mainStack.peek();
    }

    public int getMin() {
        return minStack.peek();
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