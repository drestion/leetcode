class Solution:
    def shuffle(self, nums: List[int], n: int) -> List[int]:
        # 5:04pm
        # 5:10pm
        
        return [e for l in zip(nums[0:n], nums[n:]) for e in l]