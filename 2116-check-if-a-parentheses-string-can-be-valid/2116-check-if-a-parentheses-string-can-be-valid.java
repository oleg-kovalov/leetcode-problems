class Solution {
    public boolean canBeValid(String s, String locked) {
        if (s.length() % 2 != 0) return false;

        LinkedList<Integer> openStack = new LinkedList<>();
        LinkedList<Integer> unlockedStack = new LinkedList<>();

        for (int i=0; i<s.length(); i++)
        {
            char c = s.charAt(i);
            if (locked.charAt(i) == '0')
            {
                unlockedStack.push(i);
            } else {
                if (s.charAt(i) == '(')
                {
                    openStack.push(i);
                } else {
                    if (openStack.size() > 0) {
                        openStack.pop();
                    } else {
                        if (unlockedStack.size() > 0)
                        {
                            unlockedStack.pop();
                        } else {
                            return false;
                        }
                    }
                }
            }
        }

        while (openStack.size() > 0 && unlockedStack.size() > 0 && openStack.peek() < unlockedStack.peek())
        {
            openStack.pop();
            unlockedStack.pop();
        }        

        return openStack.size() == 0;
        
    }
}