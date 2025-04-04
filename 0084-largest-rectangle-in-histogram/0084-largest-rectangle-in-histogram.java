class Solution {
    public int largestRectangleArea(int[] heights) {

        LinkedList<int[]> stack = new LinkedList<>(); // non-decreasing
        stack.push(new int[] {heights[0], 0}); // 1,0 2,2 3,5  

        int result = 0;

        for (int i=1; i<heights.length; i++)
        {
            if (stack.size() == 0) {
                stack.push(new int[] {heights[i], i});
                continue;
            }

            if (heights[i] >= stack.peek()[0])
            {
                stack.push(new int[] {heights[i], i});
                continue;
            } else {
                int prevIdx = i - 1; //3
                int lastIdx = stack.peek()[1]; //2

                while (stack.size() > 0 && heights[i] < stack.peek()[0])
                {
                    int[] pop = stack.pop(); // 5,2
                    result = Math.max(result, pop[0] * (prevIdx - pop[1] + 1));
                    lastIdx = pop[1];
                }

                stack.push(new int[] {heights[i], lastIdx});

            }
        }

        if (stack.size() > 0)
        {
            int prevIdx = heights.length - 1; //5

            while (stack.size() > 0)
            {
                int[] pop = stack.pop(); // 1,0
                result = Math.max(result, pop[0] * (prevIdx - pop[1] + 1));
            }

        }

        return result;


    }
}