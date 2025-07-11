class Solution {
    public int findJudge(int n, int[][] trust) {
        if (n == 1) return 1;
        
        Map<Integer, Integer> trustCount = new HashMap<>();
        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        for (int[] t: trust)
        {
            adjMap.putIfAbsent(t[0], new ArrayList<>());
            adjMap.get(t[0]).add(t[1]);

            trustCount.put(t[1], trustCount.getOrDefault(t[1], 0) + 1);
        }


        for (Map.Entry<Integer,Integer> entry: trustCount.entrySet())
        {
            if (entry.getValue() == n - 1) 
            {
                int judge = entry.getKey();
                return adjMap.containsKey(judge) ? -1 : judge;
            }                
        }

        return -1;

    }
}