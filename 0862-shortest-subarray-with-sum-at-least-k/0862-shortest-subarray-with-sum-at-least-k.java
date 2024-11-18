class Solution {
        class Tuple {
            final long sum;
            final int idx;
            
            public Tuple(long sum, int idx) { this.sum = sum; this.idx = idx; }
        }
        
        public int shortestSubarray(int[] nums, int k)
        {
            if (nums.length == 1) return nums[0] <= k ? 1 : 0;

            ArrayList<Tuple> stack = new ArrayList<>();
            int minLen = Integer.MAX_VALUE;

            long[] prefix = new long[nums.length];
            prefix[0] = nums[0];

            if (prefix[0] > k) return 1;

            stack.add(new Tuple(prefix[0], 0));
            for (int i=1; i<nums.length; i++)
            {
                prefix[i] = prefix[i-1] + nums[i];

                while (stack.size() > 0 && stack.get(stack.size()-1).sum >= prefix[i] )
                {
                    stack.remove(stack.size()-1);
                }

                stack.add(new Tuple(prefix[i], i));

                int discard = rightmostDiscard(stack,  prefix[i] - k);
                if (discard == -1 && prefix[i] >= k)
                {
                    minLen = Math.min(minLen, i + 1); // length from 0 to i
                }
                else if (discard != -1)
                {
                    minLen = Math.min(minLen, i - stack.get(discard).idx); // length from discard to i
                }

            }

            return minLen == Integer.MAX_VALUE ? -1 : minLen;

        }

        private int rightmostDiscard(ArrayList<Tuple> stack, long target)
        {
            // find the rightmost element that is  <= target
            int lo = 0;
            int hi = stack.size() -1;
            int result = -1;
            while (lo <= hi)
            {
                int mid = ( lo + hi) / 2;
                if (stack.get(mid).sum <= target)
                {
                    result = mid;
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }

            return result;
        }

}