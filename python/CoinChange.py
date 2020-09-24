class Solution:
#     def coinChange(self, coins: List[int], amount: int) -> int:
#         dp = [-2**32]*(amount+1)
        
#         coins = sorted(coins)
        
#         for c in coins:
#             dp[c] = 1
        
#         for i in range(1, amount+1):
#             if dp[i] < 0:
#                 min_coin = 2**32
#                 for j in range(1, i):
#                     min_coin = min(min_coin, dp[amount - j])
#                 dp[i] = min_coin + 1
        
#         return dp[amount]


      def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [0] + [2**32]*(amount)
            
        for i in range(1, amount + 1):
            ga = [dp[i - j] for j in coins if i - j >= 0 and dp[i - j] < 2**32]
            dp[i] = min(ga) + 1 if ga else 2**32
            
        return dp[-1] if dp[-1] < 2**32 else -1
    
    
    # def coinChange(self, coins: 'List[int]', amount: 'int') -> 'int':
    #     dp = [0] + [float('inf') for i in range(amount)]
    #     for i in range(1, amount+1):
    #         for coin in coins:
    #             if i - coin >= 0:
    #                 dp[i] = min(dp[i], dp[i-coin] + 1)
    #     if dp[-1] == float('inf'):
    #         return -1
    #     return dp[-1]