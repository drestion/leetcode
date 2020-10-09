class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        # 12:02pm
        
        # similar to number of ways to climb ladder
        
        dp = [0]*len(days)
        
#         dp[0] = costs[0]
        
#         for i in range(1, len(days)):
#             if 1 <= days[i] - days[i-1] < 7:
#                 c1 = costs[1] # buy a single 7 day pass
#                 c2 = 2*costs[0] # buy two single day  pass
#                 dp[i-1][0] # no need to buy
#                 dp[i-1][1] need to buy
#                 dp[i] = min(c1, c2) + dp[i-1] + dp[i-2]
#             elif 7 <= days[i] - days[i-1] < 30:
#                 c1 = costs[2] # buy a single 30 day pass
#                 c2 = 2*costs[0]
#                 dp[i] = min(c1, c2) + dp[i-1]
#             else:
#                 dp[i] = dp[i-1] + 2*costs[0]
                
#         print(dp)
#         return dp[-1]

        # you must 
    
        # think forward is natural for this
    
    
        #  dp=[0 for i in range(days[-1]+1)]
        #     for i in range(days[-1]+1):
        #          if i not in days:
        #             dp[i]=dp[i-1]  # do not buy tickets
        #          else:
        #             dp[i]=min(dp[max(0,i-7)]+costs[1],dp[max(0,i-1)]+costs[0],dp[max(0,i-30)]+costs[2])
        # return dp[-1]