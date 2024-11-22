class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> count = new HashMap<>();
        
        for (int row=0; row < matrix.length; row++)
        {
            StringBuilder strB = new StringBuilder();
            StringBuilder invStrB = new StringBuilder();
            for (int col=0; col < matrix[row].length; col++)
            {
                strB.append(matrix[row][col]);
                invStrB.append(matrix[row][col] == 0 ? "1" : "0");
            }

            String str = strB.toString();
            String inv = invStrB.toString();
            count.put(str, count.getOrDefault(str, 0) + 1);
            count.put(inv, count.getOrDefault(inv, 0) + 1);
        }

        int maxCount = 0;
        for (int c: count.values())
        {
            maxCount = Math.max(maxCount, c);
        }

        return maxCount;
    }
}