class Solution:
    def minRemoveToMakeValid(self, s: str) -> str:
        # 13:15pm
        # 13:26pm
        
        # i dont really understand why this is called "minimal" number of parenthesis to remove
        
        stack = []
        
        for i in range(len(s)):
            c = s[i]
            if c == '(':
                stack.append((c, 1, i))
            elif c == ')':
                if not stack:
                    stack.append((c, -1, i))
                else:
                    if stack[-1][0] == '(':
                        stack.pop()
                    else:
                        stack.append((c, -1, i))
                        
        to_del = list(map(lambda x: x[2], stack))
        return ''.join([s[i] for i in range(len(s)) if i not in to_del])