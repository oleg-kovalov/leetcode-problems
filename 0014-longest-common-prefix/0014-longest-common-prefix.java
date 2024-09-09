class Solution {
    public String longestCommonPrefix(String[] strs) {
        final TrieNode root = new TrieNode();

        for (String str : strs) {
            if (str.isEmpty()) return "";

            TrieNode current = root;
            for (char c : str.toCharArray()) {
                Map<Character, TrieNode> children = current.children;
                current = children.computeIfAbsent(c, (k) -> new TrieNode());
            }

            current.setEndOfWord(true);
        }

        TrieNode current2 = root;
        List<Character> commonPrefix = new ArrayList<>();
        while (true)
        {
            Map<Character, TrieNode> currentChildren = current2.getChildren();
            if (currentChildren.keySet().size() != 1 || current2.isEndOfWord())
            {
                return commonPrefix.stream().map(String::valueOf).collect(Collectors.joining());
            }

            Character currentChar = currentChildren.keySet().iterator().next();
            commonPrefix.add(currentChar);
            current2 = currentChildren.get(currentChar);
        }

    }

    class TrieNode {
        private final Map<Character, TrieNode> children = new HashMap<>();
        private boolean endOfWord;

        public Map<Character, TrieNode> getChildren() {
            return children;
        }

        public boolean isEndOfWord() {
            return endOfWord;
        }

        public void setEndOfWord(boolean endOfWord) {
            this.endOfWord = endOfWord;
        }
    }
}