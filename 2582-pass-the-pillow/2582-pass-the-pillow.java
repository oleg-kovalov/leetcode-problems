class Solution {
    public int passThePillow(int n, int time) {
        int fullCycles = time / (n-1);
        // System.out.println("full cycles: " + fullCycles);
        if (fullCycles % 2 == 0) {
            // last cycle is forward
            return time % (2 * (n-1)) + 1 ;
        } 
        else 
        {
            // last cycle is backward
            return n - time % (n-1); 
        }

    }
}