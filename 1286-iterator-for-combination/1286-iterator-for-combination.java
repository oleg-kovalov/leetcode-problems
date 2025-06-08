class CombinationIterator {

    List<String> combinations = new ArrayList<>();
    int index = 0;

    public CombinationIterator(String characters, int combinationLength) {
        generate(0, new ArrayList<>(), characters, combinationLength);
    }
    
    public String next() {
        return combinations.get(index++);
    }
    
    public boolean hasNext() {
        return index < combinations.size();
    }

    private void generate(int idx, List<Character> combination, String characters, int length)
    {
        if (combination.size() == length)
        {
            StringBuilder sb = new StringBuilder();
            for (char c: combination) sb.append(c);

            combinations.add(sb.toString());
            return;
        }

        if (idx == characters.length()) return;
        // if (length > combination.size() + )

        //take current character
        combination.add(characters.charAt(idx));
        generate(idx + 1, combination, characters, length);
        combination.remove(combination.size() - 1);

        // skip current character
        generate(idx + 1, combination, characters, length);
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */