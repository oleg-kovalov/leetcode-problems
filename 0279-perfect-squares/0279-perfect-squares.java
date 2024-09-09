class Solution {
    private List<Integer> squares;
    private Map<Integer, Integer> cache = new HashMap<>();
    public int numSquares(int n) {
        squares = new ArrayList<>();

        for (int i=1; i<=Math.sqrt(n); i++)
        {
            squares.add(i*i);
        }

        return iterate(n);

    }

    private int iterate(int remaining)
    {
        if (cache.containsKey(remaining)) return cache.get(remaining);

        if (remaining == 0)
        {
            return 0;
        }

        if (remaining < 0)
        {
            return -1;
        }

        for (int i=0; i<squares.size(); i++)
        {
            int square = squares.get(i);
            int result = iterate(remaining - square);
            if (result >= 0)
            {
                cache.merge(remaining, result+1, Math::min);
            }
        }

        return cache.get(remaining);
    }
}