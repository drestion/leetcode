class Solution:
    def findDuplicate(self, paths: List[str]) -> List[List[str]]:
        if not paths:
            return []
        
        n_paths = []
        
        
        for p in paths:
            tokens = p.split(' ')
            n_paths += [ tokens[0] +" " + t for t in tokens[1:]]
        
        
        paths = n_paths
        length = len(paths)
        result = []
        
        paths.sort(key= lambda x: x.split('(', 1)[1])
        cur_result = [paths[0]]
        
        for i in range(1, length):
            s1 = paths[i].split('(', 1)
            s2 = cur_result[-1].split('(', 1)
            
            if s1[1] == s2[1]:
                cur_result += [paths[i]]
            else:
                result += [cur_result]
                cur_result = [paths[i]]
                
        if cur_result:
            result += [cur_result]
        
        # learned these list functions really well today
        return list(map(lambda x: map(lambda y: y.split('(', 1)[0].replace(' ','/'), x), filter(lambda z: len(z) > 1, result)))
