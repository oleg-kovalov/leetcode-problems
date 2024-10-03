class Solution {
        public int minSubarray(int[] nums, int p)
        {
            int remainder = 0;
            for (int num: nums)
            {
                remainder = (remainder + num) % p;
            }

            remainder %= p;
            if (remainder == 0) return 0;

            Map<Integer, Integer> modMap = new HashMap<>();
            modMap.put(0, -1); //to handle the case where the whole prefix is an answer
            int currentSum = 0;
            int minLength = nums.length;

            for (int i=0; i<nums.length; i++)
            {
                currentSum = (currentSum + nums[i]) % p;

                //calculate what we need to remove
                int neededSum = (currentSum - remainder + p) % p;
                
                // if we have seen the neededSum remainder, we can consider this subarray
                if (modMap.containsKey(neededSum))
                {
                    minLength = Math.min(minLength, i - modMap.get(neededSum));
                }
                
                modMap.put(currentSum, i);
            }
            
            
            return minLength == nums.length ? -1 : minLength;
        }
}