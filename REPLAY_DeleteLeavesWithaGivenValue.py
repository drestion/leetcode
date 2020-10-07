# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def removeLeafNodes(self, root: TreeNode, target: int) -> TreeNode:
        # 9:05pm
        
        # first do in order traversal
        # then push everything into stacks
        # pop and check
        
#         def inorder(root, parent, stack):
#             if not root:
#                 return
#             inorder(root.left, root, stack)
#             stack.append((root, parent))
#             inorder(root.right, root, stack)
            
#         stack = []
#         inorder(root, None, stack)
        
#         while stack:
#             node, parent = stack.pop()
#             if node.val == target and not node.left and not node.right:
#                 if parent.left and parent.left.val == node.val:
#                     parent.left = None
#                 if parent.right and parent.right.val == node.val:
#                     parent.right = None
#             inorder(root, None, stack)
        
#         return root


        if root:
            root.left = self.removeLeafNodes(root.left, target)
            root.right = self.removeLeafNodes(root.right, target)
            if root.val == target and root.left is root.right:
                return None
            return root