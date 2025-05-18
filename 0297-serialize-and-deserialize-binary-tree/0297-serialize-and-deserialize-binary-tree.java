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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder result = new StringBuilder();

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (queue.size() > 0)
        {
            TreeNode node = queue.poll();
            if (node == null)
            {
                result.append("null").append(',');
            }
            else {
                result.append(node.val).append(',');

                queue.offer(node.left);
                queue.offer(node.right);
            }
        }

        result.deleteCharAt(result.length() - 1);

        return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.equals("")) return null;

        String[] chunks = data.split(",");
        TreeNode root = new TreeNode(Integer.valueOf(chunks[0]));

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int idx = 1;

        while (idx < chunks.length)
        {
            TreeNode node = queue.poll();
            node.left = chunks[idx].equals("null") ? null : new TreeNode(Integer.valueOf(chunks[idx]));
            if (node.left != null) queue.offer(node.left);
            idx += 1;

            if (idx == chunks.length) break;
            node.right = chunks[idx].equals("null") ? null : new TreeNode(Integer.valueOf(chunks[idx]));
            if (node.right != null) queue.offer(node.right);
            idx += 1;
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));