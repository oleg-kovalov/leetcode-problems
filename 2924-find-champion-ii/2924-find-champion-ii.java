class Solution {
    public int findChampion(int n, int[][] edges) {
        HashSet<Integer> champions = new HashSet<>();
        for (int i=0; i<n; i++)
        {
            champions.add(i);
        }        

        for (int[] edge: edges)
        {
            champions.remove(edge[1]);
        }

        if (champions.size() > 1) return -1;
        
        return champions.iterator().next();
    }
}