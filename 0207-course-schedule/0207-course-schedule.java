class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        HashMap<Integer, List<Integer>> adjMap = new HashMap<>();
        HashMap<Integer, Integer> inCount = new HashMap<>();
        for (int[] p: prerequisites)
        {
            adjMap.putIfAbsent(p[1], new ArrayList<>());
            adjMap.get(p[1]).add(p[0]);

            inCount.put(p[0], inCount.getOrDefault(p[0], 0) + 1);
        }

        LinkedList<Integer> queue = new LinkedList<>();   
        for (int course=0; course < numCourses; course++)
        {
            if (!inCount.containsKey(course))
            {
                // root course, no prerequisites
                queue.offer(course);
            }
        }

        int passedCount = 0;
        while (queue.size() > 0)
        {
            int course = queue.poll();  
            passedCount += 1;

            for (int nextCourse : adjMap.getOrDefault(course, Collections.emptyList()))
            {
                inCount.put(nextCourse, inCount.get(nextCourse) - 1);
                if (inCount.get(nextCourse) == 0)
                {
                    // all prerequisites are passed
                    queue.offer(nextCourse);
                    inCount.remove(nextCourse);
                }
            }
        }

        return passedCount == numCourses; // if not all courses were passed, there is cycle in the graph
    }   
}