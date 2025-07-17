class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        
        int firstMatch = 0;
        int secondMatch = 0;
        int thirdMatch = 0;

        for (int[] tr: triplets)
        {
            if (tr[0]==target[1] && tr[1]==target[1] && tr[2]==target[2]) return true;
            
            if (tr[0] > target[0] || tr[1] > target[1] || tr[2] > target[2]) continue;

            if (tr[0] == target[0]) firstMatch += 1;            
            if (tr[1] == target[1]) secondMatch += 1;            
            if (tr[2] == target[2]) thirdMatch += 1;            
        }

        if (firstMatch > 0 && secondMatch > 0 && thirdMatch > 0) return true;

        return false; 
    }
}