# The guess API is already defined for you.
# @param num, your guess
# @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
# def guess(num: int) -> int:

class Solution:
    def guessNumber(self, n: int) -> int:
        # binary search
        
        
        lo, hi = 1, n
        
        while lo <= hi:
            mid = (lo + hi) // 2
            num = guess(mid)
            if not num:
                return mid
            elif num > 0:
                lo = mid + 1
            else:
                hi = mid - 1
        
        return None