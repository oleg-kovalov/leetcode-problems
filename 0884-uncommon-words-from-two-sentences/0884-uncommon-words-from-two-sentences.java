class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word: s1.split(" "))
        {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        for (String word: s2.split(" "))
        {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        return freqMap.entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(e -> e.getKey())
                .toArray(String[]::new);

    }
}