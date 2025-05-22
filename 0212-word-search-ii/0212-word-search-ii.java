class Solution {

    int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0,1}};
    int rows;
    int cols;
    Set<String> result;
    public List<String> findWords(char[][] board, String[] words) { // [[a,b],[c,d]]
        result = new HashSet<>();

        rows = board.length;
        cols = board[0].length;

        Trie trie = new Trie();
        for (String word: words)
        {
            trie.insert(word);
        }

        for (int startRow=0; startRow < rows; startRow++)
        {
            for (int startCol=0; startCol < cols; startCol++)
            {
                backtrack(startRow, startCol, new StringBuilder(), trie.root, new boolean[rows][cols], board);
            }
        }

        return new ArrayList<>(result);
    }

    private void backtrack(int row, int col, StringBuilder prefix, TrieNode node, boolean[][] visited, char[][] board)
    {
        TrieNode nextNode = node.children.get(board[row][col]);
        if (nextNode == null) return;
        
        visited[row][col] = true;
        prefix.append(board[row][col]);
        // System.out.println(prefix);

        if (nextNode.isEnd) 
        {
            result.add(prefix.toString());
        }

        for (int[] dir: directions)
        {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (0 <= newRow && newRow < rows
            && 0 <= newCol && newCol < cols
            && !visited[newRow][newCol])
            {
                backtrack(newRow, newCol, prefix, nextNode, visited, board);
            }
        }

        visited[row][col] = false;
        prefix.deleteCharAt(prefix.length() - 1);
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
        for (int i=0; i<word.length(); i++)
        {
            curr.children.putIfAbsent(word.charAt(i), new TrieNode());
            curr = curr.children.get(word.charAt(i));
        }
        curr.isEnd = true;
    }

    // public boolean search(StringBuilder word)
    // {
    //     TrieNode curr = root;
    //     for (int i=0; i<word.length(); i++)
    //     {
    //         curr = curr.children.get(word.charAt(i));
    //         if (curr == null) return false; 
    //     }

    //     return curr.isEnd;
    // }
}