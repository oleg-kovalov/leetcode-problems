class Solution {
    public int maximumGain(String s, int x, int y) {

        int points = 0;
        String sub1 = x > y ? "ab" : "ba";
        String sub2 = x > y ? "ba" : "ab";

        LinkedList<Character> stack = new LinkedList<>();
        StringBuilder firstBuilder = new StringBuilder();
        for (char ch: s.toCharArray())
        {
            if (ch - sub1.charAt(1) == 0
                && stack.peek() != null
                && stack.peek() - sub1.charAt(0) == 0)
            {
                stack.pop();
                points += Math.max(x, y);
            }
            else
            {
                stack.push(ch);
            }
        }

        while (stack.peek() != null)
        {
            firstBuilder.append(stack.pop());
        }

        String firstStr = firstBuilder.reverse().toString();
        // System.out.println("first string: " + firstBuilder.reverse().toString());

        stack = new LinkedList<>();
        StringBuilder secondBuilder = new StringBuilder();
        for (char ch: firstStr.toCharArray())
        {
            if (ch - sub2.charAt(1) == 0
                && stack.peek() != null
                && stack.peek() - sub2.charAt(0) == 0)
            {
                stack.pop();
                points += Math.min(x, y);
            }
            else
            {
                stack.push(ch);
            }
        }

        while (stack.peek() != null)
        {
            firstBuilder.append(stack.pop());
        }
        // System.out.println("result string: " + secondBuilder.toString());

        // System.out.println("points: " + points);
        return points;
    }
}