/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode str2tree(String s) {
        return dfs(s);
    }

    private TreeNode dfs (String s)
    {
        if (s.length() == 0) return null;

        String[] chunks = split(s);
        TreeNode root = new TreeNode(Integer.valueOf(chunks[0]));
        if (chunks[1].length() > 0)
        {
            root.left = dfs(chunks[1]);
        }
        if (chunks[2].length() > 0)
        {
            root.right = dfs(chunks[2]);
        }

        return root;
    }

    private String[] split(String s) //4(2(3)(1))(6(5))
    {
        String[] result = new String[3];

        if (s.indexOf('(') == -1) return new String[] {s, "", ""};

        result[0] = s.substring(0, s.indexOf('('));

        int balance = 1;
        int idx = s.indexOf('(') + 1;
        while (idx < s.length())
        {
            char c = s.charAt(idx);
            if (c == '(')
            {
                balance += 1;
            } else if (c == ')')
            {
                balance -= 1;
            }

            if (balance == 0) break;

            idx += 1;
        }

        result[1] = s.substring(s.indexOf('(') + 1, idx);
        result[2] = idx + 2 < s.length() ? s.substring(idx + 2, s.length() - 1) : "";

        // System.out.println(Arrays.toString(result));
        return result;
    }
}