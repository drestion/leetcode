# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def postorderTraversal(self, root: TreeNode) -> List[int]:
#         if not root:
#             return []
        
#         return self.postorderTraversal(root.left) + self.postorderTraversal(root.right) + [root.val]
    
        q = [root]
        result = []
        
        while q:
            node = q.pop()
            
            if node:
                result.append(node.val)
                q.append(node.left)
                q.append(node.right) # this one goes out first
                # it is like, node.val, right.val, left. val. so before it returns, reverse the whole list
        
        return result[::-1] # reverse all the result
                