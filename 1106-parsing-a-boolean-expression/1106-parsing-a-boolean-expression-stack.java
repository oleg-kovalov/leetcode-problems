class Solution {

    public boolean parseBoolExpr(String expression) {
        LinkedList<Character> stack = new LinkedList<>();

        for (char c: expression.toCharArray())
        {
            if (c == ')')
            {
                boolean seenTrue = false;
                boolean seenFalse = false;
                char curr = c;
                while (curr != '!' && curr != '|' && curr != '&')
                {
                    if (curr == 't' || curr == 'f')
                    {
                        seenTrue |= (curr == 't');
                        seenFalse |= (curr == 'f');
                    }
                    curr = stack.pop();
                }
                if (curr == '!')
                {
                    stack.push(seenTrue ? 'f' : 't');
                }
                else if (curr == '|')
                {
                    stack.push(seenTrue ? 't' : 'f');
                } else {
                    // &
                    stack.push(seenFalse ? 'f' : 't');
                }
            } else {
                stack.push(c);
            }
        }

        return stack.pop() == 't' ? true : false;
    }
}