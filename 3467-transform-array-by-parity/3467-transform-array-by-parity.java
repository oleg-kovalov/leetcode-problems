class Solution {
    public int[] transformArray(int[] nums) {

        int odds = 0;
        for (int num: nums)
        {
            if (num % 2 == 1) odds += 1;        
        }

        int[] result = new int[nums.length];
        for (int i=result.length - odds; i < result.length; i++ )
        {
            result[i] = 1;
        }

        return result;
    }
}