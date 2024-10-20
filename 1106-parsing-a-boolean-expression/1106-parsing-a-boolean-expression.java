class Solution {
    class Node {
        char val;

        Node prev;
        Node next;

        public Node (char val) { this.val = val; }
    }

    public boolean parseBoolExpr(String expression) {
        Node head = new Node('_');

        Node curr = head;
        for (char c: expression.toCharArray())
        {
            Node next = new Node(c);
            curr.next = next;
            next.prev = curr;

            curr = next;
        }


        LinkedList<Node> bracketsStack = new LinkedList<>();
        curr = head;
        while (head.next.next != null)
        {
            if (curr.val == '(')
            {
                bracketsStack.push(curr);
            }
            else if (curr.val == ')')
            {
                Node closeBracket = curr;
                Node openBracket = bracketsStack.pop();
                Node operation = openBracket.prev;
                boolean subResult = openBracket.next.val == 't';
                if (operation.val == '!')
                {
                    subResult = !subResult;
                } else {
                    Node sub = openBracket.next.next;
                    while (sub != closeBracket)
                    {
                        if (sub.val != ',') {
                            if (operation.val == '&')
                            {
                                subResult &= (sub.val == 't');
                            } else if (operation.val == '|')
                            {
                                subResult |= (sub.val == 't');
                            }
                        }

                        sub = sub.next;
                    }
                }

                // replace subexpression with its result at the index of operation
                Node subResultNode = new Node(subResult ? 't' : 'f');
                subResultNode.prev = operation.prev;
                operation.prev.next = subResultNode;

                subResultNode.next = curr.next;
                if (curr.next != null) curr.next.prev = subResultNode;

            }

            curr = curr.next;
        }

        return head.next.val == 't';

    }
}