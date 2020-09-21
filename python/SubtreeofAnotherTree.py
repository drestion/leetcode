# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSubtree(self, s: TreeNode, t: TreeNode) -> bool:
        if (not s and not t):# or (s and not t):
            return True
        if s and not t:
            return False
        return self.isSameTree(s, t) or (s and (self.isSubtree(s.left, t) or self.isSubtree(s.right, t)))
    
    def isSameTree(self, s, t):
        if not s and not t:
            return True
        
        return s and t and s.val == t.val and self.isSameTree(s.left, t.left) and self.isSameTree(s.right, t.right)
        
        