class Solution {
    public boolean isValid(String s) {

        LinkedList<Character> stack = new LinkedList<>();

        for (int i=0; i<s.length(); i++)
        {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[')
            {
                stack.push(c);
            } else {
                if (stack.size() == 0) return false;
                char pop = stack.pop();
                if (c == ')' && pop != '(') return false;
                if (c == '}' && pop != '{') return false;
                if (c == ']' && pop != '[') return false;
            }
        }

        return stack.size() == 0;

    }
}