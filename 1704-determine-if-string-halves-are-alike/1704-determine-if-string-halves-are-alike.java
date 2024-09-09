class Solution {
    public boolean halvesAreAlike(String s) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        int count = 0;

        for (int i=0; i<s.length()/2; i++)
        {
            if (vowels.contains(s.charAt(i))) count++;
        }

        for (int i=s.length()/2; i<s.length(); i++)
        {
            if (vowels.contains(s.charAt(i))) count--;
        }


        return count == 0;
    }
}