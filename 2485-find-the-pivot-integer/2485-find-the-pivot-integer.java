class Solution {
    public int pivotInteger(int n) {
        if (n == 1) return 1; 
        
        int leftSum = 0;
        int rightSum = 0;
        for (int i=1; i<n+1; i++)
        {
            rightSum += i;
        }

        int pivot = 0;
        while (leftSum < rightSum)
        {
            pivot++;
            leftSum += pivot;
            rightSum -= pivot-1;
        }

        if (leftSum == rightSum) return pivot;
        return -1;
    }
}