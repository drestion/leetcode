# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
#         if not root:
#             return True
        
#         return self.maxValue(root.left) < root.val and self.minValue(root.right) > root.val
        return self.isValid(root)
    
    def maxValue(self, root):
        if not root:
            return -2**32
        
        return max(root.val, self.maxValue(root.left), self.maxValue(root.right))
    
    def minValue(self, root):
        if not root:
            return 2**32
        
        return min(root.val, self.minValue(root.left), self.minValue(root.right))
    
    def isValid(self, root):
        
        if not root:
            return True
        
        return self.isValid(root.left) and self.maxValue(root.left) < root.val and self.isValid(root.right) and self.minValue(root.right) > root.val
    
    
    
    