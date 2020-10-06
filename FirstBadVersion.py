# The isBadVersion API is already defined for you.
# @param version, an integer
# @return an integer
# def isBadVersion(version):

class Solution:
    def firstBadVersion(self, n):
        """
        :type n: int
        :rtype: int
        """
        # binary search
        
        lo, hi = 1, n
        
        while lo <= hi:
            mid = (lo+hi) // 2
            if isBadVersion(mid):
                hi = mid - 1
            else:
                lo = mid + 1
        
         #         *
          # 1,2,3,4,5,6
          # l   m     hi    
          #       l m hi
          #       l hi
          #         lo
                    
        # 1
          # *
          # 1,2,3
          # l m hi
          # l h
         
                
        return lo