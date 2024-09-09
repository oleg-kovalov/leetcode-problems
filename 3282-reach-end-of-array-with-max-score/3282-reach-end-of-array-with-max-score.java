class Solution {
        public long findMaximumScore(List<Integer> nums)
        {
            long result = 0;
            int currIdx = 0;
            int currValue = nums.get(0);

            for (int i=0; i<nums.size(); i++)
            {
                if (nums.get(i) > currValue)
                {
                    // jump to a closest value > currValue
                    result += 1L * (i - currIdx) * currValue;
                    currIdx = i;
                    currValue = nums.get(i);
                }
            }
            
            if (currIdx != nums.size()-1) {
                result += 1L * (nums.size() - 1 - currIdx) * currValue;
            }
            
            return result;

        }
}