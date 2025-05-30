class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);

        return result;
    }

//                           baaac        4               [b, a, aa, c]                [b, a, a, a, c]
//                               ^         
    private void backtrack(String s, int idx, List<String> currPart, List<List<String>> result)
    {
        if (idx == s.length())
        {
            result.add(new ArrayList<>(currPart));
            return;
        }
        
        for (int i=idx; i < s.length(); i++)
        {
            if (isPalindrome(s, idx, i))
            {
                currPart.add(s.substring(idx, i + 1));
                backtrack(s, i + 1, currPart, result);
                currPart.remove(currPart.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end)
    {
        int left = start;
        int right = end;

        while (left <= right)
        {
            if (s.charAt(left) != s.charAt(right)) return false;
            left += 1;
            right -= 1;
        }

        return true;
    }
}