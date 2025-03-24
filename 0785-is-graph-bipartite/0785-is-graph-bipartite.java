class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] nodes = new int[graph.length]; // 0 - not processed, 1 - green, -1 - red


        for (int start=0; start<graph.length; start++)
        {
            if (nodes[start] != 0) continue;

            LinkedList<Integer> queue = new LinkedList<>();
            nodes[start] = 1;
            queue.offer(start);

            int color = 1;
            while (queue.size() > 0)
            {   
                int size = queue.size();
                for (int i=0; i<size; i++)
                {
                    int curr = queue.poll();

                    int[] peers = graph[curr];
                    for (int peer: peers)
                    {
                        if (nodes[peer] == color) return false;

                        if (nodes[peer] == 0)
                        {
                            nodes[peer] = -1 * color;
                            queue.offer(peer);
                        }
                    }
                }

                color *= -1;
            }
        }

        return true;
    }

}