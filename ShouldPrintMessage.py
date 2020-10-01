class Logger:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.q = {}
        

    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        """
        Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity.
        """
        if self.q.get(message, -1) < timestamp: # can be <= but timestamp should plus 10
            self.q[message] = timestamp + 9
            return True
        return False        
            

#     def __init__(self):
#         self.ok = {}

#     def shouldPrintMessage(self, timestamp, message):
#         if timestamp < self.ok.get(message, 0):
#             return False
#         self.ok[message] = timestamp + 10
#         return True

# Your Logger object will be instantiated and called as such:
# obj = Logger()
# param_1 = obj.shouldPrintMessage(timestamp,message)