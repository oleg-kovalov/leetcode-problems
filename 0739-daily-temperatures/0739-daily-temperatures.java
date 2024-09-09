class Solution {
    public int[] dailyTemperatures(int[] temperatures)
    {
        LinkedList<Integer> decreasingStack = new LinkedList<>();
        int[] result = new int[temperatures.length];

        decreasingStack.add(0);

        for (int i = 1; i < temperatures.length; i++)
        {

            while (decreasingStack.size() > 0 && temperatures[decreasingStack.peek()] < temperatures[i])
            {
                int lower = decreasingStack.pop();
                result[lower] = i - lower;

            }
            decreasingStack.push(i);

        }

        return result;
    }
}