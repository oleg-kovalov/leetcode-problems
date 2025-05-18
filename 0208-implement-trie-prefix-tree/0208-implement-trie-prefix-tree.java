class Trie {

    class TrieNode
    {
        HashMap<Character, TrieNode> children = new HashMap<>();
        boolean isEnd;
    }

    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = root;        
        for (char c: word.toCharArray())
        {
            curr.children.putIfAbsent(c, new TrieNode());
            curr = curr.children.get(c);
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        for (char c: word.toCharArray())
        {
            curr = curr.children.get(c);
            if (curr == null) return false;
        }
        
        return curr.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (char c: prefix.toCharArray())
        {
            curr = curr.children.get(c);
            if (curr == null) return false;
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */