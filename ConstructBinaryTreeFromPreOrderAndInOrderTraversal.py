# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if not preorder or not inorder:
            return
        
        root_val = preorder.pop(0)
        root_val_ind = inorder.index(root_val)
        
        left = self.buildTree(preorder, inorder[0:root_val_ind]) # need to exhaust preorder first
        right = self.buildTree(preorder, inorder[root_val_ind+1:])
        
        return TreeNode(root_val, left, right)
        