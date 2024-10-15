class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        Set<Integer> starts = new HashSet<>();

        for (int i=0; i<nums.length; i++)
        {
            if (starts.contains(nums[i]))
            {
                continue;
            }
            starts.add(nums[i]);
            Set<Integer> matching = new HashSet<>();
            for (int j=i+1; j<nums.length; j++)
            {
                if (matching.contains(nums[j]))
                {
                    List<Integer> subResult = new ArrayList<>();
                    subResult.add(nums[i]);
                    subResult.add(nums[j]);
                    subResult.add(-nums[i] - nums[j]);
                    Collections.sort(subResult);
                    result.add(subResult);
                } 

                matching.add(-nums[i] -nums[j]);
            }
        }

        return new ArrayList<>(result);
    }
}