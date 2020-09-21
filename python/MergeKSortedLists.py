# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
#     def mergeKLists(self, lists: List[ListNode]) -> ListNode:
#         # brutal force?
#         # 4500ms
#         result = None
        
#         for l in lists:
#             result = self.merge(result, l)
            
#         return result
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        # divide and counquer
        # 150ms
        length = len(lists)
        # stop condition
        if length == 0:
            return None
        if length == 1:
            return self.merge(None, lists[0])
        mid = int(length/2)
        # recursive
        l = self.mergeKLists(lists[0:mid])
        r = self.mergeKLists(lists[mid:])
        
        return self.merge(l, r)
    
    def merge(self, l1, l2):
        result = ListNode()
        pr, pl1, pl2 = result, l1, l2
        
        while pl1 and pl2:
            if pl1.val >= pl2.val:
                pr.next = pl2
                pr = pr.next
                pl2 = pl2.next
            else:
                pr.next = pl1
                pr = pr.next
                pl1 = pl1.next
        
        pr.next = pl1 or pl2
        
        return result.next
    
