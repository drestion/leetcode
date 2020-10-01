# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        
        if not inorder or not postorder:
            return None
        
        root_val = postorder.pop()
        left_root_ind = inorder.index(root_val)
        right =  self.buildTree(inorder[left_root_ind+1:], postorder) # exhaust right part first
        left = self.buildTree(inorder[0:left_root_ind], postorder) # the rest if for left                        
        return TreeNode(root_val,left, right ) 
        