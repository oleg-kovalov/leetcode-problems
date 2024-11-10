class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        for (int num: nums)
        {
            if (num >= k) return 1;
        }


        int[] pfxNum = new int[nums.length];
        int[][] pfxBits = new int[nums.length][30];

        for (int i=0; i<nums.length; i++)
        {
            int num = nums[i];
            int[] bits = (i == 0) ? new int[30] : Arrays.copyOf(pfxBits[i-1], 30);
            for (int b=0; b < bits.length; b++)
            {
                if ((num & (1 << b)) > 0) bits[b]++;
            }
            pfxBits[i] = bits;

            pfxNum[i] = (i == 0) ? num : (pfxNum[i-1] | num);
             
        }

        int largestId = -1;
        for (int i=0; i<pfxNum.length; i++)
        {
            if (pfxNum[i] >= k) 
            {
                largestId = i;
                break;
            }
        }

        if (largestId == -1) return -1;

        int[] largestBits = pfxBits[largestId];
        int leftId = 0;
        for (int i=0; i<largestId; i++)
        {
            int[] bits = pfxBits[i];
            boolean allBitsOk = true;
            for (int b=0; b<bits.length; b++)
            {
                if (bits[b] == 1)
                {
                    if (largestBits[b] > 1)
                    {
                        largestBits[b]--;
                    }
                    else {
                        allBitsOk = false;
                        break;
                    }
                }
            }
            if (!allBitsOk) break;
        } 

        return largestId + 1 - leftId;
        

    }
}