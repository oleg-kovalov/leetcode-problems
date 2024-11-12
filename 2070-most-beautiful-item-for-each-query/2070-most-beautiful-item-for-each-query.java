class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {

        Arrays.sort(items, (a,b) -> a[0] - b[0]);
        for (int i=1; i<items.length; i++)
        {
            items[i][1] = Math.max(items[i][1], items[i-1][1]);

        }

        int[] result = new int[queries.length];

        for (int i=0; i<queries.length; i++)
        {
            int target = queries[i];

            int lo = 0;
            int hi = items.length-1;
            int maxBeauty = 0;
            while (lo <= hi)
            {
                int mid = (lo + hi) / 2;

                if (items[mid][0] > target)
                {
                    hi = mid-1;
                } else {
                    // found matching price, continue search if better is possible 
                    maxBeauty = Math.max(maxBeauty, items[mid][1]);
                    lo = mid + 1;
                }
            }

            result[i] = maxBeauty;

        }


        return result;

    }
}