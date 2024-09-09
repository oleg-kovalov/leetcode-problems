class Solution {
        public int lengthOfLongestSubstring(String s) {
            final HashMap<Character, Integer> positions = new HashMap<>();

            if (s.length() == 0) return 0;

            int start = 0;
            positions.put(s.charAt(0), 0);
            int end = 1;
            int maxSize = 1;

            while (end < s.length())
            {
                final Integer seenIndex = positions.get(s.charAt(end));

                if (seenIndex != null && seenIndex >= start)
                {
                    start = seenIndex+1;
                }

                positions.put(s.charAt(end), end);
                maxSize = Math.max(maxSize, end - start + 1);


                end++;


            }

            return maxSize;
        }
    
    
}