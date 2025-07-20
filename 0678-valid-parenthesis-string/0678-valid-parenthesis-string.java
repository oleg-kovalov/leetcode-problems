class Solution {
    public boolean checkValidString(String s) {

        LinkedList<Integer> openStack = new LinkedList<>(); // positions of open brackets
        LinkedList<Integer> starStack = new LinkedList<>(); // positions of wildcards

        for (int i=0; i<s.length(); i++)
        {
            char c = s.charAt(i);
            if (c == '(')
            {
                openStack.push(i);
            } else if (c == ')')
            {
                if (openStack.size() > 0)
                {
                    openStack.pop();
                } else if (starStack.size() > 0)
                {
                    starStack.pop();
                } else {
                    return false;
                }
            } else {
                starStack.push(i);
            }
        }

        while (openStack.size() > 0)
        {
            int openPos = openStack.pop();
            if (starStack.size() == 0) return false;
            
            int starPos = starStack.pop();
            if (openPos > starPos) return false;
        }

        return true;
    }
}