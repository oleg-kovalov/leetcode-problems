class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        HashMap<Integer, List<Integer>> adjMap = new HashMap<>();
        for (int[] prereq: prerequisites)
        {
            adjMap.putIfAbsent(prereq[0], new ArrayList<>());
            adjMap.get(prereq[0]).add(prereq[1]);
        }

        HashSet<Integer> visited = new HashSet<>();
        HashSet<Integer> path = new HashSet<>();
        for (int i=0; i<numCourses; i++)
        {
            if (!dfs(i, adjMap, visited, path)) return false;
        }        

        return true;
    }

    private boolean dfs(int course, Map<Integer, List<Integer>> adjMap, Set<Integer> visited, Set<Integer> path)
    {
        if (path.contains(course)) return false; // cycle detected
        if (visited.contains(course)) return true;

        visited.add(course);
        path.add(course);

        for (int prereq : adjMap.getOrDefault(course, Collections.emptyList()))
        {
           if  (!dfs(prereq, adjMap, visited, path)) return false;
        }

        path.remove(course);

        return true;
    }
}