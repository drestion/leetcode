# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        
        def add(l1, l2, carry):
            l1v, l2v, lp, rp = 0, 0, l1, l2
            
            if l1:
                l1v = l1.val
                lp = l1.next
            if l2:
                l2v = l2.val
                rp = l2.next
                
            if not l1 and not l2 and not carry: return None
            
            cval, nval = divmod(l1v + l2v + carry, 10)
        
            return ListNode(nval, add(lp, rp, cval))
        
        return add(l1, l2, 0)