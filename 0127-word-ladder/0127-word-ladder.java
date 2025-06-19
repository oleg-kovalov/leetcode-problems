class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Map<String, List<String>> adjMap = new HashMap<>(); // D*g => [Dog, Dig]
        for (int i=0; i<wordList.size(); i++)
        {
            String word = wordList.get(i);
            for (int j=0; j<word.length(); j++)
            {
                String partial = word.substring(0, j) + "*" + word.substring(j+1, word.length());
                adjMap.putIfAbsent(partial, new ArrayList<>());
                adjMap.get(partial).add(word);
            }
        }

        // System.out.println(adjMap);


        Set<String> visited = new HashSet<>();

        LinkedList<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level = 1;
        int size = queue.size();

        while (queue.size() > 0)
        {
            String word = queue.poll();
            size -= 1;

            if (word.equals(endWord)) return level;

            for (int i=0; i<word.length(); i++)
            {
                String partial = word.substring(0, i) + "*" + word.substring(i+1, word.length());
                for (String nextWord: adjMap.getOrDefault(partial, Collections.emptyList()))
                {
                if (visited.contains(nextWord)) continue;

                visited.add(nextWord);
                queue.offer(nextWord);
                }
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