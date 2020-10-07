class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        # 7:00PM
        
        # dp or BFS
        # dp[amount] = sum(dp[amount - c] for c in coins)
        
        dp = [1]+[0]*amount
        
        for a in range(1, amount+1):
            dp[a] = sum(dp[a - c] for c in coins if a - c >= 0)
        
        print(dp)
        return dp[amount]


        # dp = [0] * (amount + 1)
        # dp[0] = 1
        # for i in coins:
        #     for j in range(1, amount + 1):
        #        if j >= i:
        #            dp[j] += dp[j - i]
        # print(dp)
        # return dp[amount]