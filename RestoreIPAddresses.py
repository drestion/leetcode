class Solution:
    def restoreIpAddresses(self, s: str) -> List[str]:
        # BFS
        #4:32pm
        #5:08pm
        
        def dfs(s, numbers_so_far, res):
            if s and len(numbers_so_far) == 4:
                return
            
            if not s and len(numbers_so_far) == 4:
                res.append('.'.join(numbers_so_far))
                return 
            
            for i in range(1,4):
                if s[:i] == '0' or (s[0] != '0' and 0 < int(s[:i]) < 256 ):
                    dfs(s[i:], numbers_so_far + [s[0:i]], res)
                        
        res = []
        ga = dfs(s, [], res)
        
        
        return set(res)
        
#     def restoreIpAddresses(self, s):
#         res = []
#         self.dfs(s, 0, "", res)
#         return res
    
#     def dfs(self, s, idx, path, res):
#         if idx > 4:
#             return 
#         if idx == 4 and not s:
#             res.append(path[:-1])
#             return 
#         for i in range(1, len(s)+1):
#             if s[:i]=='0' or (s[0]!='0' and 0 < int(s[:i]) < 256):
#                 self.dfs(s[i:], idx+1, path+s[:i]+".", res)