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

        List<String> result = new ArrayList<>();
        for (String word : freqMap.keySet())
        {
            if (freqMap.get(word) == 1)
            {
                result.add(word);
            }
        }

        return result.toArray(new String[0]);

    }
}