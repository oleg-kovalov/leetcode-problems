class Solution {

    HashMap<Integer, Integer> cache = new HashMap<>();

    public int climbStairs(int n) {
        return step(n);
    }

    private int step(int remaining)
    {
        if (cache.containsKey(remaining))
        {
            return cache.get(remaining);
        }

        if (remaining == 0)
        {
            return 1;            
        }

        if (remaining < 0)
        {
            return 0;
        }

        int ways = step(remaining -1) + step(remaining -2);
        cache.put(remaining, ways);
        
        return ways;
    }
}