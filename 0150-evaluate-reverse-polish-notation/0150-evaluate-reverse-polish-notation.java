class Solution {
    public int evalRPN(String[] tokens) {
        HashMap<String, BiFunction<Integer, Integer, Integer>> operations = new HashMap<>();
        operations.put("+", (a,b) -> a + b);
        operations.put("-", (a,b) -> a - b);
        operations.put("*", (a,b) -> a * b);
        operations.put("/", (a,b) -> a / b);

        LinkedList<Integer> stack = new LinkedList<>();
        for (String s: tokens)
        {
            if (!operations.containsKey(s))
            {
                stack.push(Integer.parseInt(s));
            } else {
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push(operations.get(s).apply(num1, num2));
            }
        }

        return stack.pop();

    }
}