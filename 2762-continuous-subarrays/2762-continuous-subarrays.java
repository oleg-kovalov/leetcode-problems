class Solution {
    public long continuousSubarrays(int[] nums) {
        
        TreeMap<Integer, Integer> freqMap = new TreeMap<>();

        long result = 1L;
        int start = 0;
        freqMap.put(nums[0], 1);
        for (int i=start+1; i<nums.length; i++)
        {
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);

            while (freqMap.lastEntry().getKey() - freqMap.firstEntry().getKey() > 2)
            {
                if (freqMap.get(nums[start]) == 1) {
                    freqMap.remove(nums[start]);
                } else {
                    freqMap.put(nums[start], freqMap.get(nums[start]) - 1);
                }
                start = start + 1;
            }

            result += i - start + 1;

        }


        return result;

    }
}