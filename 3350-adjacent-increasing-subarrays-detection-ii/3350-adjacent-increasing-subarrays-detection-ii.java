class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        if (nums.size() == 0) return 0;

        int result = 0;
        
        int prevEnd = -1;
        int prevLen = -1;

        int start = 0;
        int end = 0;
        int prev = nums.get(0);
        for (int i=1; i<nums.size(); i++)
        {
            int curr = nums.get(i);
            if (prev < curr){
                end += 1;
            } else {
                int len = end - start + 1;
                result = Math.max(result, len / 2);
                if (prevEnd != -1 && prevEnd == start - 1)
                {
                    result = Math.max(result, Math.min(prevLen, len));
                }
                
                prevLen = len;
                prevEnd = end;

                start = i;
                end = i;
            }

            prev = curr;
        }     

        int len = end - start + 1;
        result = Math.max(result, len / 2);
        if (prevEnd != -1 && prevEnd == start - 1)
        {
            result = Math.max(result, Math.min(prevLen, len));
        }           


        return result;
    }
}