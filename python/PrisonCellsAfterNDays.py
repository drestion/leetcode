class Solution:
    def prisonAfterNDays(self, cells: List[int], N: int) -> List[int]:
#         # brutal force
#         for i in range(N):
#             n_cells = list(cells)
#             n_cells[0] = 0
#             for c in range(1, len(cells) - 1):
#                 n_cells[c] = 1 if cells[c-1] == cells[c+1] else 0
#             n_cells[len(cells) - 1] = 0
#             cells = n_cells
        
#         return cells
        # since the number is limited, there will be cycles
        # we have to do this until we find the cycle starting point b
        # then we know that the reuslt is checked_cells[N % b]
        length = len(cells)
        checked_cells, mutated = {}, {}
        mutated_cells = list(cells)
        
        for i in range(N):
            print(i)
            mutated_cells = self.mutate(mutated_cells)
            print(mutated_cells)
            if str(mutated_cells) in checked_cells:
                loop_length = i - checked_cells[str(mutated_cells)] + 1
                return mutated[(N-i - 1)%(loop_length)]
            checked_cells[str(mutated_cells)] = True
            mutated[i] = list(mutated_cells)
        
        return mutated_cells
        
        
    def mutate(self, cells):
        length = len(cells)
        result = [0] + list(cells[1:-1]) + [0]
        
        for i in range(1, length - 1):
            result[i] = int(cells[i-1] == cells[i+1])
            
        return result
#     def next_step(self, cells):
#         res = [0] * 8
#         for i in range(1,7):
#             res[i] = int(cells[i-1] == cells[i+1])
#         return res
    
#     def prisonAfterNDays(self, cells, N):
#         found_dic = {}
#         for i in range(N):
#             cells_str = str(cells)
#             if cells_str in found_dic:
#                 loop_len = i - found_dic[cells_str]
#                 return self.prisonAfterNDays(cells, (N - i) % loop_len)
#             else:
#                 found_dic[cells_str] = i 
#                 cells = self.next_step(cells)
#                 print(i)
#                 print(cells)
                
#         return cells