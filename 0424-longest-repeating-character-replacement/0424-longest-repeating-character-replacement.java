class Solution {
    public int characterReplacement(String s, int k) {
        
        int result = k;

        int[] count = new int[26]; 
        int left = 0;
        int size = 1;

        while (left + size - 1 < s.length())
        {
            count[s.charAt(left + size - 1) - 'A'] += 1;

            int maxCount = 0;
            for (int c: count)
            {
                maxCount = Math.max(maxCount, c);
            }

            if (maxCount + k >= size)
            {
                result = Math.max(result, size);
                size += 1;
            } else {
                count[s.charAt(left) - 'A'] -= 1;
                left += 1;
            }
        }



        return result;

                
    }
}