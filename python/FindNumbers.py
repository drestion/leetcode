class Solution:
    def findNumbers(self, nums: List[int]) -> int:
       
        def numDigit(n):
            d = 0
            while n > 0:
                d += 1
                n  = int(n/10) # this differs from C java
            return d
        
        return len(list(filter(lambda x: numDigit(x) % 2 == 0, nums)))