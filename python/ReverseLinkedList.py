# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
#     def reverseList(self, head: ListNode) -> ListNode:
#         # the key concept here is the prev_node = None
#         prev_node = None
#         curr_node = head
        
#         while curr_node:
#             temp_node = curr_node.next
#             curr_node.next = prev_node
#             prev_node = curr_node
#             curr_node = temp_node
            
#         return prev_node


# class Solution:
# @param {ListNode} head
# @return {ListNode}
# def reverseList(self, head):
#     return self._reverse(head)

# def _reverse(self, node, prev=None):
#     if not node:
#         return prev
#     n = node.next
#     node.next = prev
#     return self._reverse(n, node)



    def reverseList(self, head: ListNode) -> ListNode:
        # the key concept here is the prev_node = None
        # recursive
        return self._reverse(head)
    
    def _reverse(self, head, prev = None):
        if not head:
            return prev
        temp = head.next
        head.next = prev
        return self._reverse(temp, head)
    # def reverseList(self, head):
    #     prev = None
    #     while head:
    #         curr = head
    #         head = head.next
    #         curr.next = prev
    #         prev = curr
    #     return prev
            