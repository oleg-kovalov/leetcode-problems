class Solution {
        List<List<Integer>> adjacencyList = new ArrayList<>();

        public boolean canFinish(int numCourses, int[][] prerequisites) {

            for (int i = 0; i < numCourses; i++) {
                adjacencyList.add(new ArrayList<>());
            }
            for (int[] prerequisite : prerequisites) {
                adjacencyList.get(prerequisite[0]).add(prerequisite[1]);
            }
                
            boolean[] visited = new boolean[numCourses];
            boolean[] recStack = new boolean[numCourses];
            for (int i = 0; i < numCourses; i++) {

                boolean cycle = findCycleDFS(i, visited, recStack);
                if (cycle) return false;
            }

            return true;

        }

        private boolean findCycleDFS(int node, boolean[] visited, boolean[] recStack) {
            if (recStack[node]) {
                return true;
            }

            if (visited[node]) {
                return false;
            }

            visited[node] = true;
            recStack[node] = true;

            for (Integer child : adjacencyList.get(node)) {
                boolean cycle = findCycleDFS(child, visited, recStack);
                if (cycle) return true;
            }

            recStack[node] = false;
            return false;
        }
    
}