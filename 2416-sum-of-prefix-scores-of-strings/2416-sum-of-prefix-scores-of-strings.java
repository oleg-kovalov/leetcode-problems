class Solution {
    public int[] sumPrefixScores(String[] words) {
        int[] result = new int[words.length];
        Trie trie = new Trie();

        for (String word: words) trie.insert(word);
        
        for (int i=0; i<words.length; i++) result[i] = trie.score(words[i]);
        
        return result;
    }

    class Trie
    {

        class Node {

            int count;
            Map<Character, Node> children;

            public Node ()
            {
                children = new HashMap<>();
            }

        }

        Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String word)
        {
            Node current = root;
            for (char ch: word.toCharArray())
            {
                if (!current.children.containsKey(ch))
                {
                    current.children.put(ch, new Node());
                }
                current = current.children.get(ch);
                current.count += 1;
            }
        }

        public int score(String prefix)
        {
            Node current = root;
            int sumOfScores = 0;
            for (char ch: prefix.toCharArray())
            {
                if (!current.children.containsKey(ch)) return 0;

                current = current.children.get(ch);
                sumOfScores += current.count;
            }

            return sumOfScores;
        }

    }
}