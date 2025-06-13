class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        HashMap<Integer, List<Integer>> adjMap = new HashMap<>();
        HashMap<Integer, Integer> inCount = new HashMap<>();
        for (int[] p: prerequisites)
        {
            adjMap.putIfAbsent(p[1], new ArrayList<>());
            adjMap.get(p[1]).add(p[0]);

            inCount.put(p[0], inCount.getOrDefault(p[0], 0) + 1);
        }

        List<Integer> topoSort = new ArrayList<>();
        LinkedList<Integer> queue = new LinkedList<>();
        for (int c=0; c<numCourses; c++)
        {
            if (!inCount.containsKey(c))
            {
                // root course, no prerequisites
                queue.offer(c);
            }
        }

        while (queue.size() > 0)
        {
            int course = queue.poll();
            topoSort.add(course);

            for (int nextCourse: adjMap.getOrDefault(course, Collections.emptyList()))
            {
                inCount.put(nextCourse, inCount.get(nextCourse) - 1);
                if (inCount.get(nextCourse) == 0)
                {
                    queue.offer(nextCourse);
                    inCount.remove(nextCourse);
                }
            }
        }

        if (topoSort.size() < numCourses) return new int[0]; // there was cycle, not all courses were passed 

        return topoSort.stream().mapToInt(Integer::intValue).toArray();
    }
}