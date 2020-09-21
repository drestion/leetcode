class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        # maintain a string ending at s[i] that is unique
        length = len(s)
        
        if not s:
            return 0
        if length == 1:
            return 1
        
        dp, cur_str, max_len = [0]*length, s[0], -1
        dp[0] = 1
        
        for i in range(1, length):
            if s[i] not in cur_str:
                dp[i] = dp[i-1] + 1
                cur_str += s[i]
            else:
                if s[i] == s[i-1]:
                    dp[i] = 1
                    cur_str = s[i]
                else:
                    s_ind = cur_str.index(s[i])
                    dp[i] = len(cur_str) - s_ind
                    cur_str = cur_str[s_ind+1:] + s[i]
            
            max_len = max(max_len, dp[i])
            
        return max_len