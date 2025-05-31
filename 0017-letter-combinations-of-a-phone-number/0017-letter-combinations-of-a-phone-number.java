class Solution {
    HashMap<Character, char[]> mappings;
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<>();
        
        mappings = new HashMap<>();
        mappings.put('2', new char[] {'a','b','c'});
        mappings.put('3', new char[] {'d','e','f'});
        mappings.put('4', new char[] {'g','h','i'});
        mappings.put('5', new char[] {'j','k','l'});
        mappings.put('6', new char[] {'m','n','o'});
        mappings.put('7', new char[] {'p','q','r','s'});
        mappings.put('8', new char[] {'t','u','v'});
        mappings.put('9', new char[] {'w','x','y','z'});
        
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
        
        System.out.println(digits.charAt(idx));
        for (char c: mappings.get(digits.charAt(idx)))
        {
            currList.add(c);
            backtrack(digits, idx + 1, currList, result);
            currList.remove(currList.size() - 1);
        }
    }
}