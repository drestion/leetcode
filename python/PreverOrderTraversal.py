# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
#     def preorderTraversal(self, root: TreeNode) -> List[int]:
#         # recursive 
#         if not root:
#             return []
        
#         return [root.val] + self.preorderTraversal(root.left) + self.preorderTraversal(root.right)
    
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        # iterative
        q = [root]
        result = []
        while q:
            cur_node = q.pop()
            
            if cur_node:
                result.append(cur_node.val)
                q.append(cur_node.right) # so that when it pops, the order is reversed
                q.append(cur_node.left)
        
        return result
                