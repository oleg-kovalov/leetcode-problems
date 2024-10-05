class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) return false;
        
        int[] target = new int[26];
        
        for (char ch: s1.toCharArray())
        {
            target[ch - 'a'] += 1;
        }
        
        int[] current = new int[26];
        for (int i=0; i < s1.length(); i++)
        {
            char ch = s2.charAt(i);
            current[ch - 'a'] += 1;
        }

        if (Arrays.equals(target, current)) return true;

        for (int start=1; start + s1.length() - 1 < s2.length(); start++)
        {
            current[s2.charAt(start - 1) - 'a'] -= 1;
            current[s2.charAt(start + s1.length() - 1) - 'a'] += 1;

            if (Arrays.equals(target, current)) return true;
        }

        return false;
    }
}