class BrowserHistory {

    class Node {
        String val;
        Node prev;
        Node next;

        public Node(String val) { this.val = val;}
    }

    Node current;

    public BrowserHistory(String homepage) {
        current = new Node(homepage);
    }
    
    public void visit(String url) {
        Node newPage = new Node(url);
        current.next = newPage;
        newPage.prev = current;
        current = current.next;
    }
    
    public String back(int steps) {
        for (int i=0; i<steps; i++)
        {
            if (current.prev == null) break;
            current = current.prev;
        }
        return current.val;
    }
    
    public String forward(int steps) {
        for (int i=0; i<steps; i++)
        {
            if (current.next == null) break;
            current = current.next;
        }

        return current.val;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */