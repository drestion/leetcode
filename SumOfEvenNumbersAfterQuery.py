class Solution:
    def sumEvenAfterQueries(self, A: List[int], queries: List[List[int]]) -> List[int]:
        asum_even = sum([n for n in A if not n%2])
        res = []
        
        for q in queries:
            ori_a = A[q[1]]
            new_a = ori_a + q[0]
            A[q[1]] = new_a
            
            if not new_a % 2 and not ori_a % 2:
                asum_even += new_a - ori_a
            elif new_a % 2 and not ori_a % 2:
                asum_even -= ori_a
            elif not new_a % 2 and ori_a % 2:
                asum_even += new_a
                
            res.append(asum_even)
                
        return res
        