class Solution {
    public long findMaximumNumber(long k, int x) {
        long low = 1;
        long high = (long)1e15;

        while (low <= high)
        {
            long mid = low + (high - low)/2;
            if (calc(mid, x) <= k)
            {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }

    private long calc (long num, int x)
    {
        // get leftmost bit
        int bitPos = leftMostBit(num);

        long price = 0;
        num = num+1; // increment n to account 0th row in the count of groups
        while (bitPos != 0)
        {
            // if current column is valid, calculate the number of 1s in the column
            if (bitPos % x == 0)
            {
                price +=
                    (num /powerOf2(bitPos)) * powerOf2(bitPos-1) // whole groups
                        + Math.max(0, (num % powerOf2(bitPos)) - powerOf2(bitPos-1)); // remainder group
            }

            bitPos--;
        }

        return price;
    }

    long powerOf2(int i) {
        return 1L << i;
    }
    
    long powerOf2_2(int i)
    {
        //must cast to long
        return (long) Math.pow(2, i);
    }

    int leftMostBit (long num)
    {
        int count = 0;
        while (num != 0)
        {
            count++;
            num = num >> 1;
        }
        return count;
    }
}