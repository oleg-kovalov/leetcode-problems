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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return reconstruct(preorder, 0, preorder.length -1, inorder, 0, inorder.length -1);
    }

    private TreeNode reconstruct(int[] preorder, int preStart, int preEnd,  // [3,9,20,15,7]   
                                                                            //    ^       ^
                                int[] inorder, int inStart, int inEnd)     // [9,3,15,20,7]
                                                                          //   ^         ^
    {
        if (preStart > preEnd) return null;
        if (inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]); //3
        int rootIdx = inStart; // 1
        while (inorder[rootIdx] != root.val) rootIdx += 1;

        if (rootIdx > inStart)
        {
            int leftLen = rootIdx - inStart; // 1
            root.left = reconstruct(preorder, preStart + 1, preStart + leftLen,  // 1, 1
                                    inorder, inStart, rootIdx - 1);  // 0, 0
        }

        if (rootIdx < inEnd)
        {
            int rightLen = inEnd - rootIdx;
            root.right = reconstruct(preorder, preEnd - rightLen + 1, preEnd,
                                    inorder, rootIdx + 1, inEnd);
        }

        return root;
    }
}