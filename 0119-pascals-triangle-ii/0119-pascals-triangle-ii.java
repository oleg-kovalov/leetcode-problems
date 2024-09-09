class Solution {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) { return new ArrayList<>() {{add(1);}}; }
        if (rowIndex == 1) { return new ArrayList<>() {{add(1); add(1);}}; }

        List<Integer> prevRow = getRow(rowIndex - 1);

        for (int j = 0; j < prevRow.size()-1; j++)
        {
            prevRow.set(j, prevRow.get(j) + prevRow.get(j+1));
        }
        prevRow.set(prevRow.size()-1, 1);
        prevRow.add(0, 1);

        return prevRow;
    }
}