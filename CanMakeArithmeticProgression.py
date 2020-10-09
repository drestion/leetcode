class Solution:
    def canMakeArithmeticProgression(self, arr: List[int]) -> bool:
        
        arr.sort()
        
        return all([(j-i) == arr[1] - arr[0] for i, j in zip(arr, arr[1:])])

        