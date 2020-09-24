class Solution:
    def isPalindrome(self, s: str) -> bool:
        # several methods:
        # method 1, two pointer
        # time complexity O(n)
        # speace complexity O(1)
        length = len(s)
        
        l, r = 0, length-1
        
        while l < r:
            la, ra = s[l].isalnum(), s[r].isalnum()
            if la and ra:
                if s[l].lower() == s[r].lower():
                    l += 1
                    r -= 1
                else:
                    return False
            elif la:
                r -= 1
            else:
                l += 1
                
        return True