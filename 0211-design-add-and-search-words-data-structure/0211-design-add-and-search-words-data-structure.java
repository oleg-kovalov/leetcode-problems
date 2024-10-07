class WordDictionary {

    Trie trie;

    public WordDictionary() {
        trie = new Trie();
    }

    public void addWord(String word) {
        trie.addWord(word);
    }

    public boolean search(String word) {
        return trie.search(word);
    }

    class Trie {
        class Node {
            Map<Character, Node> children = new HashMap<>();
            boolean wordEnd;
        }

        Node root = new Node();

        public void addWord(String word) {
            Node current = root;
            for (char c : word.toCharArray()) {
                if (!current.children.containsKey(c)) {
                    current.children.put(c, new Node());
                }
                current = current.children.get(c);
            }
            current.wordEnd = true;
        }

        public boolean search(String word) {
            return search(word, 0, root);
        }

        public boolean search(String word, int index, Node current) {
            if (index > word.length())
                return false;
            if (index == word.length())
                return current.wordEnd;

            char c = word.charAt(index);
            if (c - '.' == 0) {
                boolean found = false;
                for (Node child : current.children.values()) {
                    found = search(word, index + 1, child);
                    if (found)
                        return true;
                }
                return false;
            } else {
                if (!current.children.containsKey(c))
                    return false;

                return search(word, index + 1, current.children.get(c));
            }
        }

    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */