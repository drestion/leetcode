class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        # use counter to get freq
        # first, get the freq for every item
        freq = collections.defaultdict(list)
        
        for item, cnt in Counter(nums).items():
            freq[cnt].append(item)
        print(freq)
        # now, the most frequent item in the list can only be len(nums)
        # so we append them to the result, and then return result[:k]
        result = []
        
        for n in reversed(range(len(nums) + 1)): 
            # print(n)
            result.extend(freq[n]) # if this cnt is empty, we append nothing
            
        return result[:k]      
    

    