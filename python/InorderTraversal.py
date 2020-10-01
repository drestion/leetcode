# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
#         if not root:
#             return []
        
#         return self.inorderTraversal(root.left) + [root.val] + self.inorderTraversal(root.right)
        res, stack = [], []
    
        while True:
            # we keep checking it
            while root:
                # we keep looking for all left subtrees/nodes
                stack.append(root)
                root = root.left
            if not stack:
                # nothing left, even the root
                return res
            # no more left substrees
            # now print the value of the root
            node = stack.pop()
            res.append(node.val)
            root = node.right # now do this for all right substrees