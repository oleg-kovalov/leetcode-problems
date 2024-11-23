class Solution {
    public void sortColors(int[] nums) {
        int[] freq = new int[3];
        
        for (int num: nums)
        {
            freq[num] += 1;    
        }

        int freqId= 0;
        for (int i=0; i<nums.length; i++)
        {
            while (freq[freqId] == 0)
            {
                freqId++;
            }

            nums[i] = freqId;
            freq[freqId]--;
        }
    }
}