class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        # several methods
        # dict
        
        len_s, len_t = len(s), len(t)
        if len_s != len_t:
            return False
    
        di = {}
        for i in range(len_s):
            di[s[i]] = 1 if s[i] not in di else di[s[i]] + 1
            di[t[i]] = -1 if t[i] not in di else di[t[i]] - 1
            
        return len(set(di.values())) <= 1