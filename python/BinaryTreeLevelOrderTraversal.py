# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

from collections import deque

class Solution:
    # def levelOrder(self, root):
    #     ans, level = [], [root]
    #     while root and level:
    #         ans.append([node.val for node in level])
    #         LRpair = [(node.left, node.right) for node in level]
    #         level = [leaf for LR in LRpair for leaf in LR if leaf]
    #     return ans

#     def levelOrder(self, root):
#         if not root: return []
#         queue, res = deque([root]), []
        
#         while queue:
#             cur_level, size = [], len(queue)
#             for i in range(size):
#                 node = queue.popleft()
#                 if node.left:
#                     queue.append(node.left)
#                 if node.right:
#                     queue.append(node.right)
#                 cur_level.append(node.val)
#             res.append(cur_level)
#         return res
    
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        # when you have root, print its value
        # and then put its left and right nodes into the queue
        # notice python handles linked list in a wierd way, so 
        # you must use the length to limit the copying.
        
        if not root:
            return []
        
        q, nq, length = [], [root], 0
        result, cur_result = [], []
        
        while nq:
            q = nq
            nq, cur_result = [], []
            length = len(q)
            for i in range(length):
                cur_node = q.pop(0)
                if cur_node:
                    if cur_node.left:
                        nq.append(cur_node.left)
                    if cur_node.right:
                        nq.append(cur_node.right)
                    cur_result += [cur_node.val]
                    
            result += [cur_result]
            
        return result
            