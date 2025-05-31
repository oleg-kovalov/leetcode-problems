class Solution {
    char[][] mappings = new char[][] {
        {},
        {},
        {'a','b','c'},
        {'d','e','f'},
        {'g','h','i'},
        {'j','k','l'},
        {'m','n','o'},
        {'p','q','r','s'},
        {'t','u','v'},
        {'w','x','y','z'}
    };
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<>();
          
        List<String> result = new ArrayList<>();
        backtrack(digits, 0, new ArrayList<>(), result);

        return result;        
    }

    private void backtrack(String digits, int idx, List<Character> currList, List<String> result)
    {
        if (idx == digits.length())
        {
            StringBuilder strb = new StringBuilder();
            for (char c: currList)
            {
                strb.append(c);
            }
            result.add(strb.toString());
            return;
        }
        
        for (char c: mappings[digits.charAt(idx) - '0'])
        {
            currList.add(c);
            backtrack(digits, idx + 1, currList, result);
            currList.remove(currList.size() - 1);
        }
    }
}