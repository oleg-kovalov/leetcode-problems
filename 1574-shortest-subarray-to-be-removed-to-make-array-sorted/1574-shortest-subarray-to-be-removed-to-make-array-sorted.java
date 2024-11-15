class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        if (arr.length == 1) return 0;

        LinkedList<Integer> stackInc = new LinkedList<>();
        for (int i=0; i<arr.length; i++)
        {
            if (stackInc.peek() == null || stackInc.peek() <= arr[i])
            {
                stackInc.push(arr[i]);
            } else {
                break;
            }
        }
        if (stackInc.size() == arr.length) return 0;

        LinkedList<Integer> stackDecr = new LinkedList<>();
        for (int i=arr.length-1; i>=0; i--)
        {
            if (stackDecr.peek() == null || stackDecr.peek() >= arr[i])
            {
                stackDecr.push(arr[i]);
            } else {
                break;
            }
        }

        int leftSize = stackInc.size();
        int rightSize = stackDecr.size();
        int leftTop = stackInc.peek();
        int rightTop = stackDecr.peek();

        int popLeft = 0;
        while (stackDecr.peek() != null && stackDecr.peek() < leftTop)
        {
            stackDecr.pop();
            popLeft++;
        }

        int popRight = 0;
        while(stackInc.peek() != null && stackInc.peek() > rightTop)
        {
            stackInc.pop();
            popRight++;
        }

        return arr.length - leftSize - rightSize + Math.min(popLeft, popRight);
        
    }
}