class Solution {
    public int[] findBuildings(int[] heights) {
        
        LinkedList<int[]> incrStack = new LinkedList<>();
        
        for (int i=heights.length-1; i>=0; i--)
        {
            if (incrStack.size() == 0 || incrStack.peek()[0] < heights[i])
            {
                incrStack.push(new int[] {heights[i], i});
            }
        }
        
        int[] result = new int[incrStack.size()];
        for (int i=0; i<result.length; i++)
        {
            result[i] = incrStack.pop()[1];
        }


        return result;

    }
}