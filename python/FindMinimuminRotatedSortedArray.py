class Solution:
    def findMin(self, nums: List[int]) -> int:
        # divide and counquer
        # [[3,1,2],4, [5,6]]
        #  [3, 1, 2] => 1
        # it only needs value, not index

        # can also implment in non-rescursive way 
        # using the standard while loop
        
        index = self.findMinHelper(nums)
        if index >= 0:
            return nums[index]
        return nums[0]
        
    def middle(self, nums: List[int]) -> int:
        return int(len(nums)/2)
        
    def findMinHelper(self, nums: List[int]) -> int:
        # return -1 if not found
        length = len(nums)
        
        if length  <= 1:
            return -1
        
        mid = self.middle(nums)
        left, right = nums[0:mid], nums[mid:]  
        if left[-1] > right[0]:
            return mid
        
        left_min_ind = self.findMinHelper(left)
        if left_min_ind > 0:
            return left_min_ind
        
        right_min_ind = self.findMinHelper(right)
        if right_min_ind > 0:
            return right_min_ind + mid
        
        return 0 # the array is not pivoted