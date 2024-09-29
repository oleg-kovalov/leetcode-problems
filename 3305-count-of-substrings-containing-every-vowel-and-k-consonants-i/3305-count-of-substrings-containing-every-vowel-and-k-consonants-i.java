class Solution {
    HashMap<Character, Integer> vowelCounts;
    int consonants;
    public int countOfSubstrings(String word, int k) {
        vowelCounts = new HashMap<>();
        vowelCounts.put('a', 0);
        vowelCounts.put('e', 0);
        vowelCounts.put('i', 0);
        vowelCounts.put('o', 0);
        vowelCounts.put('u', 0);
        consonants = 0;

        for (int i=0; i<k+5; i++)
        {
            if (vowelCounts.keySet().contains(word.charAt(i)))
            {
                vowelCounts.put(word.charAt(i), vowelCounts.getOrDefault(word.charAt(i), 0) + 1);
            } else {
                consonants += 1;
            }
        }

        int count = 0;

        int start = 0;
        int oldStart = start;
        int end = start + 5 + k - 1;
        int oldEnd = end;

        while (start + 5 + k - 1 < word.length())
        {
            if (start != oldStart)
            {
                char oldStartChar = word.charAt(oldStart);
                removeChar(oldStartChar);
                oldStart = start;
            }

            if (end != oldEnd)
            {
                char newEndChar = word.charAt(end);
                addChar(newEndChar);
                oldEnd = end;
            }

            if (consonants == k && !vowelCounts.containsValue(0)){
                count += 1;
            }

            if ( consonants <= k && end < word.length() - 1)
            {
                end++;
            } else {
                while (end - start > 5 + k - 1)
                {
                    removeChar(word.charAt(end));
                    end--;
                }
                start++;
                end = start + 5 + k - 1;
                oldEnd = end -1;
            }
        }

        return count;
    }

    private boolean isVowel (char ch)
    {
        return vowelCounts.containsKey(ch);
    }

    private void removeChar (char ch)
    {
        if (isVowel(ch))
        {
            vowelCounts.put(ch, vowelCounts.get(ch) -1);
        } else {
            consonants--;
        }
    }

    private void addChar (char ch)
    {
        if (isVowel(ch))
        {
            vowelCounts.put(ch, vowelCounts.get(ch) + 1);
        } else {
            consonants++;
        }
    }
}