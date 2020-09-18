class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        diff_dict = {}
        
        # We can also do this in one pass
        # to leverage the mutual A<->B => B<=>A
        

        # Use storage to trade for time
        # apparently you need to scan at least two numbers
        # so O(n) without memory is impossible
        for i in range(len(nums)):
            diff_dict[nums[i]] = i 
            
        for i in range(len(nums)):
            d = target-nums[i]
            if (d in diff_dict.keys()):
                if (diff_dict[d] != i):
                    return [i, diff_dict[target-nums[i]]]
        
        return None
        