class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        if (arr.length == 1) return 1;

        int[] sorted = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sorted); //ASC

        sorted[0] = 1;
        for (int i=1; i<sorted.length; i++)
        {
            int current = sorted[i];
            int prev = sorted[i-1];
            if (current != prev)
            {
                sorted[i] = prev+1;
            }
        }

        return sorted[sorted.length-1];
    }
}