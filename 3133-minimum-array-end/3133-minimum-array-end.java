class Solution {
    public long minEnd(int n, int x) {
        int count = 1;
        long num = x + 1;
        while (count < n)
        {
            if ((num & x) == x) count++;

            num++;
        }

        return num -1;   
    }
}