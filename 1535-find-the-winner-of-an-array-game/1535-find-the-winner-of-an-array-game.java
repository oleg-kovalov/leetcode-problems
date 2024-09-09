class Solution {
    public int getWinner(int[] arr, int k) {
        int maxElement = Arrays.stream(arr).max().getAsInt();

        if (k >= arr.length)
        {
            return maxElement;
        }
        else {
            int currWinCount = 0;
            int currWinner = arr[0];
            for (int i=1; i<arr.length; i++)
            {
                if (currWinner > arr[i])
                {
                    currWinCount++;
                } else {
                    currWinner = arr[i];
                    currWinCount = 1;
                }
                if (currWinCount == k || currWinner == maxElement)
                {
                    return currWinner;
                }
            }

            return -1;
        }
    }
}