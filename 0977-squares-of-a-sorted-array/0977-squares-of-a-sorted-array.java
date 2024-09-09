class Solution {

    public int[] sortedSquares(int[] nums) {
        int l = 0;
        int r = nums.length -1;

        int[] result = new int[nums.length];

        for (int i=result.length-1; i>=0; i--)
        {
            int left = nums[l];
            int right = nums[r];
            if (Math.abs(left) < Math.abs(right))
            {
                result[i] = right * right;
                r--;
            } else {
                result[i] = left * left;
                l++;
            }
        }
        return result;
    }


    // public int[] sortedSquares(int[] nums) {
    //     int[] freqArr = new int[10001];

    //     for (int i=0; i < nums.length; i++)
    //     {
    //         freqArr[Math.abs(nums[i])]++;
    //     }

    //     List<Integer> result = new ArrayList<>();
    //     for (int i=0; i < freqArr.length; i++)
    //     {
    //         int freq = freqArr[i];
    //         while (freq > 0) 
    //         {
    //             result.add(i*i);
    //             freq--;
    //         }
    //     }

    //     return result.stream().mapToInt(Integer::intValue).toArray();
    // }
}