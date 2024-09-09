class Solution {
    public String lastNonEmptyString(String s) {
        if (s.length() == 1) return s;

        Map<Character, Integer> freq = new HashMap<>();

        for (int i=0; i<s.length(); i++)
        {
            char current = s.charAt(i);
            freq.put(current, freq.getOrDefault(current, 0) + 1);
        }

        int largestFreq = -1;
        for (Integer freqValue : freq.values()) {
            largestFreq = Math.max(largestFreq, freqValue);
        }

        Set<Character> mostFreqChars = new HashSet<>();
        for (Map.Entry<Character, Integer> freqEntry : freq.entrySet()) {
            if (largestFreq == freqEntry.getValue())
            {
                mostFreqChars.add(freqEntry.getKey());
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i=0; i<s.length(); i++)
        {
            char current = s.charAt(i);
            if (! mostFreqChars.contains(current))
            {
                continue;
            }

            int remainingFreq = freq.get(current);
            if (remainingFreq == 1)
            {
                result.append(current);
            } else {
                freq.put(current, remainingFreq-1);
            }
        }

        return result.toString();
    }
}