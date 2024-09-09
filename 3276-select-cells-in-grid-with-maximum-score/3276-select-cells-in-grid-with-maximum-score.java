class Solution {
        Integer[][] cache;
        public int maxScore(List<List<Integer>> grid)
        {
            cache = new Integer[0b1111111111 + 1][101];  // 1024

            Set<Integer> uniqueNums = new HashSet<>();
            for (int row=0; row<grid.size(); row++)
            {
                for (int col=0; col < grid.get(0).size(); col++)
                {
                    uniqueNums.add(grid.get(row).get(col));
                }
            }

            List<Integer> sortedNums = new ArrayList<>(uniqueNums);
            Collections.sort(sortedNums, Comparator.reverseOrder());

            Map<Integer, Set<Integer>> numToRows = new HashMap<>();
            for (int row=0; row < grid.size(); row++)
            {
                for (int col=0; col < grid.get(0).size(); col++)
                {
                    numToRows.computeIfAbsent(grid.get(row).get(col), HashSet::new)
                        .add(row);
                }
            }

            return dfs(0, sortedNums, numToRows, 0);
        }

        private int dfs(int mask, List<Integer> sortedNums, Map<Integer, Set<Integer>> numsToRows, int index)
        {
            if (index == sortedNums.size()) return 0;
            if (cache[mask][index] != null) return cache[mask][index];

            int maxScore = -1;
            int num = sortedNums.get(index);

            for (int row : numsToRows.get(num))
            {
                if ((mask & (1 << row)) == 0)
                {
                    maxScore = Math.max(maxScore, num + dfs((mask | 1 << row), sortedNums, numsToRows, index + 1));
                }
            }

            if (maxScore == -1)
            {
                // all rows that contain num with 'index' were already occupied, try next index
                maxScore = dfs(mask, sortedNums, numsToRows, index + 1);
            }

            cache[mask][index] = maxScore;

            return maxScore;
        }
    
}