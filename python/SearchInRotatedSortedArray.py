class Solution:
    def search(self, nums: List[int], target: int) -> int:
        # divide and counquer
        # return -1 if not found
        length = len(nums)
        
        if length  < 1:
            return -1
        if length == 1:
            print('length == 1')
            if nums[0] == target:
                return 0
            else:
                print('not found')
                return -1

        mid = self.middle(nums)
        print('in mid:'+str(nums[mid]))    
        if nums[mid] == target:
            return mid
        print('mid not found')
        left, right = nums[0:mid], nums[mid:]  
        if left[-1] > right[0]:
            # the middle is the pivot point
            if left[-1] < target:
                return -1
            elif target > right[-1]:
                print('search left after pivot')
                return self.search(left, target)
            elif right[0] > target:
                return -1
            else:
                print('search right after pivot')
                n = self.search(right, target)
                if n >= 0 :
                    return n + mid
                return -1
        else:
            print('not pivot point')
            # the middle is not pivot point
            left_min_ind = self.search(left, target)
            if left_min_ind >= 0:
                return left_min_ind
            
            # did not find in left
            # search in right
            right_min_ind = self.search(right, target)
            if right_min_ind >= 0:
                return right_min_ind + mid
            # did not find in both sides
            return -1

    def middle(self, nums: List[int]) -> int:
        return int(len(nums)/2)
        
    