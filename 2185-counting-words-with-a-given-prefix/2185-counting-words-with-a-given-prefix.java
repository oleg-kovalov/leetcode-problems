class Solution {
    public int prefixCount(String[] words, String pref) {
        Trie trie = new Trie();
        for (String word: words)
        {
            trie.insert(word);
        }

        return trie.search(pref);

    }

    class TrieNode {
        TrieNode[] children;
        int count;

        public TrieNode() 
        {
            this.children = new TrieNode[26];
            this.count = 0;
        }
    }

    class Trie {
        
        TrieNode root;
        
        public Trie() {
            root = new TrieNode();
        }

        private int search (String prefix)
        {
            TrieNode curr = root;
            for (int i=0; i<prefix.length(); i++)
            {
                curr = curr.children[prefix.charAt(i) - 'a'];
                if (curr == null) return 0;
            }
            return curr.count;
        }

        private void insert(String word)
        {
            TrieNode curr = root;
            for (int i=0; i<word.length(); i++)
            {
                TrieNode next;
                if (curr.children[word.charAt(i) - 'a'] != null)
                {
                    next = curr.children[word.charAt(i) - 'a'];
                } else {
                    next = new TrieNode();
                }
                next.count += 1;
                curr.children[word.charAt(i) - 'a'] = next;
                curr = next;
            }
        }

    }
}