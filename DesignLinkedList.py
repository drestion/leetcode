class ListNode:
    def __init__(self, val, next):
        self.val = val
        self.next = next

class MyLinkedList:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.head = None
        self.dummy = ListNode(0, self.head)
        # another strategy is to add self.size

    def get(self, index: int) -> int:
        """
        Get the value of the index-th node in the linked list. If the index is invalid, return -1.
        """
        cnt = -1
        p = self.head
        while p:
            cnt += 1
            if cnt == index:
                return p.val
            p = p.next
            
        return -1
    
    def addAtHead(self, val: int) -> None:
        """
        Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
        """
        node = ListNode(val, self.head)
        self.head = node
        self.dummy.next = self.head

    def addAtTail(self, val: int) -> None:
        """
        Append a node of value val to the last element of the linked list.
        """
        
        if not self.head:
            self.head = ListNode(val, None)
            self.dummy.next = self.head
            return
        
        p = self.head
        while p and p.next:
            p = p.next
        
        p.next = ListNode(val, None)

        

    def addAtIndex(self, index: int, val: int) -> None:
        """
        Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
        """
        p = self.dummy
        cnt = -1
        while p and cnt < index:

            if cnt == index - 1:
                node = ListNode(val, p.next)
                p.next = node
                
            cnt += 1
            p = p.next
        self.head = self.dummy.next
        

    def deleteAtIndex(self, index: int) -> None:
        """
        Delete the index-th node in the linked list, if the index is valid.
        """
        p = self.dummy
        cnt = -1
        while p and p.next and cnt < index:

            if cnt == index - 1:
                p.next = p.next.next
                
            cnt += 1
            p = p.next
        self.head = self.dummy.next
        
        
        


# Your MyLinkedList object will be instantiated and called as such:
# obj = MyLinkedList()
# param_1 = obj.get(index)
# obj.addAtHead(val)
# obj.addAtTail(val)
# obj.addAtIndex(index,val)
# obj.deleteAtIndex(index)