# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        l, r = p, q
        
        if p.val > q.val:
            l = q
            r = p
            
        if root.val < l.val:
            return self.lowestCommonAncestor(root.right, l, r)
        
        if root.val == l.val and self.hasNodeAndEndAt(root.right, r):
            return root
        
        if root.val > l.val and root.val < r.val:
            if self.hasNodeAndEndAt(root.left, l) and self.hasNodeAndEndAt(root.right, r):
                return root
            
        if root.val == r.val:
            if self.hasNodeAndEndAt(root.left, l):
                return root
        
        if root.val > r.val:
            return self.lowestCommonAncestor(root.left, l, r)
        
    def hasNodeAndEndAt(self, root, p):
        if not root or not p:
            return False
        
        if root.val == p.val:
            return True
        
        if root.val < p.val:
            return self.hasNodeAndEndAt(root.right, p)
        
        return self.hasNodeAndEndAt(root.left, p)
        