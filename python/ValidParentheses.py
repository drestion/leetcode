class Solution:
    def isValid(self, s: str) -> bool:
        # as long as you found a pair, close it
        # after string is scanned, close the leftover
        # if you can close everyone, then it is good
        arr = []
        
        for c in s:
            if not arr or not self.match(arr[-1], c):
                arr += [c]
            else:
                arr.pop(-1)
        
        for i in range(0, len(arr) - 1, 2):
            if not self.match(arr[i], arr[i+1]):
                return False
        
        return not len(arr) % 2

            
    def match(self, s1, s2):
        return (s1 == '(' and s2 ==')') or \
               (s1 == '{' and s2 =='}') or \
               (s1 == '[' and s2 ==']')