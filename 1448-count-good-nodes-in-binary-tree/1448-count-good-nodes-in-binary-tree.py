# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:

    def goodNodes(self, root: TreeNode) -> int:
        count = 0
        queue = deque()
        queue.append((root, root.val))

        while len(queue) > 0:
            pair = queue.popleft()

            if pair[0].val >= pair[1]:
                count += 1

            newMax = max(pair[0].val, pair[1])

            if pair[0].left: 
                queue.append((pair[0].left, newMax))
            if pair[0].right: 
                queue.append((pair[0].right, newMax))


        return count


    # DFS

    # def goodNodes(self, root: TreeNode) -> int:
    #     return self.dfs(root, root.val)


    # def dfs(self, root: TreeNode, path: int) -> int:
    #     if not root: return 0
    #     newPath = max(path, root.val)

    #     return self.dfs(root.left, newPath) + self.dfs(root.right, newPath) + (1 if root.val >= path else 0) 
        