class Solution {
    public boolean isValid(String s) {
        LinkedList<Character> bracketsStack = new LinkedList<>();

        for (int i=0; i < s.length(); i++)
        {
            Character current = s.charAt(i);
            if (Set.of('(','[','{').contains(current))
            {
                bracketsStack.push(current);
            }
            else if (current.equals(')') || current.equals(']') || current.equals('}'))
            {
                Character prevBracket = bracketsStack.peek();
                if (prevBracket == null)
                {
                    return false;
                }

                if (current.equals(getCloseBracket(prevBracket)))
                {
                    bracketsStack.pop();
                } else {
                    return false;
                }
            }
        }

        if (bracketsStack.peek() != null)
        {
            return false;
        }

        return true;
    }

    private Character getCloseBracket(Character openBracket)
    {
        if (openBracket.equals('(')) return ')';
        if (openBracket.equals('[')) return ']';
        if (openBracket.equals('{')) return '}';
        return null;
    }
}