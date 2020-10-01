class Solution:
    def validMountainArray(self, A: List[int]) -> bool:
        
        length, i = len(A), 0
        
        # while A[i] < A[i+1] and i < length: # do not do this
        while i < length - 1 and A[i] < A[i+1]:
            i += 1
                
        if i == length - 1 or i == 0:
            return False

        # while A[i] > A[i+1] and i < length: # do not do this
        while i < length - 1 and A[i] > A[i+1]:
            i += 1
        
        return i == length - 1