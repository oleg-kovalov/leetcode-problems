class Solution {
    public String reverseParentheses(String s)
    {

        LinkedList<Integer> stack = new LinkedList<>();

        final List<Character> chars = s.chars().mapToObj(c -> (char) c).collect(Collectors.toList());

        for (int i = 0; i < chars.size(); i++)
        {
            char ch = chars.get(i);
            if ('(' - ch == 0)
            {
                stack.push(i); // save index of opening bracket
            }
            else if (')' - ch == 0)
            {
                int openbr = stack.pop();
                int closebr = i;

                int start = openbr + 1;
                int end = closebr - 1;
                while (start < end)
                {
                    char temp = chars.get(start);
                    chars.set(start, chars.get(end));
                    chars.set(end, temp);

                    start++;
                    end--;
                }
                
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < chars.size(); i++)
        {
            char ch = chars.get(i);
            if (('(' - ch != 0) && (')' - ch != 0))
            {
                result.append(ch);
            }

        }

        return result.toString();
    }
}