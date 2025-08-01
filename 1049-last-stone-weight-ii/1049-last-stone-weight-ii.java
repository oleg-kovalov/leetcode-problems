class Solution {
    public int lastStoneWeightII(int[] stones) {

        HashMap<Integer, List<Integer>> dp = new HashMap<>();
        dp.putIfAbsent(0, new ArrayList<>());
        dp.get(0).add(stones[0]);
        dp.get(0).add(-stones[0]);

        for (int i=1; i<stones.length; i++)
        {
            dp.putIfAbsent(i, new ArrayList<>());
            List<Integer> prev = dp.get(i-1);
            for (int p: prev)
            {
                // if (p + stones[i] != 0)
                 dp.get(i).add(p + stones[i]);
                // if (p - stones[i] != 0) 
                dp.get(i).add(p - stones[i]);
            }
        }

        // System.out.println(dp);

        if (dp.get(stones.length - 1).size() == 0) return 0;

        int result = Integer.MAX_VALUE;
        for (int num: dp.get(stones.length - 1))
        {
            result = Math.min(result, Math.abs(num));
        }

        return result;
    }
}