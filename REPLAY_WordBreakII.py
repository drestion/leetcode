class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> List[str]:
        
#         def search(s, wordDict, seen_sentences):
#             len_w = len(s)

#             i,j=0,0
#             res = []
#             sentences = 0


#             for i in range(len_w):
#                 for j in range(len_w+1):
#                     if s[i:j] in wordDict:
#                         if s[j:] in seen_sentences:
#                             sentences = seen_sentences[s[j:]]
#                         else:
#                             sentences = search(s[j:], wordDict, seen_sentences)
#                             seen_sentences[s[j:]] = sentences
#                         res.extend([s[i:j] + ' ' + s for s in sentences])
                     
#             return res
        
#         return search(s, wordDict, {})
        # sentences(i) returns a list of all sentences that can be built from the suffix s[i:].


        # memo = {len(s): ['']}
        # def sentences(i):
        #     if i not in memo:
        #         memo[i] = [s[i:j] + (tail and ' ' + tail)
        #                    for j in range(i+1, len(s)+1)
        #                    if s[i:j] in wordDict
        #                    for tail in sentences(j)]
        #     return memo[i]
        # return sentences(0)
        
            """
    :type s: str
    :type wordDict: Set[str]
    :rtype: List[str]
    """
            return self.helper(s, wordDict, {})
        
    def helper(self, s, wordDict, memo):
        if s in memo: return memo[s]
        if not s: return []

        res = []
        for word in wordDict:
            if not s.startswith(word):  # it must start with the word, this is a infor you should utilize
                continue
            if len(word) == len(s):
                res.append(word)
            else:
                resultOfTheRest = self.helper(s[len(word):], wordDict, memo)
                for item in resultOfTheRest:
                    item = word + ' ' + item
                    res.append(item)
        memo[s] = res
        return res