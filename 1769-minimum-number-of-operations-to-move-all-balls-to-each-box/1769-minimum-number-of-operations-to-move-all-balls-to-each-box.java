class Solution {
    public int[] minOperations(String boxes) {
        if (boxes.length() == 1) return new int[] {0};

        int[][] prefix = new int[boxes.length()][2];
        prefix[0][0] = 0;
        prefix[0][1] = (boxes.charAt(0) == '1' ? 1 : 0);
        for (int i=1; i<boxes.length(); i++)
        {
            prefix[i][0] = prefix[i-1][0] + prefix[i-1][1];
            prefix[i][1] = prefix[i-1][1] + (boxes.charAt(i) == '1' ? 1 : 0);
        }

        int[][] suffix = new int[boxes.length()][2];
        suffix[boxes.length() - 1][0] = 0;
        suffix[boxes.length() - 1][1] = (boxes.charAt(boxes.length() - 1) == '1' ? 1 : 0);
        for (int i=boxes.length() - 2; i >= 0; i--)
        {
            suffix[i][0] = suffix[i+1][0] + suffix[i+1][1];
            suffix[i][1] = suffix[i+1][1] + (boxes.charAt(i) == '1' ? 1 : 0);
        }

        int[] result = new int[boxes.length()];
        for (int i=0; i<result.length; i++)
        {
            result[i] = prefix[i][0] + suffix[i][0];
        }

        return result;
    }
}