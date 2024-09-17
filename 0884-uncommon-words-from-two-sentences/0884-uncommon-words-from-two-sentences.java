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
        for (Map.Entry<String,Integer> entry : freqMap.entrySet())
        {
            if (entry.getValue() == 1)
            {
                result.add(entry.getKey());
            }
        }

        return result.toArray(new String[result.size()]);

    }
}