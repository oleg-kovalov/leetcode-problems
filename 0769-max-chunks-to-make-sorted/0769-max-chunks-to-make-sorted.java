class Solution {
    public int maxChunksToSorted(int[] arr) {
        
        LinkedList<Integer> stack = new LinkedList<>();
        int count = 0;

        for (int i=0; i<arr.length; i++)
        {
            stack.add(arr[i]);
            while (stack.size() > 0 && stack.peek() <= i)
            {
                stack.pop();
            }
            if (stack.size() == 0)
            {
                count += 1;
            }
        }

        return count;
    }
}