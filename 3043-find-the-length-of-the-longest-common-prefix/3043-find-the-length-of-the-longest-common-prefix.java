class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        
        int result = 0;
        
        Trie trie1 = new Trie();
        for (int num1: arr1)
        {
            trie1.insert(String.valueOf(num1));
        }
        
        Trie trie2 = new Trie();        
        for (int num2: arr2)
        {
            trie2.insert(String.valueOf(num2));
        }
        
        for (int num1: arr1)
        {
            result = Math.max(result, trie2.longestPrefix(String.valueOf(num1)));
        }
        
        for (int num2: arr2)
        {
            result = Math.max(result, trie1.longestPrefix(String.valueOf(num2)));
        }
        
        return result;       
        
    }

    class Trie
    {
        class Node {
            boolean wordEnd;
            Map<Character, Node> children;

            public Node() {
                children = new HashMap<>();
            }
        }

        Node root;

        public Trie ()
        {
            root = new Node();
        }

        public void insert (String word)
        {
            Node current = root;
            for (char ch : word.toCharArray())
            {
                if (!current.children.containsKey(ch))
                {
                    current.children.put(ch, new Node());
                }
                current = current.children.get(ch);
            }
            current.wordEnd = true;
        }

        public int longestPrefix (String word)
        {
            Node current = root;
            int length = 0;
            for (char ch: word.toCharArray())
            {
                if (!current.children.containsKey(ch)) return length;
                
                current = current.children.get(ch);
                length += 1;
            }
            return length;
        }
    }
}