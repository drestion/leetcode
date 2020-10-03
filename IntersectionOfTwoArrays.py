class Solution:
    def intersection(self, nums1: List[int], nums2: List[int]) -> List[int]:
        # one liner
        return list(set(nums1).intersection(nums2))