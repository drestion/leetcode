class Solution:
    def myPow(self, x: float, n: int) -> float:
        # pow[n] = pow[n/2] * pow[n/2]
        
        # memory limit
#         k = n
#         if n < 0:
#             k = -n
#         po = [1] + [x]*(k//2)
#         # print(len(po))
       
#         # overflow?
#         for i in range(2, k+1):
#             # print(i, i//2)
#             if i%2: # n is odd
#                 po[i] = po[i-1]*x
#             else:   # n is even
#                 # print('even')
#                 po[i] = po[i//2] * po[i//2]
        
#         return po[k] if n >=0 else 1/po[k]

        if n == 0: return 1
        if n == 1: return x
        
        k = n
        if n < 0:
            k = -n
            
        if k % 2:
            r = self.myPow(x, k - 1) * x
            return r if n > 0 else 1/r
        else:
            r = self.myPow(x, k // 2)
            return r*r if n > 0 else 1/(r*r)
        
        
    # def myPow(self, x, n):
        if not n:
            return 1
        if n < 0:
            return 1 / self.myPow(x, -n)
        if n % 2:
            return x * self.myPow(x, n-1)
        return self.myPow(x*x, n/2)
    
    
