class Solution:
    
#     def canBuild(self, s, words):
#         ok = [True]
#         for i in range(1, len(s)+1):
#             ok += any(ok[j] and s[j:i] in words for j in range(i)),
#         return ok[-1]
    
    def findAllConcatenatedWordsInADict(self, words: List[str]) -> List[str]:
#         # the concatenated words must be shorter than any of the shorter words
#         # so we should sort words first
#         # then for every word starting from the end
#         # we check if it can be built using words before it
        
#         if not words or len(words) <3:
#             return []
        
        
#         result = []
#         words.sort(key=lambda x: -len(x))
#         length = len(words)
#         for i, w in enumerate(words):
#             m = i+1
#             while m < length and len(words[m]) >= len(w):
#                 m += 1
#             if self.canBuild(w, words[m:]): 
#                 result.append(w)
        
#         return result

# 8:39PM
# 8:53pm
        # w = w[i, j] + w[j, k] + ... + w[n, -1]
        # for sub w in wlist:
        #     if sub_w in list and wlist-sub_w is all ok
        #         w = True
        # w = False
        # very nice, learn the logic!
        cando = {}
        d = set(words)
        
        def dfs(word, cando):
            for i in range(1, len(word)):
                prefix = word[:i]
                suffix = word[i:]
                
                if prefix in d and suffix in d:
                    cando[word] = True
                    return True
                if prefix in d and dfs(suffix, cando):
                    cando[word] = True
                    return True
                if suffix in d and dfs(prefix, cando):
                    cando[word] = True
                    return True
            return False
        
        res = []
        for word in words:
            if dfs(word, cando):
                res.append(word)
        
        return res
    