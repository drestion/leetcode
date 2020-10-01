# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def hasCycle(self, head: ListNode) -> bool:
        if not head:
            return False
        
        slow, fast = head, head
        
        while slow and fast:
            slow = slow.next
            fast = fast.next
            if fast:
                fast = fast.next
            if slow and fast and slow.val == fast.val: # always check if pointer is valid
                return True
        
        return False
        