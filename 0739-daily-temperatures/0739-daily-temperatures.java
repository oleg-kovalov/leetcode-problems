class Solution {
    public int[] dailyTemperatures(int[] temperatures) { // 73 74 75 71 69 72 76 73

        int[] result = new int[temperatures.length]; // 1 2 4 2 1 1 0 0

        LinkedList<int[]> stack = new LinkedList<>(); // 76,6 73,7
        stack.push(new int[] {temperatures[0], 0});
        
        for (int i=1; i<temperatures.length; i++)
        {
            int temp = temperatures[i]; 
            while (stack.size() > 0 && stack.peek()[0] < temp)
            {
                int[] pop = stack.pop();
                result[pop[1]] = i - pop[1];                
            }
            stack.push(new int[] {temp, i});
        }

        while (stack.size() > 0)
        {
            int[] pop = stack.pop();
            result[pop[1]] = 0;
        }

        return result;
            
    }
}