/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    public String serialize(TreeNode root) {
        if (root == null) return "";

        java.util.StringJoiner result = new java.util.StringJoiner(",");
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);

        while (!nodes.isEmpty())
        {
            TreeNode node = nodes.poll();
            if (node == null) {
                result.add("null");
                continue;
            }

            result.add(String.valueOf(node.val));

            nodes.offer(node.left);
            nodes.offer(node.right);
        }


        String resultStr = result.toString();
        while (resultStr.endsWith(",null"))
        {
            resultStr = resultStr.substring(0, resultStr.length()-5);
        }

        return resultStr;
    }

    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;

        Queue<String> nodesStr = new LinkedList<>();
        for (String str : data.split(",")) {
            nodesStr.offer(str);
        }
        Queue<TreeNode> nodes = new LinkedList<>();

        TreeNode root = new TreeNode(Integer.parseInt(nodesStr.poll()));
        nodes.offer(root);

        while (!nodesStr.isEmpty() && !nodes.isEmpty()) {
            if (nodesStr.isEmpty()) return root;
            TreeNode node = nodes.poll();
            String nodeStr = nodesStr.poll();
            if (nodeStr.equals("null"))
            {
                node.left = null;
            } else {
                node.left = new TreeNode(Integer.parseInt(nodeStr));
                nodes.offer(node.left);
            }

            if (nodesStr.isEmpty()) return root;
            nodeStr = nodesStr.poll();
            if (nodeStr.equals("null"))
            {
                node.right = null;
            } else {
                node.right = new TreeNode(Integer.parseInt(nodeStr));
                nodes.offer(node.right);
            }
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));