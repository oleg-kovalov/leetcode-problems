class Solution {
    HashMap<String, Integer> cache = new HashMap<>();
    public int minExtraChar(String s, String[] dictionary) {
        Trie trie = new Trie();
        for (String word: dictionary)
            trie.insert(word);


        return backtrack(s, 0, s.length(), s.length(), trie);


    }

    private int backtrack(String s, int start, int end, int charcount, Trie trie)
    {
        if (start >= end) return 0;

        if (cache.containsKey(s.substring(start, end)))
            return cache.get(s.substring(start, end));

        int result = Integer.MAX_VALUE;
        int matchingEnd = start + 1;
        while (matchingEnd <= end)
        {
            if (trie.search(s.substring(start, matchingEnd)))
            {
                // there is match, explore path where we take it
                result = Math.min(result, 
                        backtrack(s, matchingEnd, end, charcount - (matchingEnd - start), trie));
            }

            matchingEnd += 1;
        }

        // explore path where we don't take match from this start
        result = Math.min(result, 
            1 + backtrack(s, start + 1, end, charcount - 1, trie));


        cache.put(s.substring(start, end), result);
        return result;
    }
}




class TrieNode
{
    HashMap<Character, TrieNode> children = new HashMap<>();
    boolean isEnd = false;
}

class Trie
{
    TrieNode root = new TrieNode();

    public void insert(String word)
    {
        TrieNode curr = root;
        for (char c: word.toCharArray())
        {
            curr.children.putIfAbsent(c, new TrieNode());
            curr = curr.children.get(c);
        }
        curr.isEnd = true;
    }

    public boolean search(String word)
    {
        TrieNode curr = root;
        for (char c: word.toCharArray())
        {
            curr = curr.children.get(c);
            if (curr == null) return false;
        }
        return curr.isEnd;
    }
}