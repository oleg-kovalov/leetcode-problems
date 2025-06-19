class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Map<String, List<String>> adjMap = new HashMap<>();
        for (int i=0; i<wordList.size(); i++)
        {
            for (int j=i+1; j<wordList.size(); j++)
            {
                String word1 = wordList.get(i);
                String word2 = wordList.get(j);
                int mismatch = 0;
                for (int k=0; k<word1.length(); k++)
                {
                    if (word1.charAt(k) != word2.charAt(k))
                    {
                        mismatch += 1;
                        if (mismatch > 1) break;
                    }
                }
                if (mismatch == 1)
                {
                    adjMap.putIfAbsent(word1, new ArrayList<>());
                    adjMap.get(word1).add(word2);
                    adjMap.putIfAbsent(word2, new ArrayList<>());
                    adjMap.get(word2).add(word1);
                }
            }
        }

        for (String word: wordList)
        {
            int mismatch = 0;
            for (int k=0; k<beginWord.length(); k++)
            {
                if (beginWord.charAt(k) != word.charAt(k))
                {
                    mismatch += 1;
                    if (mismatch > 1) break;
                }
            }
            if (mismatch == 1)
            {
                adjMap.putIfAbsent(beginWord, new ArrayList<>());
                adjMap.get(beginWord).add(word);
            }
        }

        // System.out.println(adjMap);


        Set<String> visited = new HashSet<>();

        LinkedList<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        int level = 1;
        int size = queue.size();

        while (queue.size() > 0)
        {
            String word = queue.poll();
            size -= 1;

            if (word.equals(endWord)) return level;

            for (String nextWord: adjMap.getOrDefault(word, Collections.emptyList()))
            {
                if (visited.contains(nextWord)) continue;

                visited.add(nextWord);
                queue.offer(nextWord);
            }

            if (size == 0)
            {
                level += 1;
                size = queue.size();
            }
        }


        return 0;
    }
}