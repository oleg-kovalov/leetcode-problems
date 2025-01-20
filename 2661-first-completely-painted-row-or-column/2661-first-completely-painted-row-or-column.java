class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {

        HashMap<Integer, int[]> mapping = new HashMap<>();
        for (int row=0; row < mat.length; row++)
        {
            for (int col=0; col < mat[0].length; col++)
            {
                mapping.put(mat[row][col], new int[]{row,col});
            }
        }

        int[] rowCount = new int[mat.length];
        int[] colCount = new int[mat[0].length];

        for (int i=0; i<arr.length; i++)
        {
            int[] coord = mapping.get(arr[i]);
            int row = coord[0];
            int col = coord[1];

            rowCount[row] += 1;
            colCount[col] += 1;
            if (rowCount[row] == mat[0].length || colCount[col] == mat.length) return i;
        }

        return -1;
    }
}