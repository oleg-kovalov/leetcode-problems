class Solution {
    public String findDifferentBinaryString(String[] nums) { 
        
        Set<Integer> seen = new HashSet<>();
        for (String num: nums)
        {
            seen.add(bitsToInt(num));
        }

        // int hi = ((int)Math.pow(2, nums.length)) - 1;
        int hi = nums.length;
        for (int i=0; i <= hi; i++ )
        {
            if (!seen.contains(i))
            {
                return intToBits(i, nums.length);
            }
        }

        return "";

    }

    private String intToBits(int num, int n)
    {
        char[] arr = new char[n];
        for (int i=arr.length-1; i>=0; i--)
        {
            if ( (num & (1 << (arr.length - 1 - i))) > 0)
            {
                arr[i] = '1';
            } else {
                arr[i] = '0';
            }
        }

        return new String(arr);

        

    }

    private int bitsToInt(String num)
    {
        int result = 0;
        for (int i=num.length()-1; i>=0; i--)
        {
            if (num.charAt(i) == '1')
            {
                result += Math.pow(2, num.length() - 1 - i); 
            }
        }
        return result;
    }
}