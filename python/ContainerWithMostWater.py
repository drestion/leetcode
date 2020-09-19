class Solution:
    def maxArea(self, height: List[int]) -> int:
        # copied the official solution
        # very obvious a two-pointer problem
        # the key is still how to move the pointer
        # still, just return the result and not the indexes
        # the idea is to gather all possible solutions, but in less time 
        # by using the information we got from the analysis
        
        length = len(height)
        
        max_water = 0
        lo, hi = 0, length-1
        
        while lo < hi:
            max_water = max(max_water, (hi-lo)*min(height[lo], height[hi]))
            
            # if the length gets smaller, the height must get heigher
            # this is the only information we can use now to reduce search space
            if height[lo] < height[hi]:
                lo += 1
            else:
                hi -= 1
        
        return max_water