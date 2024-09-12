class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> allowedSet = new HashSet<>();
        for (int i=0; i < allowed.length(); i++)
        {
            allowedSet.add(allowed.charAt(i));
        }

        int result = 0;
        for (String word : words)
        {
            result += 1;
            for (int i=0; i< word.length(); i++)
            {
                if (!allowedSet.contains(word.charAt(i)))
                {
                    result -= 1;
                    break; 
                }
            }
        }

        return result;
    }
}