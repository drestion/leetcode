class Solution:
    def groupAnagrams(self, strs):
        # official solution
        # the key about anagram is
        # same length, the same after sorting.
        # dict is a great tool
        d = {}
        for w in (strs):
            key = tuple(sorted(w))
            d[key] = d.get(key, []) + [w]
        return d.values()

#     def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
#         # first sort them by length
#         # then sort each one by alphbical
#         # can be recursive
        
#         length, ind = len(strs), 1
#         original_dict = {}
#         result, cur_group, alpha_sorted = [], [], []
        
#         if length == 1:
#             return [strs]
        
#         for i in range(length):
#             t = ''.join(sorted(strs[i]))
#             alpha_sorted += [t]
#             original_dict[t] = i
            
#         sorted_by_length = sorted(alpha_sorted)
        
#         cur_group += [0]
#         while ind < length:
#             if sorted_by_length[cur_group[-1]] == sorted_by_length[ind]:
#                 cur_group += [ind]
#             else:
#                 print(cur_group)
#                 result += [[strs[original_dict[sorted_by_length[i]]] for i in cur_group]]
#                 cur_group = [ind]
#             ind += 1            
        
#         return result
    

        
        