"""
# Definition for a Node.
class Node:
    def __init__(self, val, prev, next, child):
        self.val = val
        self.prev = prev
        self.next = next
        self.child = child
"""

class Solution:
#     def flatten(self, head: 'Node') -> 'Node':
#         # recursive
        
#         if not head:
#             return None
        
#         pcur, pnext, pprev, pchild = head, head.next, head.prev, head.child
        
#         while not pchild and pnext:
#             print("cur:", pcur.val)
#             pprev = pcur
#             pcur = pnext
#             pnext = pnext.next
#             if pcur:
#                 pchild = pcur.child
      
    
    
  #        if pchild:
#             print("child:", pchild.val)
#             child_node = self.flatten(pchild)
#             origin_child_node = child_node
        
#             while child_node.next:
#                 child_node = child_node.next
#             # now child_node is the last node

#             pprev.next = origin_child_node
#             origin_child_node.prev = pprev

#             child_node.next = pnext

#         return head

#     def flatten(self, head):
#         if not head:
#             return 
#         stk=[head]
#         prev=Node(0)
#         while stk:
#             root=stk.pop()
#             root.prev=prev
#             prev.next=root
#             prev=root
#             if root.next:
#                 stk.append(root.next)
#             if root.child:
#                 stk.append(root.child)
#                 root.child=None
                
#         head.prev=None
#         return head
    
    def flatten(self, head):
        if not head:
            return 
        
        q, dummy = [head], Node(-1, None, head, None)
        pprev = dummy
        
        while q:
            cur_node = q.pop()
            
            if cur_node:
                q.append(cur_node.next)
                pprev.next = cur_node
                cur_node.prev = pprev # do not forget this is double link
                
                if cur_node.child:
                    q.append(cur_node.child)
                    cur_node.child = None # must reset this or it loops
                    
                pprev = cur_node
                    
        dummy.next.prev = None # do not forget dummy reset
        return dummy.next