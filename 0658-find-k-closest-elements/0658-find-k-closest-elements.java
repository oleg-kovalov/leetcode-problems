class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) { // 1,1,10,10
        
        int start = 0;
        int len = k;

        while ( start + 1 + len < arr.length + 1)
        {
            int currDiff = Math.abs(arr[start] - x);
            int targetDiff = Math.abs(arr[start + 1 + len - 1] - x);

            if (currDiff < targetDiff)
            {
                // we are at the edge of optimal window
                break;
            } else if (currDiff > targetDiff)
            {
                // move to more optimal window
                start += 1;
                continue;
            } else {
                int leftNum = arr[start];
                int rightNum = arr[start + 1 + len - 1];
                if (leftNum < rightNum)
                {
                    // in case of tie smaller num is more optimal
                    break;
                } else {
                    // nums are equal, let's move
                    start += 1;
                    continue;
                }
            }
        

        }

        List<Integer> result = new ArrayList<>();
        for (int i=start; i<start + len; i++)
        {
            result.add(arr[i]);
        }

        return result;

    }
}