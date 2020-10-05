class Solution:
    def snakesAndLadders(self, board: List[List[int]]) -> int:
        # can we turn this into a 1d problem?
        
        board1d = []
        flip = False
        for row in reversed(range(len(board))):
            b = [board[row][col] for col in range(len(board[0]))]
            if flip:
                b = b[::-1]
            board1d += b
            flip = not flip
        print(board1d)
        min_steps =2**32
        def move(start, board1d, n, steps_so_far):
            if start - 1 == n*n:
                min_steps =min(min_steps, steps_so_far + 1)
                return steps_so_far + 1, True
            print('start', start)
            next_start = board1d[start-1]
            
            if next_start > 0:
                for i in range(1,7):
                    steps_to_take, goal = move(next_start+i, board1d, n, steps_so_far + 1) 
                    if goal:
                        min_steps =min(min_steps, steps_so_far + 1)
                        return steps_to_take, True
                return steps_to_take, False
            else:
                for i in range(1,7):
                    steps_to_take, goal = move(start+i, board1d, n, steps_so_far + 1) 
                    if goal:
                        min_steps =min(min_steps, steps_so_far + 1)
                        return steps_to_take, True
                return steps_to_take, False
        
        steps, goal = move(1, board1d, len(board), 0)
        if goal:
            return min_steps
        return -1
            