class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Trie trie = new Trie();

        for (String path: folder)
        {
            trie.addPath(path);
        }

        return trie.getShortestPaths();
    }
}

class Trie 
{
    class Node 
    {
        final String val;
        boolean isEnd = false;
        Map<String, Node> children;

        public Node (String val)
        {
            this.val = val;
            this.isEnd = isEnd;
            children = new HashMap<>();
        }
    }

    Node root = new Node("");

    public void addPath(String path)
    {
        Node curr = root;
        for (String folder: path.split("/"))
        {
            Node next;
            if (curr.children.containsKey(folder))
            {
                next = curr.children.get(folder);
            } else {
                next = new Node(folder);
                curr.children.put(folder, next);
            }

            curr = next;
        }
        curr.isEnd = true;
    }

    public List<String> getShortestPaths()
    {
        List<String> result = new ArrayList<String>();
        for (Node child: root.children.values())
        {
            dfs(child, "", result);
        }

        return result;
    }

    private void dfs(Node curr, String path, List<String> result)
    {
        String newPath = path + '/' + curr.val;

        if (curr.isEnd) {
            result.add(newPath.substring(1));
            return;
        }
        
        for (Node child: curr.children.values())
        {
            dfs(child, newPath, result);
        }
    }
}