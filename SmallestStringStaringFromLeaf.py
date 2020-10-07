# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def smallestFromLeaf(self, root: TreeNode) -> str:
        # 7:38pm
        # 7:54pm
        # dfs and sort all strings?
        
        def dfs(root, cur_string, strings):
     
            if not root.left and not root.right:
                strings.append((cur_string + [root.val])[::-1])
                return
            if root.left:
                dfs(root.left, list(cur_string) + [root.val], strings)
            if root.right:
                dfs(root.right,list(cur_string) + [root.val], strings)
        
        if not root:
            return ""
       
        strings = []
        
        dfs(root, [], strings)
        return ''.join(map(lambda x: chr(x + ord('a')), sorted(strings)[0]))
            