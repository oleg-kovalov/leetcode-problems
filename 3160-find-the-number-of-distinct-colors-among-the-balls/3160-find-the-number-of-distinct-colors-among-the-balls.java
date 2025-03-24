class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Integer> balls = new HashMap<>();
        Map<Integer, Set<Integer>> colors = new HashMap<>();

        int[] result = new int[queries.length];
        for (int i=0; i<queries.length; i++)
        {
            int color = queries[i][1];
            int ball = queries[i][0];

            Integer oldColor = balls.put(ball, color);
            if (oldColor != null)
            {
                colors.get(oldColor).remove(ball);
                if (colors.get(oldColor).isEmpty())
                {
                    colors.remove(oldColor);
                }
            }

            colors.putIfAbsent(color, new HashSet<>());
            colors.get(color).add(ball);

            result[i] = colors.size();
        }

        return result;
    }
}