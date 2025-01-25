class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        if (nums.length == 1) return nums;
        
        int[][] numid = new int[nums.length][2];
        for (int i=0; i<nums.length; i++)
        {
            numid[i] = new int[] {nums[i], i};
        }

        Arrays.sort(numid, (a,b) -> Integer.compare(a[0], b[0]));

        TreeSet<Integer> ids = new TreeSet<>();
        List<Integer> values = new ArrayList<>();
        
        int prev = numid[0][0];
        ids.add(numid[0][1]);
        values.add(numid[0][0]);
        for (int i=1; i<numid.length; i++)
        {
            int curr = numid[i][0];

            if (curr - prev > limit)
            {
                for (int value: values)
                {
                    nums[ids.pollFirst()] = value;
                }
                ids.clear();
                values.clear();
            }

            ids.add(numid[i][1]);
            values.add(curr);
            prev = curr;
        }

        for (int value: values)
        {
            nums[ids.pollFirst()] = value;
        }

        return nums;

    }
}