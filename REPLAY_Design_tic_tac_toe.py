class TicTacToe:
    
    # the key observation is that the winner must occupy all rows or all columns (like the diagnal case)
    def __init__(self, n: int):
        """
        Initialize your data structure here.
        """
        count = collections.Counter()
        def move(row, col, player):
            for i, x in enumerate((row, col, row+col, row-col)):  # could not understand row+col
                count[i, x, player] += 1
                if count[i, x, player] == n:
                    return player
            return 0
        self.move = move

    def move(self, row: int, col: int, player: int) -> int:
        """
        Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins.
        """
        


# Your TicTacToe object will be instantiated and called as such:
# obj = TicTacToe(n)
# param_1 = obj.move(row,col,player)