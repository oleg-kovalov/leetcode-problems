public class Solution {
    public int CountPalindromicSubsequence(string s) {
        var alphabet = new HashSet<char>();
        foreach(var ch in s)
        {
            alphabet.Add(ch);
        }

        var count = 0;
        foreach(var ch in alphabet)
        {
            var left = -1;
            var right = 0;
            for(var i = 0; i < s.Length; i++)
            {
                if(s[i] != ch)
                    continue;
                if(left == -1)
                    left = i;
                else
                    right = i;
            }
            var unique = new HashSet<char>();
            for(var i = left + 1; i < right; i++)
            {
                unique.Add(s[i]);
            }
            count += unique.Count();
        }

        return count;
    }
}