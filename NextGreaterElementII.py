class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        # 10:39am
        # 10:50am
        
        ext_nums, num_len, res = nums + nums, len(nums), []
        
        for i in range(num_len):
            nxlarge = nums[i]
            for j in range(i+1, num_len + i):
                if ext_nums[j] > nxlarge:
                    res.append(ext_nums[j])
                    nxlarge = ext_nums[j]
                    break
            if nxlarge == nums[i]:
                res.append(-1)
                
        return res