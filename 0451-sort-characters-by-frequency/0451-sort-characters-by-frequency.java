class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> freq = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            freq.merge(s.charAt(i), 1, Integer::sum);
        }

        LinkedHashMap<Character, Integer> sortedFreq = freq.entrySet().stream()
            .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
            .collect(Collectors.toMap(
                Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        StringBuilder result = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : sortedFreq.entrySet()) {
            char currentChar = entry.getKey();
            for (int i = 0; i < entry.getValue(); i++) {
                result.append(currentChar);
            }
        }

        return result.toString();
    }
}