class Solution {
    public int findCenter(int[][] edges) {
        Map<Integer, Integer> inDegree = new HashMap<>();

        for (int[] edge: edges)
        {
            inDegree.put(edge[0], inDegree.getOrDefault(edge[0], 0) + 1);
            inDegree.put(edge[1], inDegree.getOrDefault(edge[1], 0) + 1);
        }

        int maxDegree = -1;
        int center = -1;

        for (Map.Entry<Integer, Integer> entry: inDegree.entrySet())
        {
            int degree = entry.getValue();
            if (degree > maxDegree)
            {
                maxDegree = degree;
                center = entry.getKey();
            }
        }

        return center;
    }
}