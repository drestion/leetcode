class Solution:
#     def maxProfit(self, prices: List[int]) -> int:
#         #brutal force O(n2)
#         #target is max_proft = num(j) - num(i)
#         #return max(max_profit)
#         max_profit = 0
        
#         for i, m in enumerate(prices):
#             for j, n in enumerate(prices):
#                 if j > i:
#                     nm = n - m
#                     if nm > max_profit:
#                         max_profit = nm
        
#         return max_profit

    def maxProfit(self, prices: List[int]) -> int:
        #brutal force
        #target is max_proft = num(j) - num(i)
        #return max(max_profit)
        #start: 11:13
        #end: 11:23
        
        #solution: two-pointer
        #solution: kidane's algorithm
        #solution: DP
        import sys
        
        max_profit = -sys.maxsize
        c_profit = max_profit
        min_price = sys.maxsize 
        
        if len(prices) < 2:
            return 0
        
        for i, n in enumerate(prices):
            if min_price > n :
                min_price = n
            else:
                c_profit = n - min_price
                if c_profit > max_profit:
                    max_profit = c_profit
        
        if max_profit < 0:
            max_profit = 0
            
        return max_profit