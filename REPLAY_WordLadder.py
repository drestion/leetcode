class Solution:
    
    def ladderLength(self, beginWord, endWord, wordDict):
        #13:21
        # 13:26
        wordList = set(wordDict)
        queue = collections.deque([[beginWord, 1]]) # do you really need double queue? 
        while queue:
            word, length = queue.popleft() # queue can be used as way to traverse the graph
            if word == endWord:
                return length
            for i in range(len(word)):
                for c in 'abcdefghijklmnopqrstuvwxyz':
                    next_word = word[:i] + c + word[i+1:]
                    if next_word in wordList:
                        wordList.remove(next_word)
                        queue.append([next_word, length + 1])
        return 0
#     def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
#         # start from the end
#         # first, the endword must be in the dictionary
#         # then, sort the rest of the words by difference to the endword
#         # if the word of the last sorted words is 2 steps away, then impossible
#         # if it is one step away, repeat the steps in the rest of the dictonary
#         # after removing all words in the same group
#         # when the dictionary has only one word left
#         # if its difference with the beginword is 1, then return the sequence
        
#         if endWord not in wordList:
#             return 0
#         print(endWord+' is in '+str(wordList))
#         length = len(wordList)
#         if beginWord in wordList and self.diffLen(beginWord, endWord) == 1:
#             return 2
        
#         nlist = [w for w in wordList if w!=endWord]
#         nlist_diff_len = defaultdict(list)
        
#         for w in nlist:
#             nlist_diff_len[self.diffLen(endWord, w)].append(w)
        
#         if not nlist_diff_len[1]:
#             return 0
        
#         min_len = 2**32
#         for n_endword in nlist_diff_len[1]:
#             n_wordList = [n_endword] + nlist_diff_len[2] + nlist_diff_len[3] 
#             n_len = self.ladderLength(beginWord, n_endword, n_wordList)
#             if n_len > 0:
#                 min_len = min(min_len, n_len)
        
#         return 0 if min_len == 0 else min_len + 1
        
        
#     def diffLen(self, w1, w2):
#         return sum([i!=j for i, j in zip(w1, w2)])
        