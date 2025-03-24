class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        
        Map<Integer,List<Integer>> prereq = new HashMap<>();
        for (int[] pair: prerequisites)
        {
            prereq.putIfAbsent(pair[0], new ArrayList<>());
            prereq.get(pair[0]).add(pair[1]);
        }

        boolean[][] grid = new boolean[numCourses][numCourses]; 
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i=0; i<numCourses; i++)
        {
            queue.offer(i);

            while (queue.size() > 0)
            {
                int curr = queue.pop();
                

                for (int child: prereq.getOrDefault(curr, Collections.emptyList()))
                {
                    if (! grid[i][child]) 
                    {
                        queue.offer(child);
                        grid[i][child] = true;
                    }
                }
            }
        }

        List<Boolean> result = new ArrayList<>();
        for (int[] query: queries)
        {
            result.add(grid[query[0]][query[1]]);
        }

        return result;
    }
}