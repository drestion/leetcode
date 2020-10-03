# class Solution:
#     def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        # 13:50
        # 14:56
#         root = {}
#         for word in words:
#             node = root
#             for c in word:
#                 node = node.setdefault(c, {})
#             node[None] = True
            
#         board = {i + 1j*j: c
#                  for i, row in enumerate(board)
#                  for j, c in enumerate(row)}

#         found = []
#         def search(node, z, word):
#             if node.pop(None, None):
#                 found.append(word)
#             c = board.get(z)
#             if c in node:
#                 board[z] = None
#                 for k in range(4):
#                     search(node[c], z + 1j**k, word + c)
#                 board[z] = c
#         for z in board:
#             search(root, z, '')

#         return found

class TrieNode():
    def __init__(self):
        self.children = collections.defaultdict(TrieNode)
        self.isWord = False
    
class Trie():
    def __init__(self):
        self.root = TrieNode()
    
    def insert(self, word):
        node = self.root
        for w in word:
            node = node.children[w]
        node.isWord = True
    
    def search(self, word):
        node = self.root
        for w in word:
            node = node.children.get(w)
            if not node:
                return False
        return node.isWord
    
class Solution(object):
    def findWords(self, board, words):
        res = []
        trie = Trie()
        node = trie.root
        for w in words:
            trie.insert(w)
        for i in range(len(board)):
            for j in range(len(board[0])):
                self.dfs(board, node, i, j, "", res)
        return res
    
    def dfs(self, board, node, i, j, path, res):
        if node.isWord:
            res.append(path)
            node.isWord = False
        if i < 0 or i >= len(board) or j < 0 or j >= len(board[0]):
            return 
        tmp = board[i][j]
        node = node.children.get(tmp)
        if not node:
            return 
        board[i][j] = "#"
        self.dfs(board, node, i+1, j, path+tmp, res)
        self.dfs(board, node, i-1, j, path+tmp, res)
        self.dfs(board, node, i, j-1, path+tmp, res)
        self.dfs(board, node, i, j+1, path+tmp, res)
        board[i][j] = tmp