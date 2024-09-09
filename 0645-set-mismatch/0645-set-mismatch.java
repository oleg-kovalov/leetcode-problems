class Solution {
    public int[] findErrorNums(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        int duplicate = -1;
        int missing = -1;
        for (int i=0; i<nums.length; i++)
        {
            int current = nums[i];
            if (seen.contains(current))
            {
                duplicate = current;
            }
            seen.add(current);
        }

        for (int i=0; i<nums.length; i++)
        {
            if (! seen.contains(i+1))
            {
                missing = i+1;
            }
        }

        return new int[]{duplicate, missing};
    }
}