class Solution:
    def topKFrequent(self, words: List[str], k: int) -> List[str]:
        # O(NLOGN) is trivial, just sort and dedeup
        # Or use counter
        s = Counter(words)
        return sorted(s, key=lambda x: (-s[x], x) )[0:k]