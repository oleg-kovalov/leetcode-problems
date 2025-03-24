class Solution {
    public int characterReplacement(String s, int k) { 

        Set<Character> chars = new HashSet<>();
        for (char c: s.toCharArray())
        {
            chars.add(c);
        }


        int result = 0; 
        for (char c: chars)
        {
            int remK = k; 
            int left = 0;
            for (int right = 0; right < s.length(); right++)
            {
                char rightC = s.charAt(right);
                while (rightC != c && remK == 0 && left <= right)
                {
                    if (s.charAt(left) != c){
                        remK += 1;
                    }
                    left += 1;
                }
                if (rightC != c)
                {
                    remK -= 1;
                }
                result = Math.max(result, right - left + 1);
            }
        }

        return result;


    }
}