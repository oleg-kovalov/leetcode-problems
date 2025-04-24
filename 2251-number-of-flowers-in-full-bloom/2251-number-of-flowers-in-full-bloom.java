class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) { //[1,10][3,3]  , [3,3,2]
        int maxFlowerTime = 0; //10
        for (int[] flower: flowers)
        {
            maxFlowerTime = Math.max(maxFlowerTime, flower[1]);
        }

        int[] diff = new int[maxFlowerTime + 2]; // 0 1 0 1 -1 0 0 0 0 0 -1 
        for (int[] flower: flowers)
        {
            diff[flower[0]] += 1;
            diff[flower[1] + 1] -= 1;
        }

        int[] sum = new int[diff.length]; // 0 1 1 2 1 1 1 1 1 1 0
        for (int i=0; i< sum.length; i++)
        {
            sum[i] = (i > 0 ? sum[i-1] : 0) + diff[i];        
        } 

        int[] result = new int[people.length]; // 2 2 1
        for (int i=0; i<people.length; i++)
        {
            int time = people[i];
            if (time <= maxFlowerTime) result[i] = sum[people[i]];
        }

        return result;
    }
}