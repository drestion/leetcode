# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def rotateRight(self, head: ListNode, k: int) -> ListNode:
        # first, optimize by k % len(list)
        # use three pointers, one to the end, one to the k-1, one k
        
            # assume k < len(head)
#         if not head:
#             return head
#         pend, pk, pprev = head, head, head
#         cnt, ind = -1, 0
            
#         while pend:
#             cnt += 1
#             pend = pend.next
        
#         k = k % cnt
        
#         while ind + k < cnt:
#             pprev = pk
#             pk = pk.next
#             ind += 1
                
#         pend.next = head
#         pprev.next = None
            
#         return pk
        
#         # whenever you talk about Kth place in a list, consider two pointer
#         if not head:
#             return head
        
#         slow, fast, cnt = head, head, 0
        
#         while fast:
#             cnt += 1
#             fast = fast.next
#         print('len:', cnt)
#         k = k%cnt
#         print('after mod k', k)
#         fast = head
        
#         while fast and k:
#             i = k
#             while i > 0 and fast:
#                 fast = fast.next
#                 i -= 1
            
#             if i == 0:
#                 print('moved slow forward')
#                 slow = slow.next
        
#         nhead, result = slow.next, slow.next
#         slow.next = None
#         while nhead.next:
#             nhead = nhead.next
        
#         nhead.next = head
        
#         return result
            
#         n, pre, current = 0, None, head
#         while current:
#             pre, current = current, current.next  # I like this
#             n += 1

#         if not n or not k % n:
#             return head

#         tail = head
#         for _ in range(n - k % n - 1):
#             tail = tail.next

#         pnext, tail.next, pre.next = tail.next, None, head
#         return pnext
    
        if not head:
            return head
        
        dummy=ListNode(0)
        dummy.next=head
        fast=dummy
        slow=dummy

            
        i, j = 0, 0
        while fast.next:
            i += 1
            fast = fast.next
            
        j = i - k%i # in case k = a*i + b, j = i - b
        
        while j > 0:
            j -= 1
            slow = slow.next
        
        fast.next = dummy.next
        dummy.next = slow.next
        slow.next = None

        return dummy.next;
    
    
    
    
    
    
    
    
    