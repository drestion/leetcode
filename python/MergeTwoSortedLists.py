# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        # two pointer
        h, pl1, pl2 = ListNode(), l1, l2
        oh = h
        
        while pl1 and pl2:
            if pl1.val <= pl2.val:
                h.next = pl1
                h = h.next
                pl1 = pl1.next
            else:
                h.next = pl2
                h = h.next
                pl2 = pl2.next

#         while pl1:
#             h.next = pl1
#             h = h.next
#             pl1 = pl1.next
            
#         while pl2:
#             h.next = pl2
#             h = h.next
#             pl2 = pl2.next

        h.next = pl1 or pl2
        
        return oh.next