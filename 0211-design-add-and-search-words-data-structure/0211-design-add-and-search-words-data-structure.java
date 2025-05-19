class TrieNode
{
    HashMap<Character, TrieNode> children = new HashMap<>();
    boolean isEnd;
}

class WordDictionary {

    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode curr = root;
        for (char c: word.toCharArray())
        {
            curr.children.putIfAbsent(c, new TrieNode());
            curr = curr.children.get(c);
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        List<TrieNode> nodes = new ArrayList<>();
        nodes.add(root);
        for (char c: word.toCharArray())
        {
            List<TrieNode> nextNodes = new ArrayList<>();
                for (TrieNode node: nodes)
                {
                    if (c == '.') 
                    {
                        nextNodes.addAll(node.children.values());
                    }
                    else 
                    {
                        if (node.children.containsKey(c)) nextNodes.add(node.children.get(c));
                    }
                }
                if (nextNodes.size() == 0) return false;
                nodes = nextNodes;
        }
        
        for (TrieNode node: nodes)
            if (node.isEnd) return true;
        
        return false;
    }
}




/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */