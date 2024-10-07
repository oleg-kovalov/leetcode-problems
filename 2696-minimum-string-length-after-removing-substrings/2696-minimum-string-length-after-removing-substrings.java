class Solution {
    public int minLength(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        StringBuilder result = new StringBuilder();

        for (char c: s.toCharArray())
        {
            if (c - 'A' == 0 || c - 'C' == 0)
            {
                stack.push(c);
                continue;
            } 

            if (stack.size() == 0)
            {
                result.append(c);
                continue;
            }
            
            char top = stack.peek();
            if ((top - 'A' == 0 && c - 'B' == 0) || (top - 'C' == 0 && c - 'D' == 0))
            {
                stack.pop();
                continue;
            }
            
            result.append(popStack(stack));
            result.append(c);
        }

        result.append(popStack(stack));

        return result.toString().length();
    }

    private String popStack(LinkedList<Character> stack)
    {
        StringBuilder stackString = new StringBuilder();
        while (stack.size() > 0)
        {
            stackString.append(stack.pop());
        }
        return stackString.reverse().toString();
    }
}