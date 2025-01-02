class Solution {
    public int maxTurbulenceSize(int[] arr) {
        if (arr.length == 1) return 1;

        int maxlen = 1;
        int start = 0;
        for (int i=1; i < arr.length; i++)
        {
            int comp = Integer.compare(arr[i-1], arr[i]);
            if (comp == 0)
            {
                start = i;
            } else if ((i == arr.length -1) || comp * Integer.compare(arr[i], arr[i+1]) != -1 )
            {
                maxlen = Math.max(maxlen, i - start + 1);
                start = i;
            }
        }


        return maxlen;
    }


}