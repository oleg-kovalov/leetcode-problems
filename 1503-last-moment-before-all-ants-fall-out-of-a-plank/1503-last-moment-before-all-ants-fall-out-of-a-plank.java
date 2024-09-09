class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int result = 0;
        for (int posL : left) {
            result = Math.max(result, posL);
        }
        
        for (int posR : right)
        {
            result = Math.max(result, n - posR);
        }
        
        return result;
    }
}