class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] allowedArr = new boolean[26];
        for (int i=0; i < allowed.length(); i++)
        {
            allowedArr[allowed.charAt(i) - 'a'] = true;
        }

        int result = 0;
        for (String word : words)
        {
            result += 1;
            for (int i=0; i< word.length(); i++)
            {
                if (!allowedArr[word.charAt(i) - 'a'])
                {
                    result -= 1;
                    break; 
                }
            }
        }

        return result;
    }
}