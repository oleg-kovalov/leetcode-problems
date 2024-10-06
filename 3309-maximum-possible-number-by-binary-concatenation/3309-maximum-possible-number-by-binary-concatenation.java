class Solution {
    public int maxGoodNumber(int[] nums) {
        String[] binaryNums = new String[nums.length];
        for (int i=0; i<nums.length; i++)
        {
            binaryNums[i] = Integer.toBinaryString(nums[i]);
        }

        Arrays.sort(binaryNums, (b1, b2) -> (b2 + b1).compareTo(b1 + b2)); //DESC

        StringBuilder result = new StringBuilder();
        for (String num: binaryNums)
        {
            result.append(num);
        }

        return Integer.parseInt(result.toString(), 2);
        
    }
}