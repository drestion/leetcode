# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        # 15:35
        # 15:50
        # reversing the list should be easier
        # similar to add two numbers i
        
       # or just stack
    
        l1_s, l2_s = [], []
        
        while l1:
            l1_s.append(l1.val)
            l1 = l1.next
        
        while l2:
            l2_s.append(l2.val)
            l2 = l2.next
            
        prev, curr, carry, head, total = 0, 0, 0, None, 0
        
        while l1_s or l2_s or carry:
            if l1_s:
                total += l1_s.pop()
            if l2_s:
                total += l2_s.pop()
            total += carry
            
            cval, nval = divmod(total, 10)
            
            if not head:
                head = ListNode(nval)
            else:
                node = ListNode(nval, head)
                head = node
                
            carry = cval  
            total = 0
        
        return head
            
        