class Solution:
    def isAlienSorted(self, words: List[str], order: str) -> bool:
        # basically compare the sorted words 
        
        
        m = {c: i for i, c in enumerate(order)}
        words = [[m[c] for c in w] for w in words]
        return all(w1 <= w2 for w1, w2 in zip(words, words[1:]))  # notice that w1 < w2 saves you tons of time!
                                                                # also notice zip(n, n[1:]) instead of n[i] n[i+1]