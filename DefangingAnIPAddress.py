class Solution:
    def defangIPaddr(self, address: str) -> str:
        return address.replace('.', '[.]')
        
#         result= []
        
#         for c in address:
#             if c == '.':
#                 result.extend(['[','.',']'])
#             else:
#                 result.append(c)
        
#         return ''.join(result)
            