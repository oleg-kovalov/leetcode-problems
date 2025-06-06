# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:

        def validate(root, minBoundary, maxBoundary):
            if not root: return True

            if root.val <= minBoundary: return False
            if root.val >= maxBoundary: return False

            return validate(root.left, minBoundary, root.val) & validate(root.right, root.val, maxBoundary)


        return validate(root, -pow(2, 31) -1, pow(2, 31))
        