class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer, Integer> valueToPairId = new HashMap<>();


        for (int ix=0; ix < nums.length; ix++)
        {
            int x = nums[ix];
            if (valueToPairId.containsKey(x))
            {
                int iy = valueToPairId.get(x);
                return new int[] {ix, iy};

            } else 
            {
                int y = target - nums[ix];
                valueToPairId.put(y, ix);
            }                     
        }
        return null;
    }
}