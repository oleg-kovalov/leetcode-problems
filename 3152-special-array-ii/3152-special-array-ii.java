class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        List<Integer> anomalies = new ArrayList<>();

        for (int i=1; i<nums.length; i++)
        {
            if ((nums[i] % 2) == (nums[i-1] % 2))
            {
                anomalies.add(i-1);
                System.out.println("anomaly added" + (i-1));
            }
        }

        boolean[] result = new boolean[queries.length];
        Arrays.fill(result, true);

        for (int i=0; i<queries.length; i++)
        {

            int lo = 0;
            int hi = anomalies.size() - 1;
            while (lo <= hi)
            {
                int mid = (lo + hi) / 2;

                if (anomalies.get(mid) < queries[i][0])
                {
                    lo = mid + 1;
                } else if (anomalies.get(mid) > queries[i][1] - 1)
                {
                    hi = mid - 1;
                } else {
                    result[i] = false;
                    break;
                }
            }

        }

        return result;


    }
}