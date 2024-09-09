class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rows = new LinkedList<>();
        for (int i = 0; i < numRows; i++) {
            if (i == 0) rows.add(i, List.of(1));
            else if (i == 1) rows.add(i, List.of(1, 1));
            else {
                List<Integer> prevRow = rows.get(i - 1);
                List<Integer> currRow = new ArrayList<>();
                currRow.add(1);
                for (int j = 0; j < prevRow.size() - 1; j++) {
                    currRow.add(j + 1, prevRow.get(j) + prevRow.get(j + 1));
                }
                currRow.add(1);
                rows.add(i, currRow);
            }
        }

        return rows;
    }
}