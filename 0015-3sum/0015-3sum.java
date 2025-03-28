class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        HashSet<Integer> thirdSet = new HashSet<>();

        for (int i=0; i<nums.length; i++)
        {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int first = nums[i];
            thirdSet.clear();
            for (int j=i+1; j<nums.length; j++)
            {
                int curr = nums[j]; //second or third
                if (thirdSet.contains(curr))
                {
                    // third
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(first);
                    triplet.add(0 - first - curr);
                    triplet.add(curr);
                    result.add(triplet);

                    thirdSet.remove(curr);
                } else {
                    //second
                    if (j > i+1 && curr == nums[j-1]) continue;
                    thirdSet.add( 0 - first - curr);
                }
            }
        }

        return result;
    }
}